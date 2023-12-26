package com.javarush.task.task36.task3604;

// https://javarush.com/groups/posts/4165-krasno-chjernoe-derevo-svoystva-principih-organizacii-mekhanizm-vstavki
public class RedBlackTree {
    private static final Node EMPTY = new Node(0);

    static {
        EMPTY.left = EMPTY;
        EMPTY.right = EMPTY;
    }

    protected Node current;
    private Node parent;
    private Node grand;
    private Node great;
    private Node header;

    public RedBlackTree() {
        header = new Node(Integer.MIN_VALUE);
        header.left = EMPTY;
        header.right = EMPTY;
    }

    public boolean isEmpty() {
        return header.right == EMPTY;
    }

    public void clear() {
        header.right = EMPTY;
    }

    public void insert(int item) {
//        Сохраняем ссылку на header в current, parent и grand
        current = parent = grand = header;
//        Инициализируем все пустые элементы дерева (листы NIL) числом, которое мы хотим вставить
        EMPTY.element = item;
//        Итерируемся в цикле до тех пор, пока значение текущего элемента не станет равно добавляемому (item)
        while (current.element != item) {
//        Изменяем значения 4 ссылок в цикле для итерации в глубину дерева
//        (прадеда на деда, деда на отца, отца на текущий узел)
            great = grand;
            grand = parent;
            parent = current;
//        текущий узел на его правого или левого сына в зависимости от того,
//        больше ли текущий элемент добавляемого или меньше,
//        то есть идем в левое поддерево, если меньше, или в правое, если больше
            current = item > current.element ? current.right : current.left;
//          На каждой итерации проверяем левый сын текущего элемента и правый сын текущего элемента красные
            if (current.left.color == Color.RED && current.right.color == Color.RED) {
//           Если да, то вызываем метод для исправления и переориентации дерева относительно текущего элемента
//           Который записан в current на текущей итерации
                reorient(item);
            }
        }
/*  При выходе из цикла проверяем, является ли current узел пустым листом.
    Если значение добавляемого числа оказалось равно текущему узлу,
    но при этом мы не дошли до листа (current != Empty),
    значит в дереве уже существует узел с добавляемым значением и мы просто выходим из метода.
    Cобственно поэтому при каждом входе в метод, мы перезаписываем ссылки на корневой узел.*/
        if (current != EMPTY) {
            return;
        }
//      Если мы все же дошли до пустого листа, создаем новый узел и инициализируем его потомков пустыми листами
        current = new Node(item, EMPTY, EMPTY);
//      Проверяем, каким сыном будет являться текущий узел, левым или правым
        if (item < parent.element) {
            parent.left = current;
        } else {
            parent.right = current;
        }
//      красим текущий узел в красный, его листы в чёрный, а также осуществляем перебалансировку
//      в случаях, если parent оказался красным
        reorient(item);
    }

    protected void reorient(int item) {
//      Первоначально красим текущий узел, до которого мы дошли в методе insert в красный, а его потомков в черный
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;
//      Если цвет родителя current оказывается красным, то нам необходимо провести ротацию узлов
        if (parent.color == Color.RED) {
//          красим дедушку в красный
            grand.color = Color.RED;
//          Если текущий элемент левее родителя, но правее деда или наоборот, то вызываем ротацию для родителя.
//          То есть фактически определяем, какого вида балансировку применить первого или второго
            if (item < grand.element != item < parent.element) {
//          Если второго, то сначала передаем дедушку текущего элемента и осуществляем поворот влево или вправо,
//          одновременно изменяя ссылку на parent, в результате родителем станет сам current
                parent = rotate(item, grand);
            }
//          Осуществляем ротацию первого вида. Поскольку в результате такого поворота дедушка станет потомком родителя
//          текущего элемента, то нам нужно перезаписать ссылку на нашего родителя у прадедушки, поэтому мы и передаем
//          ссылку именно на прадеда. Если прадеда в нашем маленьком дереве еще нет, то на него будет указывать HEAD

//          Если балансировка идет по первому виду, то current'ом станет родитель текущего current
//          Если по второму, то current'ом будет сам вставляемый элемент, на него же будет храниться ссылка в parent
            current = rotate(item, great);
//          красим текущий узел в чёрный
            current.color = Color.BLACK;
        }
//      красим корень в черный, если в результате ротаций, например, как в сценарии № 2 дедушкой оказался корень
//      который мы ранее покрасили в красный
        header.right.color = Color.BLACK;
    }

    private Node rotate(int item, Node parent) {
        // Проверяем в каком поддереве относительно grand/great узла находится текущий элемент
//        Если меньше, значит, гарантированно в левом, если больше - в правом
        if (item < parent.element) {
//          Получаем ссылку на родителя левого поддерева
            Node node = parent.left;
//          Проверяем каким образом выполнить ротацию - справа
//          если вставляемый элемент больше, чем элемент родителя,
//          или слева, если вставляемый элемент меньше
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
//          присваиеваем переданному дедушке или прадедушке ссылку на узел, который стал новым родителем
            parent.left = resultNode;
            return parent.left;
        } else {
//           Получаем ссылку на родителя правого поддерева
            Node node = parent.right;
//           Проделываем аналогичные действия, но для правого поддерева
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.right = resultNode;
            return parent.right;
        }
    }

    private Node rotateWithLeftNode(Node element) {
//      Передаваемым элементом может быть либо родитель current узла, либо его дедушка
//      Получаем ссылку на левого потомка передаваемого в параметр элемента.
        Node left = element.left;
//      Назначаем нового левого потомка текущему элементу.
//      Новым потомком становится правый потомок левого потомка
        element.left = left.right;
//      Правый потомок левого потомка теперь ссылается на передаваемый в параметр элемент (дедушку или прадедушку)
//      то есть дедушка или прадедушка становится его правым потомком
        left.right = element;
//      возвращаем левый потомок передаваемого узла
        return left;
    }

    private Node rotateWithRightNode(Node element) {
        Node right = element.right;
        element.right = right.left;
        right.left = element;
        return right;
    }

    public static enum Color {
        BLACK,
        RED
    }

    public static class Node {
        private int element;
        private Node left;
        private Node right;
        private Color color;

        public Node(int element) {
            this(element, null, null);
        }

        public Node(int element, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.color = Color.BLACK;
        }
    }
}
