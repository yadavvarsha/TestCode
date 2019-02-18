package com.ubs.opsit.interviews.wordfrequency.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.ubs.opsit.interviews.wordfrequency.WordFrequency;

public class WordFrequencyImpl implements WordFrequency {
	
	final static Logger logger = LogManager.getLogger(WordFrequencyImpl.class);


	/**
	 * This method expect the String as a input and returns Map<String,Integer> as each word and count of that word in given String
	 * This method does not count the special characters in the string as special characters does not create words
	 * This method does not count the numbers in the string as numbers does not create the words
	 * This method avoid the case sensitivity and counts the words as hello and Hello will be counted as 2 as both are the same words
	 */
	@Override
	public Map<String, Integer> countOccurrencesOfWordsWithin(String stringToEvaluate) {
		
		if(logger.isDebugEnabled()){
			logger.debug("This is stringToEvaluate : " + stringToEvaluate);
		}
		//Used LinkedHashMap in order to maintain the order of the words
		Map<String, Integer> map = new LinkedHashMap<>();
		int count = 0;
		if (null != stringToEvaluate && !"".equals(stringToEvaluate)) {
			String[] stringArray = stringToEvaluate.split(" ");

			for (String s : stringArray) {
				if (s.matches("[a-zA-Z]+")) {
					s = s.toLowerCase();
					if (map.get(s) != null) {
						count = map.get(s);
						map.put(s, count + 1);
					} else {
						map.put(s, 1);
					}
				}
			}
		}
		logger.debug("This is final Map : " + map);
		return map;
	}

}
