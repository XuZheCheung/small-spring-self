package com.example.selfspringstep2.factory.support;

import com.example.selfspringstep2.exception.BeanException;
import com.example.selfspringstep2.factory.BeanFactory;
import com.example.selfspringstep2.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeanException {
        Object bean=getSingleton(beanName);
        //若map中存在该实例，则直接返回
        if (bean!=null){
            return bean;
        }
        BeanDefinition beanDefinition=getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }

    /**
     * 根据bean实例名，获取对应的beanDefinition
     * @param beanName
     * @return
     * @throws BeanException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    /**
     * 创建bean的实例
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeanException
     */
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition)throws BeanException;
}
