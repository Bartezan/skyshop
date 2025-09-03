package org.skypro.skyshop.model.search;

import java.util.UUID;

public class SearchResult {
    public final UUID id;
    public final String name;
    public final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable (Searchable target){
        return new SearchResult(target.getId(),target.getStringRepresentation(),target.getContentName());
    }
}
