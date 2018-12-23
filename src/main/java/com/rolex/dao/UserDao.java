/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.dao;

import com.rolex.dao.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author rolex
 * @since 2018
 */
public interface UserDao extends CrudRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity, Long> {
}
