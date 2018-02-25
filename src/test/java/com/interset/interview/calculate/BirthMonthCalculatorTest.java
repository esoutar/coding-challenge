package com.interset.interview.calculate;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

import com.interset.interview.model.DataRow;

public class BirthMonthCalculatorTest {

	@Test
	public void testSiblingAverage() {
		List<DataRow> rows = new ArrayList<DataRow>();
		rows.add(new DataRow("John", "Smith", 2, "Pumpkin pie", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Jane", "Doe", 4, "Butter Tarts", TimeZone.getTimeZone("GMT+2:00"), Instant.ofEpochMilli(626219060000L)));
		rows.add(new DataRow("Twin", "Doe", 4, "Butter Tarts", TimeZone.getTimeZone("GMT+2:00"), Instant.ofEpochMilli(626219060000L)));
		
		StatCalculator monthStats = new BirthMonthCalculator();
		assertEquals(String.format(BirthMonthCalculator.MESSAGE, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0), monthStats.calculateStat(rows));
	}
}
