package com.demo.controller;

import com.demo.domain.ListNode;
import com.demo.service.strategy.AbstractDemoStrategy;
import com.demo.service.strategy.DemoFactory;
import com.demo.service.strategy.OneDemoStrategy;
import com.demo.service.strategy.TwoDemoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
