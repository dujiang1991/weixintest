package com.weixin.demo1.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeixinQuartzJob extends QuartzJobBean {
    @Autowired
    private RefreshWeixinAccessToken refreshWeixinAccessToken;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
