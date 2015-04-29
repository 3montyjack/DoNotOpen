package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderClass {

	int lineMax;
	File path;
	FileReader reads;
	BufferedReader reader;
	String line;
	public String[] textLine;
	public String[] textDoc;
	public String[][] split;

	int r = 0;

	int iteration = 0;

	public ReaderClass(String path) {
		initialize(path);
		translate();
		split();
		closeReader();
	}
	
	public ReaderClass() {
		translate();
		split();
		closeReader();
	}
	
	public void initialize(String path) {
		try {
			reads = new FileReader(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		reader = new BufferedReader(reads);
		textLine = new String[256];
		read();
		textDoc = new String[lineMax];
		split = new String[lineMax][];
	}

	public void read() {
		try {
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				textLine[iteration] = line;
				iteration++;
				lineMax = iteration;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void translate() {
		for (int i = 0; i < lineMax; i++) {
			//System.out.println(textLine[i]);
			textDoc[i] = textLine[i];

		}
	}
	
	public int getNumValues() {
		return  lineMax;
	}

	public void split() {
		for (String row : textDoc) {
			split[r++] = row.split("\\ : ");
		}
		//System.out.println(split[1][1]);
	}

	public String getData(int line, int tick) {
		return split[line][tick];
	}
	
	public void closeReader() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Closing Error");
			e.printStackTrace();
		}
	}

}
