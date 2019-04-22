package com.whq.mq.active.listenermessage;

import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Iterator;
import java.util.List;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 17:53
 * @desc: 监听类，监听消息类型为Map<String, Object>
 */
@Service
public class MapListListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            MapMessage mapMessage = (MapMessage) message;
            String test = mapMessage.getString("TEST");
            List<String> testMsg = (List<String>)mapMessage.getObject("TEST_MSG");
            System.out.println("List size : " + testMsg.size());
            Iterator<String> listIt = testMsg.iterator();
            while (listIt.hasNext()) {
                System.out.println("testMsg:" + listIt.next());
            }
            System.out.println("test:" + test);
        } catch (JMSException e) {
            System.out.println("test队列监听异常。");
            System.out.println(e);
        }
    }
}
