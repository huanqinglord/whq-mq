package com.whq.mq.active.listenermessage;

import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 16:39
 * @desc: 监听类，监听消息类型为Map<String, String>
 */
@Service
public class MapListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            MapMessage mapMessage = (MapMessage) message;
            String test = mapMessage.getString("TEST");
            String testMsg = mapMessage.getString("TEST_MSG");
            System.out.println("test:" + test);
            System.out.println("testMsg:" + testMsg);
        } catch (JMSException e) {
            System.out.println("test队列监听异常。");
            System.out.println(e);
        }
    }
}
