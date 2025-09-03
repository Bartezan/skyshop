package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> mapProduct;
    private final Map<UUID, Article> mapArticle;

    public StorageService() {
        this.mapProduct = FillMapProduct();
        this.mapArticle = FillMapArticle();
    }

    public Collection<Product> GetAllProduct() {
        Set<Product> result = new HashSet<>();
        for (Map.Entry<UUID,Product> entery : mapProduct.entrySet()){
            result.add(entery.getValue());
        }
        return result;
    }

    public Collection<Article> GetAllArticle() {
        Set<Article> result = new HashSet<>();
        for (Map.Entry<UUID,Article> entery : mapArticle.entrySet()){
            result.add(entery.getValue());
        }
        return result;
    }

    public Collection<Searchable> GetAllSearchable(){
        Set<Searchable> result = new HashSet<>();
        for (Map.Entry<UUID,Product> entery : mapProduct.entrySet()){
            result.add(entery.getValue());
        }
        for (Map.Entry<UUID,Article> entery : mapArticle.entrySet()){
            result.add(entery.getValue());
        }
        return result;
    }

    private Map<UUID, Product> FillMapProduct() {
        SimpleProduct apple = new SimpleProduct("Яблоко", 12, UUID.randomUUID());
        DiscountedProduct banana = new DiscountedProduct("Банан", 10, 50, UUID.randomUUID());
        FixPriceProduct kiwi = new FixPriceProduct("Киви", UUID.randomUUID());
        Map<UUID, Product> fillMap = new HashMap<>();
        fillMap.put(apple.getId(), apple);
        fillMap.put(banana.getId(), banana);
        fillMap.put(kiwi.getId(), kiwi);
        return fillMap;
    }

    private Map<UUID, Article> FillMapArticle() {
        Article appleArticle = new Article("Яблоко сорт Антоновка", "О вкусовых качествах данного сорта", UUID.randomUUID());
        Map<UUID, Article> fillMap = new HashMap<>();
        fillMap.put(appleArticle.getId(), appleArticle);
        return fillMap;
    }
}
