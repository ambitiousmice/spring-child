package com.mice.service.service;

import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * Created by AmbitiousMice on 2018/2/24.
 */
public interface ConsumerService {

    TextMessage receive(Destination destination);
}
