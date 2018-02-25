package com.interset.interview.calculate;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

import com.interset.interview.model.DataRow;

public class FavouriteFoodCalculatorTest {

	@Test
	public void testSiblingAverage() {
		List<DataRow> rows = new ArrayList<DataRow>();
		rows.add(new DataRow("John", "Smith", 2, "Pumpkin Pie", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Jane", "Doe", 4, "Butter Tarts", TimeZone.getTimeZone("GMT+2:00"), Instant.ofEpochMilli(626219060000L)));
		rows.add(new DataRow("Twin", "Doe", 4, "Butter Tarts", TimeZone.getTimeZone("GMT+2:00"), Instant.ofEpochMilli(626219060000L)));
		rows.add(new DataRow("Suzy", "Q", 2, "Pizza", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Mad", "Max", 2, "Pizza", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Happy", "Gilmour", 2, "Pizza", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Fred", "Flinstone", 2, "Pizza", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Jeremy", "Fisher", 2, "Pumpkin Pie", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Forest", "Gump", 2, "Pumpkin Pie", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		rows.add(new DataRow("Delores", "Umbridge", 2, "Liver", TimeZone.getTimeZone("GMT-5:00"), Instant.ofEpochMilli(726219060000L)));
		
		StatCalculator foodStats = new FavouriteFoodCalculator();
		assertEquals(String.format(FavouriteFoodCalculator.MESSAGE, "Pizza (4)", "Pumpkin Pie (3)", "Butter Tarts (2)"), foodStats.calculateStat(rows));
	}
}
