/**
 * 
 */
package com.learn.java.spring.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nilam Patil
 *
 */
@Component
@Slf4j
public class FirstJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("--------------------------" + jobExecution.getJobInstance().getJobName()
				+ "---------------------------------------");
		log.info("JobConfigurationName: " + jobExecution.getJobConfigurationName());
		log.info("Id: " + jobExecution.getId());
		log.info("JobId: " + jobExecution.getJobId());
		log.info("JobName: " + jobExecution.getJobInstance().getJobName());
		log.info("InstanceId: " + jobExecution.getJobInstance().getInstanceId());
		log.info("JobParameters: " + jobExecution.getJobParameters());

		jobExecution.getExecutionContext().put("Sample_Key", "Sample_Value");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("JobConfigurationName: " + jobExecution.getJobConfigurationName());
		log.info("Id: " + jobExecution.getId());
		log.info("JobId: " + jobExecution.getJobId());
		log.info("JobName: " + jobExecution.getJobInstance().getJobName());
		log.info("InstanceId: " + jobExecution.getJobInstance().getInstanceId());
		log.info("JobParameters: " + jobExecution.getJobParameters());

		jobExecution.getExecutionContext().put("Sample_Key", "Sample_Value");
		log.info("-----------------------------------------------------------------");
	}

}
