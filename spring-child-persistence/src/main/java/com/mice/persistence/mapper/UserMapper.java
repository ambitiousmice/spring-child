package com.mice.persistence.mapper;

import com.mice.domain.UserBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public interface UserMapper {

    @Select("select * from user where user_name = #{userName}")
    public UserBean getByUserName(String userName);

    @Insert("insert into user(user_name,password) values{#{userName},#{password}")
    public Boolean add(String userName,String password);


    @Delete("delete from user where id = #{id}")
    public int deleteById(Long id);

    @Update("update user set user_name = #{userName}, password = #{password} where id = #{id}")
    public int update(UserBean user);

    @Select("select * from user where id = #{id}")
    public UserBean getUserById(Long id);

    @Select("select * from user")
    public List<UserBean> getAllUsers();
}
