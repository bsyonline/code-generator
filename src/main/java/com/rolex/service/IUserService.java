/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.service;

import com.rolex.exception.BusinessException;
import com.rolex.service.model.PageModel;
import com.rolex.service.model.UserModel;

import java.util.List;

/**
 * @author rolex
 * @since 2018
 */
public interface IUserService {

    UserModel save(UserModel userModel) throws BusinessException;

    List<UserModel> bulkSave(List<UserModel> list) throws BusinessException;

    UserModel update(UserModel userModel) throws BusinessException;

    UserModel deleteById(Long id) throws BusinessException;

    UserModel findById(Long id) throws BusinessException;

    PageModel<UserModel> findAll(int page, int size) throws BusinessException;
}
