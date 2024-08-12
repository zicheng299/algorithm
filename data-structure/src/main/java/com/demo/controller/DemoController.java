package com.demo.controller;

import com.demo.domain.ListNode;
import com.demo.service.strategy.AbstractDemoStrategy;
import com.demo.service.strategy.DemoFactory;
import com.demo.service.strategy.OneDemoStrategy;
import com.demo.service.strategy.TwoDemoStrategy;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {


    @Autowired
    public OneDemoStrategy oneDemoStrategy;

    @Autowired
    public TwoDemoStrategy twoDemoStrategy;


    @GetMapping("/{id}")
    public String demo(@PathVariable("id") Integer id) {
        ListNode listNode = new ListNode();
        DemoFactory.getStrategyNoNull(id).print(listNode);
        return "mark = " + listNode.getVal();
    }

    @Qualifier("myExecutor")
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 多线程验证：
     * StringBuffer 线程安全
     * StringBuilder 线程不安全
     * @return
     */
    @GetMapping("/thread")
    public String thread() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(i);
        }
        StringBuffer val = new StringBuffer();
//        StringBuilder val = new StringBuilder();
        list.forEach(x -> {
            threadPoolTaskExecutor.execute(() -> {
                val.append("x");
                // 模拟耗时,使出现插队情况
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        //等待所有线程执行结束
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("字符串：{}", val.length());
        return "字符串长度: " + val.length();
    }


}
