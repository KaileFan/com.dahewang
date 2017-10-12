package 第二题;

import java.io.InputStream;
import java.util.Scanner;

public class BookOpe {

	private static Book[] bs;
	
	private static Scanner sc = new Scanner(System.in);
	
	static {
		bs = FileUtil.readAllBooks();
		
		// System.out.println(bs + ">>>>");
		
		// 第一次程序运行， 文件中读取的bs为null
		if(bs == null) {
			
			bs = new Book[20];
			
			Book b1 = new Book("西游记", 23.4, "吴承恩");
			Book b2 = new Book("红楼梦", 68.7, "曹雪芹");
			Book b3 = new Book("Java编程", 110.5, "凡凯乐");
			
			bs[0] = b1;
			bs[1] = b2;
			bs[2] = b3;
		}
		
	}

	public static void showAllBooks() {
		System.out.println("书名\t\t价格\t\t作者");
		for (Book book : bs) {
			if(book != null)
				System.out.println(book);
		}
		System.out.println("1.修改图书  2.退出系统  3.新增图书  4.图书下架");
		
		choice();
	}
	
	public static void choice() {
		try {
			login.log();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("请选择：");
		try {
			InputStream is = System.in;
			
			char choice = (char)is.read();
			
			switch (choice) {
			case '1':
				editBook();
				break;
			case '2':
				
				System.out.println("\n欢迎下次光临！");
				
				System.exit(0);
				break;
			default:
				break;
			}
			
			showAllBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	private static void editBook() {
		// 输入存在的图书名， 三次错误机会
		
		for (int i = 1; i < 4; i++) {
			System.out.print("修改的图书名，还剩" + (3-i) + "次机会：");
			String bName = sc.next();
			
			Book temp = isExistBookName(bName);
			
			if(temp != null) {
				String price = "";
				do {
					System.out.print("请输入价格：");
					price = sc.next();
				}while(!FormatUitl.testPrice(price));
				
				System.out.print("请输入作者：");
				String author = sc.next();
				
				
				temp.setBookPrice(Double.parseDouble(price));
				temp.setAuthor(author);
				
				// 图书信息如果修改， 存入文件
				FileUtil.writeAllBooks(bs);
				
				break;
			}
		}
		
	}

	/**
	 * @param bName
	 * @return 返回结果不为空 表示找到图书     null 表示未找到
	 */
	private static Book isExistBookName(String bName) {
		Book b = null;
		for (Book book : bs) {
			if(book != null) {
				if(book.getBookName().equals(bName)) {
					b = book;
					break;
				}
			}
		}
		return b;
	}
	
	
}
