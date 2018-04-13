package com.weixin.demo1.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {


    public void timetTest(){
        Timer timer=new Timer();

    }
    private class MyTimeTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("timerTask to run");
        }
    }
}
