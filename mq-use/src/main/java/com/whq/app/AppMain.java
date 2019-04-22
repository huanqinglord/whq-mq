package com.whq.app;

import com.whq.mq.CallBackToMOM;
import com.whq.mq.active.sendmessage.SendMessageService;
import com.whq.spring.SpringContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 15:35
 * @desc:
 */
public class AppMain{
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("加载配置文件成功。");
    }


}
