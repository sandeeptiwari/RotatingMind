package com.sandi.funcprog;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAndDirectory {

	public static void main(String[] args) throws IOException {
		
		Files.list(Paths.get("."))
		     .forEach(System.out::println);
		
		System.out.println("If you are looking subdirectory");
		
		Files.list(Paths.get("."))
		     .filter(Files::isDirectory)
		     .forEach(System.out::println);
		
		System.out.println("how we’d select only the java files in a directory");
		
		final String[] files = 
					new File("src/com/sandi/funcprog").list(new FilenameFilter() {

						@Override
						public boolean accept(File dir, String name) {
							return name.endsWith(".java");
						}
					});
		System.out.println(files);
		
		final String[] files1 = 
				//new File("src/com/sandi/funcprog").list((File dir, String name) -> name.endsWith(".java"));
				new File("src/com/sandi/funcprog").list((dir, name) -> name.endsWith(".java"));
	
	    //OR
		
		Files.newDirectoryStream(
				Paths.get("src/com/sandi/funcprog"), path -> path.toString().endsWith(".java"))
		       .forEach(System.out::println);
		
		System.out.println("listing all hidden files in the current directory");
		
		//final File[] hiddenFiles = new File(".").listFiles(file -> file.isHidden());
		
		final File[] hiddenFiles = new File(".").listFiles(File::isHidden);
		
	
		fileCountInDir();
	}
	
	public static void fileCountInDir() {
		List<File> files = 
				 Stream.of(new File(".").listFiles())
				 .flatMap(file -> file.listFiles() == null ?
						 Stream.of(file) : Stream.of(file.listFiles()))
				 .collect(Collectors.toList());
		System.out.println("Count :: "+files.size());
	}

}
