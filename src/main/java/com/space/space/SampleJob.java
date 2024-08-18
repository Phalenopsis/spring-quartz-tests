package com.space.space;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;


public class SampleJob implements Job {
    //@Autowired
    private SampleJobService jobService;

    public SampleJob() {
        this.jobService = new SampleJobService();
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
//        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//        String param = dataMap.getString("param");
//        System.out.println(MessageFormat.format("Job: {0}; Param: {1}", getClass(), param));
        jobService.executeSampleJob();
    }
}
