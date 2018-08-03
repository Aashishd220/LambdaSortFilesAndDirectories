//printing all the files and directories that too in sorted order
package com.cg.lambdasortfilesanddirectories;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class SortFilesAndDirectories {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<File> files = new ArrayList<>();

		System.out.println("Enter directory");
		String filepath = scanner.nextLine();// taking path from user
		File directory = new File(filepath);// passing path to path

		File[] file = directory.listFiles();// listFiles method returns an array of pathnames

		files.addAll(Arrays.asList(file));// adding all
		Predicate<File> findDirectories = (fileInList) -> fileInList.isDirectory();// using lambda

		files.stream().filter(findDirectories).sorted().forEach(System.out::println);
		files.stream().filter(findDirectories.negate()).sorted().forEach(System.out::println);

	}
}