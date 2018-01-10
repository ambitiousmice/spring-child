package com.mice.persistence.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public interface UserRoleMapper {

    @Select("select role_id from user_role where user_id = #{userId}")
    public List<Long> getRolesByUserId(Long userId);

    @Insert("insert into user_role(user_id,role_id) values{#{userId},#{roleId}}")
    public Boolean add(Long user_id,Long roleId);
}
