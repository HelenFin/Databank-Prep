package org.example.dto;

public class ProjectPrice {
    private final String name;
    private final int price;

    public ProjectPrice(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
