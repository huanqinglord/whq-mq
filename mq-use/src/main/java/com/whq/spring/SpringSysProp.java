package com.whq.spring;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: wanghuanqing
 * @date: Create in 2018/5/15 14:46
 * @desc: 获取配置文件参数
 */
public class SpringSysProp extends PropertyPlaceholderConfigurer {
    private SpringSysProp(){};

    private static SpringSysProp springSysProp = new SpringSysProp();

    private Properties prop;

    public static SpringSysProp getInstance(){
        if(springSysProp == null) {
            springSysProp = new SpringSysProp();
        }
        return springSysProp;
    }

    /**
     * @author: wanghuanqing
     * @date: 2018/5/15 15:25
     * @desc: 重写postProcessBeanFactory方法获取Properties对象
     * @param beanFactory
     * @return void
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        try {
            prop = mergeProperties();
            convertProperties(prop);
            processProperties(beanFactory, prop);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
            throw new BeanInitializationException("Could not load properties",
                    ex);
        }
    }

    public String getValue(String key){
        return prop.getProperty(key);
    }
}
