package com.whq.mq.active.sendmessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 17:14
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-send.xml")
public class TestSendMapListMessage {
    @Autowired
    private SendMapListMessage sendMapListMessage;
    @Test
    public void testSendMessage(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("TEST", "test");
        List<String> list = new ArrayList<String>();
        list.add("1,a");
        list.add("2,b");
        list.add("3,c");
        map.put("TEST_MSG", list);
        sendMapListMessage.sendMessage(map, "test", 5);
        System.out.println("测试完成。");
    }
}
