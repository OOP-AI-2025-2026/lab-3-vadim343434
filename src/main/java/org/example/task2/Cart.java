package org.example.task2;

import java.util.Arrays;

public class Cart {

    private Item[] items;
    private int size;


    public Cart(Item[] items) {
        if (items == null) {
            throw new IllegalArgumentException("items array cannot be null");
        }
        this.items = items;
        this.size = 0;
        // визначаємо поточний розмір по непорожнім елементам
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                this.size++;
            } else {
                break;
            }
        }
    }

    public Cart(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be > 0");
        }
        this.items = new Item[capacity];
        this.size = 0;
    }

    // додаємо товар
    public void add(Item item) {
        if (item == null) return;
        if (isFull()) return;
        this.items[this.size] = item;
        this.size++;
    }

    public boolean isFull() {
        return this.size == this.items.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public Item getItem(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return this.items[index];
    }

    public Item[] getItems() {
        return Arrays.copyOf(this.items, this.size);
    }

    public boolean removeByIndex(int index) {
        if (index < 0 || index >= this.size) return false;
        for (int i = index; i < this.size - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.items[this.size - 1] = null;
        this.size--;
        return true;
    }

    // видалення за id
    public boolean removeById(long id) {
        int idx = findIndexById(id);
        if (idx == -1) return false;
        return removeByIndex(idx);
    }

    private int findIndexById(long id) {
        for (int i = 0; i < this.size; i++) {
            if (this.items[i].getId() == id) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + Arrays.toString(getItems()) +
                '}';
    }
}
