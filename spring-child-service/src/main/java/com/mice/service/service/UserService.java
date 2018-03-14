package com.mice.service.service;

import com.mice.domain.UserBean;

import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public interface UserService {

    List<String> getAllPerms(Long userId);

    UserBean getByUserName(String userName);

    Boolean add(String userName,String password);



}
