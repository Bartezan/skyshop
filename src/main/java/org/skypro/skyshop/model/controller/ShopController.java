package org.skypro.skyshop.model.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.service.BasketService;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ShopController {
    @Autowired
    private StorageService storageService;
    @Autowired
    private  ProductBasket productBasket ;
    @Autowired
    private BasketService basketService;

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

    @GetMapping("/basket/{id}")
    public String addProduct(@PathVariable("id") UUID id) {
        basketService.addToBasket(id);
        return "*Продукт успешно добавлен*";
    }

    @GetMapping("/basket")
    public UserBasket getUserBasket() {
        return basketService.getUserBasket();
    }
}
