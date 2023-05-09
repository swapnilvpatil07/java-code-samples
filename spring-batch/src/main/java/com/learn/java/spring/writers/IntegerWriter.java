/**
 * 
 */
package com.learn.java.spring.writers;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nilam Patil
 *
 */
@Component
@Slf4j
public class IntegerWriter implements ItemWriter<Integer> {

	@Override
	public void write(List<? extends Integer> items) throws Exception {

	}

}
