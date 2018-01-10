package com.mice.service.serviceImpl;

import com.mice.persistence.mapper.UserRoleMapper;
import com.mice.service.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    public List<Long> getRolesByUserId(Long userId) {
        return userRoleMapper.getRolesByUserId(userId);
    }
}
