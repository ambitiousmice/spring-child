package com.mice.persistence.mapper;

import com.mice.domain.RoleBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public interface RoleMapper {
    @Select("select role_name from role where user_id = #{userId}")
    public List<String> getRoleNamesByUserId(Long userId);

    @Insert("insert into role(user_id,role_name) values{#{userId},#{roleName}}")
    public Boolean add(Long user_id,String roleName);


    @Delete("delete from role where id = #{id}")
    public int deleteById(Long id);

    @Update("update role set user_id = #{userId}, role_name = #{roleName} where id = #{id}")
    public int update(RoleBean role);
}
