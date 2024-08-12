package com.demo.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;
@AllArgsConstructor
public class MyThreadFactory implements ThreadFactory {


    private final ThreadFactory factory;

    @Override
    public Thread newThread(@NotNull Runnable r) {

        return factory.newThread(r);
    }
}
