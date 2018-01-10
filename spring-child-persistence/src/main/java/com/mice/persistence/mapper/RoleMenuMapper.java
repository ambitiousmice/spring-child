package com.mice.persistence.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public interface RoleMenuMapper {

    @Select("select perms from role_menu where role_id in #{roleIds}")
    public List<String> getPermsByRoleIds(List<Long> roleIds);


}
