package µÚ¶þÌâ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtil {
	
	public static boolean writeAllBooks(Book[] bs) {
		boolean flag = false;
		ObjectOutputStream oos = null;
		
		try {
			File file = new File("c:/kaile.txt");
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			oos.writeObject(bs);
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}
	
	public static Book[] readAllBooks() {
		Book[] bs = null;
		ObjectInputStream ois = null;
		
		try {
			File file = new File("c:/kaile.txt");
			
			if(file.length() > 0) {
				ois = new ObjectInputStream(new FileInputStream(file));
				bs = (Book[])ois.readObject();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return bs;
	}
	
	
	
	
	
	
}
