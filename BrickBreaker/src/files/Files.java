package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Files {
	
	private static String filePath = getDefaultDirectory() + "/BrickBreaker/";
	public static String LEVELPATH = getDefaultDirectory() + "/BrickBreaker/Levels.txt";
	
	public Files() {}
	
	public static void init() {
		createDir(filePath);
		createFile(LEVELPATH);
	}
	
	public static void writeLevel(File file, int level, int[][] grid) {
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			for (int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[0].length; j++) {
					writer.write(grid[i][j] + " ");
				}
				writer.write("\n"); // jeda ke baris berikutnya
			}
			System.out.println("Writing to file");
			writer.close();
		} catch (IOException e) {}
	}

	public static void createFile(String filePath) {
		File path = new File(filePath);
		if (!path.exists()) {
			try {
				path.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createDir(String filePath) {
		File path = new File(filePath);
		if (!path.exists()) {
			path.mkdir();
		}
	}

	public static void writeFile(File file, boolean[] lockedLevels) {
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			System.out.println();
			writer.close();
		} catch (IOException e) {}
	}
	
	public static void writeLevel(File file, int[][] grid) {
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			for (int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++) {
					writer.write("" + grid[i][j] + " ");
				}
				writer.append("\n");
			}
			writer.close();
		} catch (IOException e) {
		}
	}

	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
	}

	public static String getDefaultDirectory() {
		// disimpan dalam %appdata% di windows atau Application Support di mac
		String OS = System.getProperty("os.name").toUpperCase();
		
		if (OS.contains("WIN")) {
			return System.getenv("APPDATA");
		}
		if (OS.contains("MAC")) {
			return System.getProperty("user.home") + "/Library/Application Support";
		}
		return System.getProperty("user.home");
	}
}
