package com.websystique.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.websystique.springbatch.model.Person;

public class Main {

	
	@SuppressWarnings("resource")
	public static void main(String areg[]) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-batch-context.xml");

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("examResultJob");
		

		try {
			JobParameters JobParams = new JobParametersBuilder()
					.addString("SUBSCRIBER_OID","1214545232")
					//.addString("", "")
					
					.toJobParameters();

			JobExecution execution = jobLauncher.run(job, JobParams);
			System.out.println("get start time " + execution.getStartTime());
			System.out.println("get end time : " + execution.getEndTime());
			System.out.println("Job Exit Status : " + execution.getStatus());
			
		} catch (JobExecutionException e) {
			System.out.println("Job ExamResult failed");
			e.printStackTrace();
		}
	}

}
