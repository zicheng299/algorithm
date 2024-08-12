package com.demo.service.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂
 */
public class DemoFactory {


    //缓存策略
    private static final Map<Integer, AbstractDemoStrategy> STRATEGY_MAP = new HashMap<>();


    //工厂注册
    public static void register(Integer type, AbstractDemoStrategy strategy) {
        STRATEGY_MAP.put(type, strategy);
    }

    //获取策略
    public static AbstractDemoStrategy getStrategyNoNull(Integer type) {
        AbstractDemoStrategy strategy = STRATEGY_MAP.get(type);
        if(strategy == null){
            throw new RuntimeException("未找到策略");
        }
        return strategy;
    }


}
