package com.ubs.opsit.interviews.wordfrequency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.not;

import com.ubs.opsit.interviews.wordfrequency.impl.WordFrequencyImpl;

/**
 * @author admin
 *
 */
/**
 * @author admin
 *
 */
/**
 * @author admin
 *
 */
/**
 * @author admin
 *
 */
public class WordFrequencyTest {

	WordFrequencyImpl impl = null;

	@Before
	public void init() {
		impl = new WordFrequencyImpl();
	}

	/**
	 * This test case counts the occurrence of each word in given string, hence "hello count 2" and "hongkong count 1" and "ubs count 1"
	 */
	@Test
	public void testWordFreq_withSmallString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin("hello hongkong hello ubs");
		assertThat(map.size(), is(3));
		assertThat(map, IsMapContaining.hasEntry("hello", 2));
		assertThat(map, IsMapContaining.hasEntry("hongkong", 1));
		assertThat(map, IsMapContaining.hasEntry("ubs", 1));
	}

	/**
	 * This test case counts the occurrence of each word in given string like football-3,badminton-3,play-3,love-2,when-1 etc..
	 */
	@Test
	public void testWordFreq_withLongString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin(
				"when i was a child i used to love playing football but now i love playing badminton what about you what is your favourite game you like to play football or badminton i play badminton over weekend but i do not play football nowadays any ways weekend is coming what is your plan");
		assertThat(map, IsMapContaining.hasEntry("when", 1));
		assertThat(map, IsMapContaining.hasEntry("badminton", 3));
		assertThat(map, IsMapContaining.hasEntry("football", 3));
		assertThat(map, IsMapContaining.hasEntry("i", 5));
		assertThat(map, IsMapContaining.hasEntry("love", 2));
		assertThat(map, IsMapContaining.hasEntry("play", 3));
		assertThat(map, IsMapContaining.hasEntry("playing", 2));
		assertThat(map, IsMapContaining.hasEntry("what", 3));
		assertThat(map, IsMapContaining.hasEntry("but", 2));
		assertThat(map, IsMapContaining.hasEntry("child", 1));
		assertThat(map, IsMapContaining.hasEntry("weekend", 2));
		assertThat(map, IsMapContaining.hasEntry("game", 1));
		assertThat(map, IsMapContaining.hasEntry("is", 3));
	}
	
	/**
	 * This test case counts the occurrence of each word in given case sensitive string like there are two "hello" and "Hello" but this is the same word so program should not be
	 * sensitive and it should count 2 hello hence hello,Hello count- 2
	 */
	@Test
	public void testWordFreq_withCaseSensitiveString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin("hello world Hello ubs");
		assertThat(map, IsMapContaining.hasEntry("hello", 2));
		assertThat(map, IsMapContaining.hasEntry("world", 1));
		assertThat(map, IsMapContaining.hasEntry("ubs", 1));
	}
	
	/**
	 * This test case test the program with empty string, map size should be 0 because there is no word to count
	 */
	@Test
	public void testWordFreq_withEmptyString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin("");
		assertThat(map.size(), is(0));
	}
	
	/**
	 * This test case test the program with null string, map size should be 0 because there is no word to count
	 */
	@Test
	public void testWordFreq_withNullString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin(null);
		assertThat(map.size(), is(0));
	}
	
	/**
	 * This test case test the program with only one word and returns the count 1
	 */
	@Test
	public void testWordFreq_withOneWordString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin("hello");
		assertThat(map.size(), is(1));
		assertThat(map, IsMapContaining.hasEntry("hello", 1));
	}
	
	/**
	 * This test case test the program with special characters string, as special characters does not create a word so it does not count the special characters, hence there will
	 * not be any entry of &%#!)* in map
	 */
	
	@Test
	public void testWordFreq_withSpecialCharacterString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin("this is &%#!)* name");
		assertThat(map, IsMapContaining.hasEntry("this", 1));
		assertThat(map, IsMapContaining.hasEntry("is", 1));
		assertThat(map, IsMapContaining.hasEntry("name", 1));
		assertThat(map, not(IsMapContaining.hasEntry("&%#!)*",1)));
		}
	
	/**
	 * This test case test the program with special characters and numbers string, as special characters and numbers do not create a word so it does not count the special characters
	 * and numbers hence there will not be any entry of &%#!)* and 68787 in map
	 */
	
	@Test
	public void testWordFreq_withNuberString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin("this is 68787 &%#!)* name");
		assertThat(map, IsMapContaining.hasEntry("this", 1));
		assertThat(map, IsMapContaining.hasEntry("is", 1));
		assertThat(map, IsMapContaining.hasEntry("name", 1));
		assertThat(map, not(IsMapContaining.hasEntry("&%#!)*",1)));
		assertThat(map, not(IsMapContaining.hasEntry("68787",1)));
		}
	
	/**
	 * This program test the correctness of the program like it should only count the words not special characters and numbers and word with special characters and numbers
	 */
	@Test
	public void testWordFreq_withMiscString() {
		Map<String, Integer> map = impl.countOccurrencesOfWordsWithin("this687878$$$##### is 68787 &%#!)* name");
		assertThat(map, not(IsMapContaining.hasEntry("this", 1)));
		assertThat(map, IsMapContaining.hasEntry("is", 1));
		assertThat(map, IsMapContaining.hasEntry("name", 1));
		assertThat(map, not(IsMapContaining.hasEntry("&%#!)*",1)));
		assertThat(map, not(IsMapContaining.hasEntry("68787",1)));
		}
}
