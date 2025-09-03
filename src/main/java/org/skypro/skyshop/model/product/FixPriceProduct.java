package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE_PRODUCT = 15;
    private final UUID id;

    public FixPriceProduct(String name, UUID id) {
        super(name);
        this.id = id;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " : Фиксированная цена " + FIX_PRICE_PRODUCT;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
