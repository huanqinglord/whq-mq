package com.whq.mq.active.sendmessage;

import com.whq.mq.CallBackToMOM;
import com.whq.spring.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.Map;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 15:38
 * @desc:
 */
@Service
public class SendMessageService {
    @Autowired
    private JmsTemplate jmsTemplate;

    private Destination destination;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(final CallBackToMOM callBackToMOM, String queueName,
                            final Map<String,Object> map, int priority){
        destination = (Destination) SpringContextHolder.getBean(queueName + "Queue");

        try {
            //打开优先级设置
            jmsTemplate.setExplicitQosEnabled(true);
            jmsTemplate.setPriority(priority);
            jmsTemplate.send(destination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    MapMessage message = session.createMapMessage();
                    message = callBackToMOM.execute(message,map);
                    return message;
                }
            });
            System.out.println("消息发送成功。");
        }
        catch (Exception e) {
            System.out.println("消息发送失败。");
            System.out.println(e);
        }
    }
}
