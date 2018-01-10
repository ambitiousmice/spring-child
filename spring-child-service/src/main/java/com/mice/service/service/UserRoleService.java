package com.mice.service.service;

import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public interface UserRoleService {

    List<Long> getRolesByUserId(Long userId);
}
