package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) throws IllegalArgumentException, NullPointerException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Поле Имя пустое");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name;
    }

    @JsonIgnore
    @Override
    public String searchTerm() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getContentName() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public abstract UUID getId();

}
