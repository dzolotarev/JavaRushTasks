package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();


    public void printAll() {
        Node currentElement = last.prev;
       // Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.prev;
           // currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        Node node = new Node();
        Node lastNode = last.prev;
        node.value = value;
        node.next = null;
        if (first.next == null) {
            node.prev = null;
            first.next = node;
            last.prev = node;
        } else {
            lastNode.next = node;
            node.prev = lastNode;
            last.prev = node;

//            while (lastNode.next != null) {
//                lastNode = lastNode.next;
//            }
//            lastNode.next = node;
//            node.prev = lastNode;
//            last.prev = node;

        }

    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
