package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private int basicPrise;
    private int percent;
    private final UUID id;

    public DiscountedProduct(String name, int basicPrise, int percent, UUID id) {
        super(name);
        if (basicPrise < 1) {
            throw new IllegalArgumentException("Базовая цена некорректна <1");
        }
        if (!(percent >= 0 && percent <= 100)) {
            throw new IllegalArgumentException("Процент не корректен");
        }
        this.basicPrise = basicPrise;
        this.percent = percent;
        this.id = id;
    }

    @Override
    public int getPrice() {
        return (basicPrise * (100 - percent) / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPrice() + " (" + percent + "%)";
    }

    @Override
    public UUID getId() {
        return id;
    }
}
