package com.example.selfspringstep2.factory.support;

import com.example.selfspringstep2.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
