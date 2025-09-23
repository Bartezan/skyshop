package org.skypro.skyshop.unit;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

public class StorageServiceFixture {

    public static Collection<Searchable> getEmptyStorageService() {
        Map<UUID, Product> mapProduct = new HashMap<>();
        Map<UUID, Article> mapArticle = new HashMap<>();
        Set<Searchable> result = new HashSet<>();
        for (Map.Entry<UUID, Product> entery : mapProduct.entrySet()) {
            result.add(entery.getValue());
        }
        for (Map.Entry<UUID, Article> entery : mapArticle.entrySet()) {
            result.add(entery.getValue());
        }
        return result;
    }

    public static Collection<Searchable> getFillStorageService(){
        SimpleProduct apple = new SimpleProduct("Яблоко", 12, UUID.randomUUID());
        DiscountedProduct banana = new DiscountedProduct("Банан", 10, 50, UUID.randomUUID());
        FixPriceProduct kiwi = new FixPriceProduct("Киви", UUID.randomUUID());
        Map<UUID, Product> mapProduct = new HashMap<>();
        mapProduct.put(apple.getId(), apple);
        mapProduct.put(banana.getId(), banana);
        mapProduct.put(kiwi.getId(), kiwi);

        Article appleArticle = new Article("Яблоко сорт Антоновка", "О вкусовых качествах данного сорта", UUID.randomUUID());
        Map<UUID, Article> mapArticle = new HashMap<>();
        mapArticle.put(appleArticle.getId(), appleArticle);

        Set<Searchable> result = new HashSet<>();
        for (Map.Entry<UUID, Product> entery : mapProduct.entrySet()) {
            result.add(entery.getValue());
        }
        for (Map.Entry<UUID, Article> entery : mapArticle.entrySet()) {
            result.add(entery.getValue());
        }
        return result;
    }

}
