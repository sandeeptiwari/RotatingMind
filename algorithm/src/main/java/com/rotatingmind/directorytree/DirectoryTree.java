package com.rotatingmind.directorytree;

import java.io.*;
import java.lang.StringBuilder;
import java.util.Stack;
import java.util.Arrays;

public class DirectoryTree {

	public static void main(String[] args) {

		int limit = 5;
		String file = System.getProperty("log_dir","D:\\sw");
		String method = "i";

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-l")) {
				limit = Integer.parseInt(args[i + 1]);
			} else if (args[i].equals("-f")) {
				file = args[i + 1];
			} else if (args[i].equals("-m")) {
				method = args[i + 1];
			}
		}

		System.out.print(buildTree(new File(file), limit, method));
	}

	public static String buildTree(File file, int limit, String  method) {
		String result = "";
		if (method.equals("i")) {
			long start = System.nanoTime();
			result = buildTree(file, limit).toString();
			result += "Took: " + ((double) (System.nanoTime() - start) / 1000000000) + " second(s)" + "\n";
		} else if (method.equals("r")) {
			long start = System.nanoTime();
			result = buildTree(0, new StringBuilder(20), new StringBuilder(10000000), file, limit, true).toString();
			result += "Took: " + ((double) (System.nanoTime() - start) / 1000000000) + " second(s)" + "\n";
		}
		return result;
	}

	public static StringBuilder buildTree(int depth, StringBuilder indent, StringBuilder dirTree, File startingDir, int limit, boolean isTail) {

		dirTree.append(indent.append((isTail ?  "└── " : "├── " )).append(startingDir.getName()).append("\n"));
		indent.setLength(indent.length() - (startingDir.getName().length() + 5));

		if (startingDir.isFile()) return dirTree;

		if (depth < limit) {
			File[] files = startingDir.listFiles();
			if (files != null && files.length != 0) {
				indent.append((isTail ?  "    "  : "│   "));
				for (int i = 0; i < files.length; i++) {
					buildTree(depth + 1, indent, dirTree, files[i], limit, i == files.length - 1 ? true : false);
				}
				indent.setLength(indent.length() - 4);
			}
		}

		return dirTree;
	}

	public static StringBuilder buildTree(File startingDir, int limit) {

		Stack<File> stack = new Stack<>();
		stack.push(startingDir);

		// Another Implemenation (Removes the need for depth & changes values) (Possibly less efficient);
		// Stack<File> parents = new Stack<>();

		// Can't set parent here because of some weird reason.  (Blame Java/Bash);
		// File parent = startingDir.getParentFile();
		File parent = null;

		int depth = 0;
		boolean isTail = false;

		StringBuilder indent = new StringBuilder(20);
		StringBuilder dirTree = new StringBuilder(10000000);

		while (!stack.empty()) {

			File currentFile = stack.pop();

			/* if (!parents.empty()) {
				if (!currentFile.getParentFile().equals(parents.peek())) {
					parents.pop();
					indent.setLength(indent.length() - 4);
					stack.push(currentFile);
					continue;
				}
			}*/


			if (parent != null  && !currentFile.getParentFile().equals(parent)) {
				int changes = 0;
				File currentFileParent = currentFile.getParentFile();
				while (!currentFileParent.equals(parent)) {
					parent = parent.getParentFile();
					changes++;
				}
				indent.setLength(indent.length() - (changes * 4));
				depth -= changes;
			}

			// Prevents JVM OutOfMemoryException(Error?), currently not used.
			/* if (dirTree.length() > 10000000) {
				System.out.println(dirTree);
				dirTree.setLength(0);
			} */

			isTail = stack.empty() ?  true : !stack.peek().getParentFile().equals(currentFile.getParentFile());

			dirTree.append(indent.append((isTail ?  "└── " : "├── " )).append(currentFile.getName()).append( "\n"));
			indent.setLength(indent.length() - (currentFile.getName().length() + 5));

			if (depth < limit) {
				if (currentFile.isDirectory() && currentFile.listFiles().length != 0) {
					indent.append((isTail ?  "    "  : "│   "));
					// parents.push(currentFile);
					parent = currentFile;
					depth++;
					for (File file : currentFile.listFiles()) {
						stack.push(file);
					}
				}
			}
		}
		return dirTree;
	}
}
