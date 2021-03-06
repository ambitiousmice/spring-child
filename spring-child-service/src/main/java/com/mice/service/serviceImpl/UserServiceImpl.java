package com.mice.service.serviceImpl;

import com.mice.domain.UserBean;
import com.mice.persistence.mapper.RoleMenuMapper;
import com.mice.persistence.mapper.UserMapper;
import com.mice.persistence.mapper.UserRoleMapper;
import com.mice.service.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    public List<String> getAllPerms(Long userId) {
        List<Long> roles = userRoleMapper.getRolesByUserId(userId);
        if (CollectionUtils.isEmpty(roles)){
            return null;
        }
        return roleMenuMapper.getPermsByRoleIds(roles);
    }

    @Cacheable("users")
    public UserBean getByUserName(String userName) {
        return userMapper.getByUserName(userName);
    }

    @Cacheable(value = { "users"})
    public Boolean add(String userName, String password) {
        return userMapper.add(userName,password);
    }

    @CacheEvict(value = { "users"}, allEntries = true)
    public void delete(String userName, String password) {

    }



}
