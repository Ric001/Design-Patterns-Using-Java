package org.structures.linkedlists;

import java.util.Objects;

public class LinkedList<T> {

    Node<T> head;
    private int len;

    public LinkedList<T> appendAll(final LinkedList<T> listToAdd) {
        if (Objects.isNull(listToAdd))
            return this;
        Node<T> endOfTail = head;
        Node<T> headOfIncomingList = listToAdd.getHead();

        while (Objects.nonNull(endOfTail.getNext()))
            endOfTail = endOfTail.getNext();

        while (Objects.nonNull(headOfIncomingList)) {
            endOfTail.setNext(headOfIncomingList);
            headOfIncomingList = headOfIncomingList.getNext();
        }
        len += listToAdd.getLen();
        return this;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public LinkedList<T> prependAll(final LinkedList<T> listToPrepend) {
        if (Objects.isNull(listToPrepend))
            return this;
        Node<T> startOfThisTail = head;
        Node<T> headOfIncomingList = listToPrepend.getHead();
        Node<T> endOfIncomingList = headOfIncomingList;

        while (Objects.nonNull(endOfIncomingList.getNext()))
            endOfIncomingList = endOfIncomingList.getNext();

        head = headOfIncomingList;
        endOfIncomingList.setNext(startOfThisTail);
        len += listToPrepend.getLen();
        return this;

    }

    public LinkedList<T> append(final T data) {
        final Node<T> end = new Node<>(data);
        Node<T> lastGottenNode = head;
        while (Objects.nonNull(lastGottenNode))
            lastGottenNode = lastGottenNode.getNext();
        lastGottenNode.setNext(end);
        len++;
        return this;
    }

    public LinkedList<T> modify(final int dataIndex, final T data) {
        final Node<T> update = new Node<>(data);
        Node<T> lastGotteNode = head;
        if (lastGotteNode.getIndex() != dataIndex)
            lastGotteNode = lastGotteNode.getNext();
        lastGotteNode = update;
        return this;
    }

    public LinkedList<T> preppend(final T data) {
        if (Objects.isNull(head))
            return this;

        final Node<T> newHead = new Node<>(data);
        newHead.setNext(head);
        head = newHead;
        len++;
        return this;
    }

    public LinkedList<T> remove(final T data) {
        if (Objects.isNull(data) || Objects.isNull(head))
            return this;

        Node<T> nodeToRemove = head;
        Node<T> previousNode = null;

        while (!nodeToRemove.getData().equals(data)) {
            previousNode = nodeToRemove;
            nodeToRemove = nodeToRemove.getNext();
        }
        previousNode.setNext(nodeToRemove.getNext());
        nodeToRemove = null;
        len--;
        return this;
    }

    Node<T> getHead() {
        return head;
    }

    void setHead(Node<T> head) {
        this.head = head;
    }

    @Override
    public String toString() {
        final StringBuilder contentToParse = new StringBuilder();

        Node<T> referenceNode = head;
        contentToParse.append("{");

        while (Objects.nonNull(referenceNode)) {
            contentToParse.append("Index: " + referenceNode.getIndex()).append(" Data: " + referenceNode.getData());
        }

        return contentToParse.append("}").toString();
    }

    public boolean compareLists(final LinkedList<T> linkedList) {
        Node<T> incomingListHead = linkedList.getHead();
        Node<T> startOfThisTail = head;

        while (Objects.nonNull(incomingListHead) && Objects.nonNull(startOfThisTail)) {
            if (!incomingListHead.equals(startOfThisTail))
                return false;
            incomingListHead = incomingListHead.getNext();
            startOfThisTail = startOfThisTail.getNext();
        }

        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((head == null) ? 0 : head.hashCode());
        result = prime * result + len;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (Objects.isNull(obj))
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        @SuppressWarnings("unchecked")
        final LinkedList<T> incomingList = (LinkedList<T>) obj;
       
        return compareLists(incomingList);
    }
}

