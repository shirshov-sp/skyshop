package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    String getName();

    UUID getId();

    default String getStringRepresentation() {
        return this.getSearchTerm() + " - " + this.getContentType();
    }
}
