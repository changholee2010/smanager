package co.yedam.common;

/*
 * 메인메뉴와 서버메뉴의 출력구분하기 위한 메소드.
 */
public class Utils {
	public static void printMessage(String msg) {
		System.out.println(msg);
	}

	public static void printMainMenu(String msg) {
		System.out.println("" + msg);
	}

	public static void printSubMenu(String msg) {
		System.out.println("    " + msg);
	}

	public static void printSubMenuNoLine(String msg) {
		System.out.print("    " + msg);
	}
}
