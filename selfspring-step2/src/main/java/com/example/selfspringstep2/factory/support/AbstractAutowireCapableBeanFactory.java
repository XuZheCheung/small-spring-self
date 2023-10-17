package com.example.selfspringstep2.factory.support;

import com.example.selfspringstep2.exception.BeanException;
import com.example.selfspringstep2.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new BeanException("Instantiation of bean failed", exception);
        }
        return bean;
    }
}
