package com.mice.service.service;

import javax.jms.Destination;

/**
 * Created by AmbitiousMice on 2018/2/24.
 */
public interface ProducerService {

    void sendMessage(Destination destination, final String msg);

    void sendMessage(final String msg);
}
