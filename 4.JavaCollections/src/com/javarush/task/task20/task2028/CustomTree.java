package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("0");
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            Entry<String> entry = queue.poll();
            count++;
            if (!entry.availableToAddLeftChildren) {
                queue.add(entry.leftChild);
            }
            if (!entry.availableToAddRightChildren) {
                queue.add(entry.rightChild);
            }
        }
        return count - 1;
    }

    @Override
    public boolean remove(Object o) {
        String element;
        if (o instanceof String) {
            element = (String) o;
        } else {
            throw new UnsupportedOperationException();
        }

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> entry = queue.poll();
            if (element.equals(entry.elementName)) {
                if (entry == entry.parent.leftChild) {
                    entry.parent.availableToAddLeftChildren = true;
                } else if (entry == entry.parent.rightChild) {
                    entry.parent.availableToAddRightChildren = true;
                }
                return true;
            }
            if (!entry.availableToAddLeftChildren) {
                queue.add(entry.leftChild);
            }
            if (!entry.availableToAddRightChildren) {
                queue.add(entry.rightChild);
            }
        }
        return false;
    }

    @Override
    public boolean add(String element) {
        if (element == null) {
            throw new NullPointerException();
        }
        boolean isAdded = false;
        Entry<String> parent = findEntryToAttach(root);
        if (parent != null) {
            Entry<String> child = new Entry<>(element);
            child.parent = parent;
            if (parent.availableToAddLeftChildren) {
                parent.leftChild = child;
                parent.availableToAddLeftChildren = false;
            } else if (parent.availableToAddRightChildren) {
                parent.rightChild = child;
                parent.availableToAddRightChildren = false;
            }
            isAdded = true;
        }
        return isAdded;
    }

    private Entry<String> findEntryToAttach(Entry<String> root) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> entry = queue.poll();
            if (entry.isAvailableToAddChildren()) {
                return entry;
            }
            if (!entry.availableToAddLeftChildren) {
                queue.add(entry.leftChild);
            }
            if (!entry.availableToAddRightChildren) {
                queue.add(entry.rightChild);
            }
        }
        return null;
    }

    public String getParent(String number) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> entry = queue.poll();

            if (entry.elementName.equals(number)) {
                return entry.parent.elementName;
            }

            if (!entry.availableToAddLeftChildren) {
                queue.add(entry.leftChild);
            }
            if (!entry.availableToAddRightChildren) {
                queue.add(entry.rightChild);
            }
        }
        return null;
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        boolean newLineRootElement;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            newLineRootElement = false;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return this.availableToAddLeftChildren || this.availableToAddRightChildren;
        }
    }
}