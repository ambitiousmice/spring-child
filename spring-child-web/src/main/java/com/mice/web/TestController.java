package com.mice.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by AmbitiousMice on 2017/11/2.
 * E-mail:787979134@qq.com
 */
@RequestMapping
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public String test(){
        return "test111";
    }
}
