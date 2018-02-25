package com.interset.interview.calculate;

import java.util.List;

import com.interset.interview.model.DataRow;

public interface StatCalculator {

	/**
	 * @param rows The rows to use in the calculation
	 * @return A message detailing the results of the calculation
	 */
	String calculateStat(List<DataRow> rows);
}
