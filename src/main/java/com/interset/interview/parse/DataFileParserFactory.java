package com.interset.interview.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.FilenameUtils;

public final class DataFileParserFactory {

	private static final String CSV = "csv";
	private static final String JSON = "json";
	private static final String GZ = "gz";
	
	/**
	 * Handles CSV and JSON files that are either uncompressed or in a gz archive.
	 * 
	 * @param file The file to be parsed
	 * @return a parser ready to parse the input file
	 * @throws IOException
	 */
	public static DataFileParser getParser(File file) throws IOException {
		if(file == null || !file.exists() || !file.canRead()) {
			throw new IllegalArgumentException("Invalid file.");
		}
		
		String extension = FilenameUtils.getExtension(file.getName()).toLowerCase();

		if(CSV.equals(extension)) {
			return new CsvDataFileParser(new FileReader(file));
		} else if(JSON.equals(extension)) {
			return new JsonDataFileParser(new FileReader(file));
		} else if(GZ.equals(extension)) {
			@SuppressWarnings("resource")
			Reader gzReader = new InputStreamReader(new GZIPInputStream(new FileInputStream(file)));
			String nestedExtension = FilenameUtils.getExtension(FilenameUtils.removeExtension(file.getName()));
			
			if(CSV.equals(nestedExtension)) {
				return new CsvDataFileParser(gzReader);
			} else if(JSON.equals(nestedExtension)) {
				return new JsonDataFileParser(gzReader);
			}
		}
			
		throw new IllegalArgumentException("Unknown file type.");
	}
}
