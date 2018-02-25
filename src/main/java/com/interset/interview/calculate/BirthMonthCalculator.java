package com.interset.interview.calculate;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.interset.interview.model.DataRow;

public class BirthMonthCalculator implements StatCalculator {

	static final String MESSAGE = "Birth Months: January (%d), February (%d), March (%d), April (%d), May (%d), June (%d), July (%d), August (%d), September (%d), October (%d), November (%d), December (%d)";

	/* (non-Javadoc)
	 * @see com.interset.interview.calculate.StatCalculator#calculateStat(java.util.List)
	 */
	@Override
	public String calculateStat(List<DataRow> rows) {
		Map<Integer, List<Month>> groupedMonths = rows.stream()
														.map(r -> r.getBirthTimestamp().atZone(r.getBirthTimezone().toZoneId()).getMonth())
														.collect(Collectors.groupingBy(Month::getValue));
		
		return String.format(MESSAGE, 
								monthCount(groupedMonths, 1),
								monthCount(groupedMonths, 2),
								monthCount(groupedMonths, 3),
								monthCount(groupedMonths, 4),
								monthCount(groupedMonths, 5),
								monthCount(groupedMonths, 6),
								monthCount(groupedMonths, 7),
								monthCount(groupedMonths, 8),
								monthCount(groupedMonths, 9),
								monthCount(groupedMonths, 10),
								monthCount(groupedMonths, 11),
								monthCount(groupedMonths, 12));
	}
	
	private int monthCount(Map<Integer, List<Month>> groupedMonths, int monthValue) {
		List<Month> toCount = groupedMonths.get(monthValue);
		
		if (toCount == null) {
			return 0;
		}
		
		return toCount.size();
	}

}
 