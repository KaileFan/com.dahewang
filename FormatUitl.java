package 第二题;

public class FormatUitl {

	/**
	 * 验证价格：0.1  0.10  99.00  100.35    0.00  10.00  5.44   4   8   0.00
	 * @param price
	 */
	public static boolean testPrice(String price) {
		String reg = "([1-9]\\d*|0)(\\.\\d{1,2})?";
		return price.matches(reg);
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(testPrice("5.09"));
	}
	*/
	
	
}
