package net.ukr.andy777;

/*
 Lesson05.Task1
 Напишите программу, которая скопирует файлы с заранее определенным расширением 
 (например, только doc) из каталога источника в каталог приемник.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		File folderSource = new File(".\\1");
		File folderReceiver = new File(".\\2");
		folderReceiver.mkdirs();

		System.out.print("input extension of files to copy from folder "
				+ folderSource.getPath() + " -->> to folder "
				+ folderReceiver.getPath() + " - ");
		String ext = new Scanner(System.in).next();
		MyFileFilter mFF = new MyFileFilter(ext);

		File[] fileList = folderSource.listFiles(mFF);
		for (File in : fileList) {
			try {
				File out = new File(folderReceiver.getPath() + "\\"
						+ in.getName());
				System.out.println("- file - " + in.getName() + " - copied");
				FileOperation.fileCopy(in, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}