package org.skypro.skyshop.model.controller;

import org.skypro.skyshop.model.errors.ErrorCode;
import org.skypro.skyshop.model.errors.ShopError;
import org.skypro.skyshop.model.exceptions.NoSuchProductException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<ShopError> noSuchProductException(NoSuchProductException e) {
        ShopError response = new ShopError(ErrorCode.NSPE , "Продукт с ID: " + e.getId() + " не найден");
        return new ResponseEntity<ShopError>(response, HttpStatusCode.valueOf(404));
    }
}
