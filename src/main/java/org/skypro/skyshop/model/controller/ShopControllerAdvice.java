package org.skypro.skyshop.model.controller;

import org.skypro.skyshop.model.ErrorHandling.ShopError;
import org.skypro.skyshop.model.Exceptions.NoSuchProductException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> NoSuchProductExcrption(NoSuchProductException e) {
        ShopError response = new ShopError(10, "Продукт с ID: " + e.getId() + " не найден");
        return new ResponseEntity<ShopError>(response, HttpStatusCode.valueOf(404));
    }
}
