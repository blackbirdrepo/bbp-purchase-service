package com.bbp.purchaseservice.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NegativeQuantityBalanceException extends RuntimeException {

    public NegativeQuantityBalanceException() {
        super();
    }

    public NegativeQuantityBalanceException(String message) {
        super(message);
    }
}
