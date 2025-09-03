package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String target) {
        List<SearchResult> results = storageService.GetAllSearchable().stream()
                .filter(s -> s.searchTerm().contains(target))
                .map(SearchResult::fromSearchable)
                .toList();
        return results;
    }
}
