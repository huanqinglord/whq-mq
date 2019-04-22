package com.whq.mq.active.sendmessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 16:31
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-send.xml")
public class TestSendMapMessage {
    @Autowired
    private SendMapMessage sendMapMessage;

    @Test
    public void testSendMessage(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("TEST", "test");
        map.put("TEST_MSG", "TEST_MSG");
        sendMapMessage.sendMessage(map, "test", 5);
        System.out.println("测试完成。");
    }
}
