package com.demo.service.strategy;

import com.demo.dao.CommonDao;
import com.demo.domain.ListNode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 策略抽象类
 */
public abstract class AbstractDemoStrategy {

    //每个策略返回对应的枚举
    protected abstract DemoTypeEnum getTypeEnum();

    @Autowired
    private CommonDao commonDao;

    //PostConstruct注解使得init方法在Autowired之后执行,防止init方法使用到还未注入的bean
    @PostConstruct
    private void init(){
        DemoFactory.register(this.getTypeEnum().getCode(), this);
    }

    //需要重写的方法
    public void print(ListNode val) {
        System.out.println("策略执行结束");
    }



}
