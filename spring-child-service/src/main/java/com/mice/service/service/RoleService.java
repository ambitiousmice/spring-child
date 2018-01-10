package com.mice.service.service;

import com.mice.persistence.mapper.RoleMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
public interface RoleService {


    List<String> getRoles(Long userId);


}
