package com.whq.mq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import java.util.Map;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 16:09
 * @desc:
 */
public interface CallBackToMOM {
    MapMessage execute(MapMessage message, Map<String, Object> map) throws JMSException;
}
