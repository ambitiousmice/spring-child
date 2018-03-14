package com.mice.service.service.thread;

import com.mice.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AmbitiousMice on 2018/1/16.
 */
public class ThreadTest implements Runnable{
    private Logger LOG = LoggerFactory.getLogger(ThreadTest.class);
    private UserService userService;
    private Long id;

    public ThreadTest(UserService userService, Long id) {
        this.userService = userService;
        this.id = id;
    }


    public void run() {
        LOG.info(Thread.currentThread().getName()+"开始运行");
        userService.getAllPerms(id);
        LOG.info(Thread.currentThread().getName()+"结束运行");

    }
}
