package com.interset.interview.parse;

import java.io.IOException;
import java.util.List;

import com.interset.interview.model.DataRow;

public interface DataFileParser {

	/**
	 * @return A list of parsed data rows
	 * @throws IOException
	 */
	List<DataRow> parseData() throws IOException;

}
