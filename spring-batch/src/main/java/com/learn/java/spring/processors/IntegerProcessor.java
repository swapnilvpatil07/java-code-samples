/**
 * 
 */
package com.learn.java.spring.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nilam Patil
 *
 */
@Component
@Slf4j
public class IntegerProcessor implements ItemProcessor<Integer, Integer> {

	@Override
	public Integer process(Integer item) throws Exception {

		return null;
	}

}
