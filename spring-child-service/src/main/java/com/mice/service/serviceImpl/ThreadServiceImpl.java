package com.mice.service.serviceImpl;

import com.mice.service.service.ThreadService;
import com.mice.service.service.UserService;
import com.mice.service.service.thread.ThreadTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * Created by AmbitiousMice on 2018/1/16.
 */
@Service
public class ThreadServiceImpl implements ThreadService {
    @Autowired
    private UserService userService;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    public void executeThread(Long id) {
        ThreadTest test = new ThreadTest(userService,id);
        threadPoolTaskExecutor.execute(test);
    }
}
