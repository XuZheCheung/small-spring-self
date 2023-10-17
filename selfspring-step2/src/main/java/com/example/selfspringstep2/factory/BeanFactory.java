package com.example.selfspringstep2.factory;

import com.example.selfspringstep2.exception.BeanException;

public interface BeanFactory {
    Object getBean(String name) throws BeanException;
}
