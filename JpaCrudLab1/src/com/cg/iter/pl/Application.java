  
package com.cg.iter.pl;


import java.util.Scanner;

import com.cg.iter.bean.Author;
import com.cg.iter.service.AuthorService;
import com.cg.iter.service.AuthorServiceImpl;

public class Application {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		AuthorService service = new AuthorServiceImpl();
		try {
			while(true) {
				System.out.println("---------MENU--------");
				System.out.println("1. Enter New Author");
				System.out.println("2. Update Author");
				System.out.println("3. Delete Author");
				System.out.println("4. Exit");
				System.out.println("Enter your choice");
				int choice = 0;
				choice =scan.nextInt();
				switch(choice) {
					case  1:
					//Adding Author
						Author author = new Author();
						System.out.println("Enter firstname");
						author.setFirstName(scan.nextLine());
						System.out.println("Enter middlename");
						author.setMiddleName(scan.nextLine());
						System.out.println("Enter lastname");
						author.setLastName(scan.nextLine());
						System.out.println("Enter phone number");
						author.setPhoneNo(scan.nextLong());
						if(service.addAuthor(author)) {
							System.out.println("author added");
						}else {
							System.out.println("author not added");
						}
						break;
					case 2:
						System.out.println("Enter author id");
						int id = scan.nextInt();
						author = service.findAuthor(id);
						if(author != null) {
							System.out.println("Author eixst");
							System.out.println(author.toString());
							Author temp = new Author();
							temp.setAuthorId(author.getAuthorId());
							System.out.println("Enter firstname");
							temp.setFirstName(scan.next());
							System.out.println("Enter middlename");
							temp.setMiddleName(scan.next());
							System.out.println("Enter lastname");
							temp.setLastName(scan.next());
							System.out.println("Enter phone number");
							temp.setPhoneNo(scan.nextLong());
							if(service.updateAuthor(temp)==true) {
								System.out.println("Author updated");
							}else {
								System.out.println("Not updated");
							}
						}else {
							System.out.println("Author does not exist");
						}
						break;
					case 3:
						System.out.println("Enter author id");
						id = scan.nextInt();
						if(service.deleteAuthor(id)) {
							System.out.println("Author deleted");
						}else {
							System.out.println("Author not deleted");
						}
						break;
					default:
						System.exit(0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}