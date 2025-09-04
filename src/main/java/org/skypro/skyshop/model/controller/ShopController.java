package org.skypro.skyshop.model.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ShopController {
    private final StorageService storageService = new StorageService();

    @GetMapping("/product")
    public Collection<Product> getAllProduct() {
        return storageService.getAllProduct();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticle() {
        return storageService.getAllArticle();
    }

    private final SearchService searchService = new SearchService(storageService);

    @GetMapping("/search")
    public Collection<SearchResult> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }

}
