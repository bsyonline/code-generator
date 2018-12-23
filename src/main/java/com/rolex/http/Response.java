/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.http;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author rolex
 * @since 2018
 */
@Data
@AllArgsConstructor
public class Response<T> {

    private int code;
    private String message;
    private T data;

    public static <T> Response success(T t) {
        return new Response(200, "OK", t);
    }

}
