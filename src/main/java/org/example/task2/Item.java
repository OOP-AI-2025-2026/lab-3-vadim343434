package org.example.task2;

public class Item {

    private long id;
    private String name;
    private double price;

    public Item(long id, String name, double price) {
        setId(id);           // валідація через (приватний) сеттер
        setName(name);
        setPrice(price);
    }

    // геттери
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    private void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Item id must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name must not be empty");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                ", price=" + this.price +
                ", name='" + this.name + '\'' +
                '}';
    }
}
