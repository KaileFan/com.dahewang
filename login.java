package 第二题;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class login {
	public static void log() throws Exception {
		Scanner shuru = new Scanner(System.in);
		System.out.print("输入账号:");
		String zhanghao = shuru.next();
		System.out.print("输入密码:");
		String mima=shuru.next();
		File f=new File("c:/kaile.txt");
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM/dd HH:mm:ss");
		String tim=dateFormat.format(now);
		System.out.println(tim);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("c:/kaile.txt")));
		oos.writeObject(zhanghao);
		oos.writeObject(mima);
		oos.writeObject(tim);
		oos.flush();
		oos.close();
	}
}
