package org.example.task2;

public class IntStack {
    private int[] elements;   // масив для зберігання елементів
    private int size;         // кількість елементів у стеку
    private static final int DEFAULT_CAPACITY = 10; // початковий розмір масиву

    public IntStack() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(int value) {
        ensureCapacity();
        elements[size++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        }
        return elements[--size];
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        }
        return elements[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int[] newArray = new int[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }
}
