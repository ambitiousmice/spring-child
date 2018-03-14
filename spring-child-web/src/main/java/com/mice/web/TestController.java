package com.mice.web;

import com.mice.service.service.ThreadService;
import com.mice.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by AmbitiousMice on 2017/11/2.
 * E-mail:787979134@qq.com
 */
@RequestMapping("test")
@Controller
public class TestController {
    @Autowired
    private ThreadService threadService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public String test(){
        return "test111";
    }

    @RequestMapping(value = "/testThread", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void testThread(){
        threadService.executeThread(1L);
    }


    @RequestMapping(value = "/testRedis", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void testRedis(){
        userService.getByUserName("root");
        userService.getByUserName("ch");
        userService.add("test","233333");
    }




}
