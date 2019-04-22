package com.whq.mq.active.listenermessage;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 16:44
 * @desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-listener.xml")
public class TestMapListener {
    @org.junit.Test
    public void test() throws Exception{
        Thread.sleep(3000);
    }
}
