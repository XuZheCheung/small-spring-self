package com.example.selfspringstep2;

import com.example.selfspringstep2.factory.config.BeanDefinition;
import com.example.selfspringstep2.factory.support.DefaultListableBeanFactory;
import com.example.selfspringstep2.servBean.UserService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class SelfspringStep2ApplicationTests {

    @Test
    public void contextLoads() {
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        BeanDefinition beanDefinition=new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService=(UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
        //beanFactory.getBean中不但获取该对象的实例，还验证了是否有该实例存在。 若无，则会注册一个beanDefinition
        //而beanFactory.getSingleton仅仅是从hashMap中取出对应对象，如果没有实例存在，会直接导致报错
        UserService userService_singleton=(UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();
    }

}
