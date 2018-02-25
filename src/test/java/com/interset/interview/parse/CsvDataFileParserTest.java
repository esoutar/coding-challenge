package com.interset.interview.parse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

import com.interset.interview.model.DataRow;

public class CsvDataFileParserTest {

	@Test
	public void testParseCSV() throws IOException {
		URL url = CsvDataFileParserTest.class.getResource("/population_sample.csv");
		DataFileParser parser = DataFileParserFactory.getParser(new File(url.getFile()));
		List<DataRow> rows = parser.parseData();
		
		assertNotNull(rows);
		assertEquals(1000, rows.size());
		assertEquals("NUMBERS", rows.get(5).getFirstName());
		assertEquals("GASE", rows.get(75).getLastName());
		assertEquals(1, rows.get(56).getSiblings());
		assertEquals("Cheddar cheese", rows.get(673).getFavouriteFood());
		assertEquals(TimeZone.getTimeZone("GMT-02:00"), rows.get(8).getBirthTimezone());
		assertEquals(Instant.ofEpochMilli(832504840000L), rows.get(7).getBirthTimestamp());
	}
}
