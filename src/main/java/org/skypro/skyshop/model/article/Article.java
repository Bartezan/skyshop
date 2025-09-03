package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private String name;
    private String text;
    private final UUID id;

    public Article(String name, String text, UUID id) {
        this.name = name;
        this.text = text;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Название статьи: " + name + ", Текст статьи: " + text;
    }

    @JsonIgnore
    @Override
    public String searchTerm() {
        return toString();
    }

    @JsonIgnore
    @Override
    public String getContentName() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public UUID getId() {
        return id;
    }
}
