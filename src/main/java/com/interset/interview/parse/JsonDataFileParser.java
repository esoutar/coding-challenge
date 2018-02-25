package com.interset.interview.parse;

import java.io.IOException;
import java.io.Reader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.interset.interview.model.DataRow;

public class JsonDataFileParser implements DataFileParser {

	private final Reader reader;
	
	public JsonDataFileParser(Reader reader) {
		this.reader = reader;
	}

	/* (non-Javadoc)
	 * @see com.interset.interview.parse.DataFileParser#parseData()
	 */
	@Override
	public List<DataRow> parseData() throws IOException {
		Gson gson = new Gson();
		IntermediateRow[] intermediateRows = gson.fromJson(reader, IntermediateRow[].class);
		List<DataRow> rows = new ArrayList<DataRow>();
		
		for(IntermediateRow r : intermediateRows) {
			rows.add(new DataRow(r.first_name,
									r.last_name,
									r.siblings,
									r.favourite_food,
									TimeZone.getTimeZone("GMT" + r.birth_timezone),
									Instant.ofEpochMilli(r.birth_timestamp)));
		}
		
		reader.close();
		
		return rows;
	}

	private static class IntermediateRow {
		public String first_name;
		public String last_name;
		public int siblings;
		public String favourite_food;
		public String birth_timezone;
		public long birth_timestamp;
		
	}
}
