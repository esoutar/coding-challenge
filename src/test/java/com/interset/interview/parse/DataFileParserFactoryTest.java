package com.interset.interview.parse;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.interset.interview.parse.CsvDataFileParser;
import com.interset.interview.parse.DataFileParserFactory;
import com.interset.interview.parse.JsonDataFileParser;

public class DataFileParserFactoryTest {

	@Test
	public void testCreateCSVParser() throws IOException {
		URL url = DataFileParserFactoryTest.class.getResource("/population_sample.csv");
		assertTrue(DataFileParserFactory.getParser(new File(url.getFile())) instanceof CsvDataFileParser);
	}
	
	@Test
	public void testCreateJSONParser() throws IOException {
		URL url = DataFileParserFactoryTest.class.getResource("/population_sample.json");
		assertTrue(DataFileParserFactory.getParser(new File(url.getFile())) instanceof JsonDataFileParser);
	}
}
