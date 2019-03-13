package com.mice.web;

import com.mice.service.service.ConsumerService;
import com.mice.service.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AmbitiousMice on 2018/2/24.
 */
@Controller
@RequestMapping(value = "test")
public class MQController {



        //队列名gzframe.demo
        @Resource(name="demoQueueDestination")
        private Destination demoQueueDestination;

        //队列消息生产者
        @Autowired
        private ProducerService producerService;

        //队列消息消费者
        @Autowired
        private ConsumerService consumerService;

        @RequestMapping(value="/producer",method= RequestMethod.GET)
        public String producer(){
            System.out.println("------------go producer");
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format( now );
            System.out.println(time);
            return time;
        }

        @RequestMapping(value="/onsend",method=RequestMethod.POST)
        public String producer(@RequestParam("message") String message) {
            System.out.println("------------send to jms");
            producerService.sendMessage(demoQueueDestination, message);
            return "producer";
        }

        @RequestMapping(value="/receive",method=RequestMethod.GET)
        public String queue_receive() throws JMSException {
            System.out.println("------------receive message");

            TextMessage tm = consumerService.receive(demoQueueDestination);
            return "queue_receive";
        }

        /*
         * ActiveMQ Manager Test
         */
        @RequestMapping(value="/jms",method=RequestMethod.GET)
        public String jmsManager() throws IOException {
            System.out.println("------------jms manager");

            JMXServiceURL url = new JMXServiceURL("");
            JMXConnector connector = JMXConnectorFactory.connect(url);
            connector.connect();
            MBeanServerConnection connection = connector.getMBeanServerConnection();
  
                
            return "manager";
        }
}
