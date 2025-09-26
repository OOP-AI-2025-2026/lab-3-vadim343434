package org.example.task2;

public class Order {

    private long id;
    private String customer;

    public Order(long id, String customer) {
        setId(id);
        setCustomer(customer);
    }

    private void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Order id must be positive");
        }
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        if (customer == null || customer.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer must not be empty");
        }
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        if (cart == null) throw new IllegalArgumentException("cart cannot be null");

        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(this.id).append(" for customer ").append(this.customer);
        builder.append("\n------------------\n");

        double sum = 0.0;

        for (int i = 0; i < cart.getSize(); i++) {
            Item item = cart.getItem(i);
            sum += item.getPrice();

            builder.append("Item id: ");
            builder.append(item.getId());
            builder.append(" name: ");
            builder.append(item.getName());
            builder.append(" price: ");
            builder.append(item.getPrice());
            builder.append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ");
        builder.append(sum);

        return builder.toString();
    }
}
