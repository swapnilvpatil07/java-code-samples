/**
 * 
 */
package com.learn.java.spring.readers;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

/**
 * @author Nilam Patil
 *
 */
@Component
public class IntegerReader implements ItemReader<Integer> {

	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		return null;
	}

}
