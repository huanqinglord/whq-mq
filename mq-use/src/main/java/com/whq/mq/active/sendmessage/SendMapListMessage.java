package com.whq.mq.active.sendmessage;

import com.whq.mq.CallBackToMOM;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import java.util.Map;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 17:11
 * @desc: 送Map类型消息，Map中key都为String,value 部分为String,部分为List
 */
@Service
public class SendMapListMessage extends SendMessageService implements CallBackToMOM {
    @Override
    public MapMessage execute(MapMessage message, Map<String, Object> map) throws JMSException {
        message.setString("TEST",map.get("TEST").toString());
        message.setObject("TEST_MSG", map.get("TEST_MSG"));
        return message;
    }

    public void sendMessage(Map<String, Object> map, String queueName, int priority) {
        try{
            sendMessage(SendMapListMessage.this,queueName,map,priority);
        }catch (Exception e){
            System.out.println("发送消息出现异常！"+e.getMessage());
        }
    }
}
