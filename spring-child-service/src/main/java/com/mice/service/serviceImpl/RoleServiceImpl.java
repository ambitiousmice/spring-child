package com.mice.service.serviceImpl;

import com.mice.persistence.mapper.RoleMapper;
import com.mice.persistence.mapper.UserRoleMapper;
import com.mice.service.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper mapper;

    public List<String> getRoles(Long userId) {

        return mapper.getRoleNamesByUserId(userId);
    }
}
