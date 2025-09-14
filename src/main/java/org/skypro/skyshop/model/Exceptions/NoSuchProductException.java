package org.skypro.skyshop.model.Exceptions;

import java.util.UUID;

public class NoSuchProductException extends RuntimeException {
    private final UUID id;

    public NoSuchProductException(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
