package com.space.space;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@EnableScheduling
@SpringBootApplication
public class SpaceApplication {

	public static void main(String[] args) throws SchedulerException {

		SpringApplication.run(SpaceApplication.class, args);
		onStartup();
	}

	private static void onStartup() throws SchedulerException {
		JobDetail job = JobBuilder.newJob(SampleJob.class)
				.usingJobData("param", "value")
				.build();

		Date afterFiveSeconds = Date.from(LocalDateTime.now().plusSeconds(5).atZone(ZoneId.systemDefault()).toInstant());
		Trigger trigger = TriggerBuilder.newTrigger()
				.startAt(afterFiveSeconds)
				.build();

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();

		scheduler.start();

		scheduler.scheduleJob(job, trigger);
	}

}
