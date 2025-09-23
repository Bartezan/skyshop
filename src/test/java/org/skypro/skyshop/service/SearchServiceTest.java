package org.skypro.skyshop.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;
import org.skypro.skyshop.unit.StorageServiceFixture;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageService;
    @InjectMocks
    private SearchService searchService;

    @Test
    public void givenEmptyStorageService_whenCheckSearchService_ThenReturnEmpty() {
        Mockito.when(storageService.getAllSearchable()).thenReturn(StorageServiceFixture.getEmptyStorageService());

        Collection<SearchResult> results = searchService.search("яблоко");

        assertTrue(results.isEmpty());
    }

    @Test
    public void givenFillStorageService_whenCheckSearchServiceWithNotCorrectTarget_ThenReturnEmpty() {
        Mockito.when(storageService.getAllSearchable()).thenReturn(StorageServiceFixture.getFillStorageService());
        String target = "Арбуз";
        Collection<SearchResult> results = searchService.search(target);

        assertTrue(results.isEmpty());
    }
    @Test
    public void givenFillStorageService_whenCheckSearchServiceWithCorrectTarget_ThenReturnResult() {
        Mockito.when(storageService.getAllSearchable()).thenReturn(StorageServiceFixture.getFillStorageService());
        String target = "блок";

        Collection<SearchResult> results = searchService.search(target);

        assertFalse(results.isEmpty());
        assertTrue(results.stream().anyMatch(searchResult -> searchResult.getName().contains(target)));
    }
}
