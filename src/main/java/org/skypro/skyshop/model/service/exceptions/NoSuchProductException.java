package org.skypro.skyshop.model.service.exceptions;

import java.util.UUID;

public class NoSuchProductException extends RuntimeException {
    UUID id;

    public NoSuchProductException(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
