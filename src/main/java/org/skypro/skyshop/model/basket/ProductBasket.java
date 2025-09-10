package org.skypro.skyshop.model.basket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductBasket {

    private final Map<UUID, Integer> basketMap;

    public ProductBasket() {
        this.basketMap = new HashMap<UUID, Integer>();
    }

    public void addInBasket(UUID id) {
        if (basketMap.containsKey(id)) {
            basketMap.put(id, basketMap.get(id) + 1);
        } else {
            basketMap.put(id, 1);
        }
    }

    public Map<UUID, Integer> returnBasket() {
        return Collections.unmodifiableMap(basketMap);
    }
}
