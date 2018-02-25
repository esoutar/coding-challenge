package com.interset.interview;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.interset.interview.calculate.BirthMonthCalculator;
import com.interset.interview.calculate.FavouriteFoodCalculator;
import com.interset.interview.calculate.SiblingAverageCalculator;
import com.interset.interview.calculate.StatCalculator;
import com.interset.interview.model.DataRow;
import com.interset.interview.parse.DataFileParser;
import com.interset.interview.parse.DataFileParserFactory;

public class StatsApplication {

	private static StatsApplication instance;
	private static Object mutex = new Object();
	
	/**
	 * All statistic calculators are registered here. Adding a new one is as simple as adding to this array.
	 */
	private static final StatCalculator[] STAT_CALCULATORS = new StatCalculator[] {new SiblingAverageCalculator(), 
																					new FavouriteFoodCalculator(), 
																					new BirthMonthCalculator()};
	
	private StatsApplication() {
		// This is a singleton. Nobody can construct it externally.
	}
	
	/**
	 * @return Application instance. Application state would be isolated here if there were any.
	 */
	public static final StatsApplication getInstance() {
		if(instance == null) {
			synchronized(mutex) {
				/* Check for null again. If multiple threads attempt to create an instance at 
				 * the same time, only one will be allowed into the synchronized block. Other 
				 * threads will need to re-check whether the singleton has been instantiated 
				 * once in the synchronized block.
				 */
				
				if(instance == null) {
					instance = new StatsApplication();
				}
			}
		}
		
		return instance;
	}
	
	/**
	 * Parses the input file, and executes each calculation as defined in STAT_CALCULATORS.
	 * 
	 * @param file The file containing population statistics
	 * @return An array of string representing a report containing results for each calculation.
	 */
	public String[] handleFile(File file) {
		try {
			DataFileParser parser = DataFileParserFactory.getParser(file);
			List<DataRow> rows = parser.parseData();
			return Arrays.stream(STAT_CALCULATORS).map(c -> c.calculateStat(rows)).toArray(String[]::new);
		} catch (IOException e) {
			System.out.println("Could not read file " + file.getAbsolutePath());
		}
		
		return null;
	}
}
