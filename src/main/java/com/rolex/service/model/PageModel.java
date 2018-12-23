/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.service.model;

import lombok.Data;

import java.util.List;

/**
 * @author rolex
 * @since 2018
 */
@Data
public class PageModel<T> {

    private Integer page;
    private Integer size;
    private Long total;
    private String sortString;
    private List<T> content;

    public PageModel(int page, int size) {

        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }

        if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        }

        this.page = page;
        this.size = size;
    }

    public PageModel(int page, int size, String sortString) {

        this(page, size);

        this.sortString = sortString;
    }

    public static PageModel of(int page, int size) {
        return of(page, size, null);
    }

    public static PageModel of(int page, int size, String sortString) {
        return new PageModel(page, size, sortString);
    }

    public PageModel total(long total) {
        this.total = total;
        return this;
    }

    public PageModel content(List<T> content) {
        this.content = content;
        return this;
    }

}
