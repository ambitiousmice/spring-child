package com.mice.persistence.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public interface MenuMapper {


    @Insert("insert into menu(menu_name,remark) values{#{userName},#{remark}}")
    public Boolean add(String userName,String remark);
}
