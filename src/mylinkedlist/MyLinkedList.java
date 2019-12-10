package mylinkedlist;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    private class Node<E> {
        E element;
        Node<E> nextNode;
        Node<E> prevNode;

        Node(E element) {
            this.element = element;
            this.nextNode = null;
            this.prevNode = null;
        }

        Node(E element, Node<E> prevNode) {
            this.element = element;
            this.prevNode = prevNode;
        }
    }

    private class MyIterator implements Iterator<E> {
        private Node<E> next;
        private int nextIndex;

        MyIterator() {
            next = firstNode;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) new NoSuchElementException();
            E result = next.element;
            next = next.nextNode;
            nextIndex++;
            return result;
        }

    }

    public MyLinkedList() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<E>(element);
        if (size > 0) {
            newNode.prevNode = lastNode;
            lastNode.nextNode = newNode;
            lastNode = newNode;
        } else {
            firstNode = newNode;
            lastNode = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            add(element);
        } else {
            throwIfWrongIndex(index);
            Node<E> newNode = new Node<E>(element);
            if (index == 0) {
                newNode.nextNode = firstNode;
                firstNode = newNode;
            } else {
                Node<E> currentNode = returnNode(index);
                newNode.prevNode = currentNode.prevNode;
                newNode.nextNode = currentNode;
                currentNode.prevNode = newNode;
                Node<E> prev = newNode.prevNode;
                prev.nextNode = newNode;
                size++;
            }
        }
    }

    @Override
    public void clear() {
        Node<E> current = firstNode;
        Node<E> next;
        while (current != null) {
            next = current.nextNode;
            current.prevNode = null;
            current.nextNode = null;
            current.element = null;
            current = next;
        }
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> current = returnNode(index);
        E result = current.element;
        return result;
    }

    @Override
    public int indexOf(E element) {
        int i = 0;
        Node<E> current = firstNode;
        while (i++ < size && !current.element.equals(element)) {
            current = current.nextNode;
        }
        if (current.element.equals(element)) {
            return i-1;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        Node<E> current = returnNode(index);
        E result = current.element;
        Node<E> prev = current.prevNode;
        Node<E> next = current.nextNode;
        if (prev == null) {
            firstNode = next;
        } else {
            prev.nextNode = next;
        }
        if (next == null) {
            lastNode = prev;
        } else {
            next.prevNode = prev;
        }
        current.nextNode = null;
        current.prevNode = null;
        size--;
        return result;
    }

    @Override
    public E set(int index, E element) {
        Node<E> current = returnNode(index);
        E result = current.element;
        current.element = element;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray(E[] elements) {
        if (elements.length < size) {
            elements = (E[]) Array.newInstance(elements.getClass().getComponentType(), this.size);
        }
        int i = 0;
        for(Node<E> x = this.firstNode; x != null; x = x.nextNode) {
            elements[i++] = x.element;
        }
        if (elements.length > size) {
            elements[size] = null;
        }
        return elements;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node<E> currentNode = firstNode;
        for (int i = 0; i < size; i++) {
            result[i] = currentNode.element;
            currentNode = currentNode.nextNode;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private Node<E> returnNode(int index) {
        throwIfWrongIndex(index);
        if (index <= size/2) {
            Node<E> current = firstNode;
            int i = 0;
            while (i++ < index) {
                current = current.nextNode;
            }
            return current;

        } else {
            Node<E> current = lastNode;
            int i = size-1;
            while (i-- > index) {
                current = current.prevNode;
            }
            return current;
        }
    }

    private void throwIfWrongIndex(int index) {
        if (index >= size || index < 0) new IndexOutOfBoundsException();
    }
}
