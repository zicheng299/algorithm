package com.demo.service.strategy;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 策略枚举
 */
@AllArgsConstructor
@Getter
public enum DemoTypeEnum {
    ONE(1, "策略1"),
    TWO(2, "策略2"),
    ;
    private final Integer code;
    private final String msg;

    //缓存, 通过map集合去获取对应的策略,不需要遍历全部枚举
    private static Map<Integer, DemoTypeEnum> cache;

    static {
        cache = Arrays.asList(DemoTypeEnum.values()).stream().collect(Collectors.toMap(DemoTypeEnum::getCode, Function.identity()));
    }

    //根据code获取策略
    public static DemoTypeEnum of(Integer code) {
        return cache.get(code);
    }

}
