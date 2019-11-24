package com.example.test.service;

import org.springframework.scheduling.annotation.Async;

import java.util.Random;

@Async/*表明此类所有方法都是异步方法*/
public class AsyncClass
{
    private static Random random = new Random();
}
