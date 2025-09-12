package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;
    public BasketService(StorageService storageService, ProductBasket productBasket) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addToBasket(UUID id) {
        if (storageService.getProductById(id).isPresent() == false) {
            throw new IllegalArgumentException("Продукта с данным ID не существует: " + id);
        } else {
            productBasket.addInBasket(id);
        }
    }

    public UserBasket getUserBasket() {
        List<BasketItem> tempBasketItemList = productBasket.returnBasket().entrySet().stream()
                .map(m -> new BasketItem(storageService.getProductById(m.getKey()).orElseThrow(() -> new IllegalArgumentException("Продукта с данным ID не существует: " + m.getKey())),
                        m.getValue()))
                .collect(Collectors.toCollection(ArrayList::new));
        UserBasket tempUserBasket = new UserBasket(tempBasketItemList);
//        System.out.println(tempUserBasket.getTotal());
//        System.out.println(tempUserBasket.getItemsList().get(0).getProduct().getName());
//        System.out.println(tempUserBasket.getItemsList().get(0).getCount());
//        System.out.println(tempUserBasket.getItemsList().get(1).getProduct().getName());
//        System.out.println(tempUserBasket.getItemsList().get(1).getCount());
//        System.out.println(tempUserBasket.getItemsList().get(2).getProduct().getName());
//        System.out.println(tempUserBasket.getItemsList().get(2).getCount());
        return tempUserBasket;
    }
}
