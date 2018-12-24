/*
 * Copyright (C) 2018 bsyonline
 */
package com.rolex.controller;

import com.rolex.controller.vo.PageVO;
import com.rolex.controller.vo.UserVO;
import com.rolex.http.Response;
import com.rolex.service.IUserService;
import com.rolex.service.model.PageModel;
import com.rolex.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rolex
 * @since 2018
 */
//@RestController
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    /**
     * 添加
     */
    @PostMapping("/users")
    @ResponseBody
    public Response<UserVO> add(@RequestBody UserVO userVO) throws Exception {
        UserModel userModel = convertToModel(userVO);
        userModel = userService.save(userModel);
        return Response.success(convertToVO(userModel));
    }

    /**
     * 获取列表
     */
    @GetMapping("/users")
    @ResponseBody
    public Response list(int page, int size) throws Exception {
        PageModel<UserModel> pageModel = userService.findAll(page, size);
        PageVO<UserVO> pageVO = PageVO.of(page, size).total(pageModel.getTotal()).content(convertToVO(pageModel.getContent()));
        return Response.success(pageVO);
    }

    /**
     * 删除
     */
    @PostMapping("/users/{id}")
    @ResponseBody
    public Response delete(@PathVariable("id") Long userId) throws Exception {
        UserModel userModel = userService.deleteById(userId);
        UserVO userVO = convertToVO(userModel);
        return Response.success(userVO);
    }

    /**
     * 修改
     */
    @PatchMapping("/users/{id}")
    @ResponseBody
    public Response update(@RequestBody UserVO userVO) throws Exception {
        UserModel userModel = convertToModel(userVO);
        userModel = userService.save(userModel);
        return Response.success(convertToVO(userModel));
    }

    /**
     * 详情
     */
    @RequestMapping("/users/{id}")
    @ResponseBody
    public Response detail(@PathVariable("id") Long userId) throws Exception {
        UserModel userModel = userService.findById(userId);
        UserVO userVO = convertToVO(userModel);
        return Response.success(userVO);
    }


    private UserVO convertToVO(UserModel userModel) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

    private UserModel convertToModel(UserVO userVO) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userVO, userModel);
        return userModel;
    }

    private List<UserVO> convertToVO(List<UserModel> content) {
        return content.stream().map(userModel -> convertToVO(userModel)).collect(Collectors.toList());
    }
}
