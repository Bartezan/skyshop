package org.skypro.skyshop.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.service.BasketService;
import org.skypro.skyshop.model.service.StorageService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private StorageService storageService;
    @Mock
    private ProductBasket productBasket;
    @InjectMocks
    private BasketService basketService;

    @Test
    public void givenNon_ExistentProduct_whenAddToBasket_ThenThrowException() {
        UUID id = UUID.randomUUID();
        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.ofNullable(null));
        Exception thrownException = null;
        try {
            basketService.addToBasket(id);
        } catch (Exception e) {
            thrownException = e;
        }

        assertThat(thrownException)
                .isNotNull()
                .isExactlyInstanceOf(NoSuchProductException.class);
    }

    @Test
    public void givenExistentProduct_whenAddToBasket_ThenAddProductInProductBusket() {
        UUID id = UUID.randomUUID();
        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.of(new SimpleProduct("Яблоко", 12, id)));
        Exception thrownException = null;
        try {
            basketService.addToBasket(id);
        } catch (Exception e) {
            thrownException = e;
        }

        assertThat(thrownException)
                .isNull();
        verify(productBasket).addInBasket(id);
    }

    @Test
    public void givenEmptyProductBasket_whenGetUserBasket_ThenEmptyUserBasket(){
        UserBasket result = basketService.getUserBasket();
        assertTrue(result.getItemsList().isEmpty());
    }
    @Test
    public void givenFillProductBasket_whenGetUserBasket_ThenGetUserBasket(){
        UUID id = UUID.randomUUID();
        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.of(new SimpleProduct("Яблоко", 12, id)));
        Map<UUID,Integer> testMap = new HashMap<>();
        testMap.put(id,1);
        Mockito.when(productBasket.returnBasket()).thenReturn(testMap);

        UserBasket result = basketService.getUserBasket();
        assertFalse(result.getItemsList().isEmpty());
        assertEquals(result.getItemsList().get(0).getProduct().getId(), id);
    }

}
