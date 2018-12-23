/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.service.impl;

import com.google.common.collect.Lists;
import com.rolex.dao.UserDao;
import com.rolex.dao.entity.UserEntity;
import com.rolex.exception.BusinessException;
import com.rolex.exception.Errors;
import com.rolex.service.IUserService;
import com.rolex.service.model.PageModel;
import com.rolex.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author rolex
 * @since 2018
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserModel save(UserModel userModel) throws BusinessException {
        UserEntity userEntity = convertToEntity(userModel);
        userEntity = userDao.save(userEntity);
        return convertToModel(userEntity);
    }

    @Override
    public List<UserModel> bulkSave(List<UserModel> list) throws BusinessException {
        List<UserEntity> userList = convertToEntity(list);
        List<UserEntity> userEntityList = Lists.newArrayList(userDao.saveAll(userList));
        return convertToModel(userEntityList);
    }

    @Override
    public UserModel update(UserModel userModel) throws BusinessException {
        UserEntity userEntity = convertToEntity(userModel);
        userEntity = userDao.save(userEntity);
        return convertToModel(userEntity);
    }

    @Override
    @Transactional
    public UserModel deleteById(Long id) throws BusinessException {
        UserEntity userEntity = userDao.findById(id).get();
        if (userEntity == null) {
            throw new BusinessException(Errors.INVALID_PAREMETER);
        }
        userDao.deleteById(userEntity.getId());
        return convertToModel(userEntity);
    }

    @Override
    public UserModel findById(Long id) throws BusinessException {
        Optional<UserEntity> userEntity = userDao.findById(id);
        if (userEntity.orElse(null) == null) {
            throw new BusinessException(Errors.INVALID_PAREMETER);
        }
        return convertToModel(userEntity.get());
    }

    @Override
    public PageModel<UserModel> findAll(int page, int size) throws BusinessException {
        Page<UserEntity> userEntityPage = userDao.findAll(PageRequest.of(page, size));
        List<UserModel> list = convertToModel(userEntityPage.getContent());
        return PageModel.of(page, size).total(userEntityPage.getTotalElements()).content(list);
    }


    private UserModel convertToModel(UserEntity userEntity) {
        return new UserModel();
    }

    private UserEntity convertToEntity(UserModel userModel) {
        return new UserEntity();
    }

    private List<UserModel> convertToModel(List<UserEntity> userEntity) {
        return Lists.newArrayList();
    }

    private List<UserEntity> convertToEntity(List<UserModel> userModel) {
        return Lists.newArrayList();
    }
}

