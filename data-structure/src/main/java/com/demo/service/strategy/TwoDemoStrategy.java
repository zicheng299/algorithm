package com.demo.service.strategy;

import com.demo.domain.ListNode;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * 策略2
 */
@Component
public class TwoDemoStrategy extends AbstractDemoStrategy {


    @Override
    protected DemoTypeEnum getTypeEnum() {
        return DemoTypeEnum.of(2);
    }

    public void print(ListNode val) {
        val.setVal(2);
        super.print(val);
    }
}
