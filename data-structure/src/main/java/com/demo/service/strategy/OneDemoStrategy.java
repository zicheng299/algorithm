package com.demo.service.strategy;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.demo.domain.ListNode;
import org.springframework.stereotype.Component;

/**
 * 策略1
 */
@Component
public class OneDemoStrategy extends AbstractDemoStrategy{


    @Override
    protected DemoTypeEnum getTypeEnum() {
        return DemoTypeEnum.of(1);
    }

    public void print(ListNode val) {
        val.setVal(1);
        super.print(val);
    }
}
