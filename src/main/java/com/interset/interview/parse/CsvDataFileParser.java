package com.interset.interview.parse;

import java.io.IOException;
import java.io.Reader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.interset.interview.model.DataRow;

public class CsvDataFileParser implements DataFileParser {

	private final Reader reader;
	
	public CsvDataFileParser(Reader reader) {
		this.reader = reader;
	}

	/* (non-Javadoc)
	 * @see com.interset.interview.parse.DataFileParser#parseData()
	 */
	@Override
	public List<DataRow> parseData() throws IOException {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = CsvSchema.emptySchema().withHeader();
		MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class).with(schema).readValues(reader);
		List<DataRow> rows = new ArrayList<DataRow>();
		while(it.hasNextValue()) {
			Map<String, String> value = it.nextValue();
			rows.add(new DataRow(value.get("first_name"),
									value.get("last_name"),
									Integer.parseInt(value.get("siblings")),
									value.get("favourite_food"),
									TimeZone.getTimeZone("GMT" + value.get("birth_timezone")),
									Instant.ofEpochMilli(Long.parseLong(value.get("birth_timestamp")))));
		}
		
		reader.close();
		
		return rows;
	}
}
