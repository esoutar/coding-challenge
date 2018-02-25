package com.interset.interview.calculate;

import java.util.List;

import com.interset.interview.model.DataRow;

public class SiblingAverageCalculator implements StatCalculator {

	static final String MESSAGE = "Average siblings: %f";
	
	/* (non-Javadoc)
	 * @see com.interset.interview.calculate.StatCalculator#calculateStat(java.util.List)
	 */
	@Override
	public String calculateStat(List<DataRow> rows) {
		double result = rows.stream()
							.mapToInt(DataRow::getSiblings)
							.average()
							.getAsDouble();
		
		return String.format(MESSAGE, result);
	}

}
