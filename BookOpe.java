package �ڶ���;

import java.io.InputStream;
import java.util.Scanner;

public class BookOpe {

	private static Book[] bs;
	
	private static Scanner sc = new Scanner(System.in);
	
	static {
		bs = FileUtil.readAllBooks();
		
		// System.out.println(bs + ">>>>");
		
		// ��һ�γ������У� �ļ��ж�ȡ��bsΪnull
		if(bs == null) {
			
			bs = new Book[20];
			
			Book b1 = new Book("���μ�", 23.4, "��ж�");
			Book b2 = new Book("��¥��", 68.7, "��ѩ��");
			Book b3 = new Book("Java���", 110.5, "������");
			
			bs[0] = b1;
			bs[1] = b2;
			bs[2] = b3;
		}
		
	}

	public static void showAllBooks() {
		System.out.println("����\t\t�۸�\t\t����");
		for (Book book : bs) {
			if(book != null)
				System.out.println(book);
		}
		System.out.println("1.�޸�ͼ��  2.�˳�ϵͳ  3.����ͼ��  4.ͼ���¼�");
		
		choice();
	}
	
	public static void choice() {
		try {
			login.log();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("��ѡ��");
		try {
			InputStream is = System.in;
			
			char choice = (char)is.read();
			
			switch (choice) {
			case '1':
				editBook();
				break;
			case '2':
				
				System.out.println("\n��ӭ�´ι��٣�");
				
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
		// ������ڵ�ͼ������ ���δ������
		
		for (int i = 1; i < 4; i++) {
			System.out.print("�޸ĵ�ͼ��������ʣ" + (3-i) + "�λ��᣺");
			String bName = sc.next();
			
			Book temp = isExistBookName(bName);
			
			if(temp != null) {
				String price = "";
				do {
					System.out.print("������۸�");
					price = sc.next();
				}while(!FormatUitl.testPrice(price));
				
				System.out.print("���������ߣ�");
				String author = sc.next();
				
				
				temp.setBookPrice(Double.parseDouble(price));
				temp.setAuthor(author);
				
				// ͼ����Ϣ����޸ģ� �����ļ�
				FileUtil.writeAllBooks(bs);
				
				break;
			}
		}
		
	}

	/**
	 * @param bName
	 * @return ���ؽ����Ϊ�� ��ʾ�ҵ�ͼ��     null ��ʾδ�ҵ�
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
