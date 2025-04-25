package org.skypro.skyshop.model.controller;

import org.skypro.skyshop.model.service.errors.ShopError;
import org.skypro.skyshop.model.service.exceptions.NoSuchProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> NoSuchProductException
            (NoSuchProductException e) {
        return ResponseEntity.status(404).body(new ShopError("555","Нет продукта с id = " + e.getId().toString()));
    }
}