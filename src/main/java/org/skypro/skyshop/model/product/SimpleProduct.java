package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int price;
    private final UUID id;

    public SimpleProduct(String name, int price, UUID id) throws IllegalArgumentException {
        super(name);
        if (price < 1) {
            throw new IllegalArgumentException("Некорректная цена <1");
        }
        this.price = price;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + " : " + price;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
