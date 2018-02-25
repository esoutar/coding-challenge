package com.interset.interview.calculate;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

import com.interset.interview.calculate.SiblingAverageCalculator;
import com.interset.interview.calculate.StatCalculator;
import com.interset.interview.model.DataRow;

public class SiblingAverageCalculatorTest {

	@Test
	public void testSiblingAverage() {
		List<DataRow> rows = new ArrayList<DataRow>();
		rows.add(new DataRow("John", "Smith", 2, "Pumpkin pie", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Jane", "Doe", 4, "Butter Tarts", TimeZone.getTimeZone("GMT+2:00"), Instant.ofEpochMilli(626219060000L)));
		
		StatCalculator siblingStats = new SiblingAverageCalculator();
		assertEquals(String.format(SiblingAverageCalculator.MESSAGE, 3.0d), siblingStats.calculateStat(rows));
	}
}
