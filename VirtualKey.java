package virtual;
import java.util.Scanner;
import java.util.Collections;
import java.io. File;
import java.io. IOException;
import java.util.Arrays;
import java.util.List;
public class VirtualKey {
	public static void display() {
		System.out.println("Choose one of the below options...");
		System.out.println("1. Display files in ascending order \n 2.File Operations \n 3.Exit Application");
	}
	public static void sort() {
		File f=new File("D:\\project file");
		
			if(f.isDirectory()) {
				List<String> listFile =Arrays.asList(f.list());
				Collections.sort(listFile);
				for(String k:listFile) {
				System.out.println(k);
			}
			}
			else {
				System.out.println("No Files Found");
				
			}VirtualKey.display();
		}
		
	public static void operations() {
		System.out.println("Choose one of the below operations");
		System.out.println("1. Create a new File \n2. Delete existing File \n3. Search for a File \n4. Exit");
	      Scanner sc1 = new Scanner (System.in);
			try {
				int n1=sc1.nextInt();
				switch(n1) {
				case 1: System.out.println("Creating a new File");
				createfile();
				break;
				case 2: System.out.println("Delete existing File");
				deletefile();
				break;
				case 3: System.out.println("Search for a File");
				searchfile();
				break;
				case 4: System.out.println("Exit");
				break;		
			}	
			
		}catch(Exception e) {
			System.out.println("Invalid number");
			VirtualKey.operations();
		}
		}
	private static void searchfile() {
		System.out.println("Enter the file name that you want to search...");
		Scanner s=new Scanner(System.in);
		String s1=s.nextLine();
		File f1=new File("D:\\project file"+s);
		if(f1.exists()) {
			System.out.println("File Exists in the location"+f1.getAbsolutePath());
			VirtualKey.operations();
		}
		else {
			System.out.println("File does not exist in the location");
			VirtualKey.operations();
		}
		
	}
	private static void deletefile() {
		System.out.println("Enter the file name that you want to delete... ");
		Scanner k=new Scanner(System.in);
		String s2=k.nextLine();
		File f2=new File("D:\\project file"+s2);
		if(f2.delete()) {
			System.out.println(f2.getName() +" File deleted Successfully");
			VirtualKey.operations();
		}
		else {
			System.out.println("File does not exist");
			VirtualKey.operations();
	}
	 
	}
	private static void createfile() throws IOException {
		System.out.println("Enter the file that you want to create");
		Scanner l=new Scanner(System.in);
			String s3=l.nextLine();
			File f3=new File("D:\\project file"+s3);
			try {
			if(f3.createNewFile()) {
				System.out.println(f3.getName() +" File created Successfully");
				VirtualKey.operations();
			}
			else {
				System.out.println("File already created "+f3+" in this location");
				VirtualKey.operations();
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
		
	public static void main(String[] args) {
		System.out.println("Virtual Key for your Repository...");
		Scanner sc=new Scanner(System.in);
		VirtualKey.display();
		while(true) {
		try {
			int n=sc.nextInt();
			switch(n) {
			case 1:System.out.println("The Files are sorted in ascending order..");
			sort();
			break;
			case 2:operations();
			break;
			case 3:System.out.println("Exit Application");
			System.exit(n);
			break;
			default: System.out.println("Invalid number..");
			break;
		}
		
		}catch(Exception e) {
		    System.out.println("Enter valid number");
		    VirtualKey.main(args);
		}
	
}
}
}