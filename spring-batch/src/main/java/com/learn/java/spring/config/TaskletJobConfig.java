/**
 * 
 */
package com.learn.java.spring.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.java.spring.listener.FirstJobListener;
import com.learn.java.spring.listener.FirstStepListener;
import com.learn.java.spring.service.SampleTasklet;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nilam Patil
 *
 */
@Configuration
@Slf4j
public class TaskletJobConfig {

	@Autowired
	private JobBuilderFactory builderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private SampleTasklet sampleTasklet;

	@Autowired
	private FirstJobListener firstJobListener;

	@Autowired
	private FirstStepListener firstStepListener;

	@Bean
	public Job testJob1() {
		return builderFactory.get("First-Job").incrementer(new RunIdIncrementer()).start(testStep1()).next(testStep2())
				.next(testStep3()).listener(firstJobListener).build();
	}

	public Step testStep1() {
		return stepBuilderFactory.get("First-Step").listener(firstStepListener).tasklet(testTask1()).build();
	}

	public Step testStep2() {
		return stepBuilderFactory.get("Second-Step").tasklet(testTask2()).build();
	}

	public Step testStep3() {
		return stepBuilderFactory.get("Third-Step").tasklet(sampleTasklet).build();
	}

	public Tasklet testTask1() {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				log.info("First Tasklet");
				return RepeatStatus.FINISHED;
			}
		};
	}

	public Tasklet testTask2() {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				log.info("Second Tasklet");
				return RepeatStatus.FINISHED;
			}
		};
	}
}
