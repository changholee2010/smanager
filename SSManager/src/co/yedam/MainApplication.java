package co.yedam;

import java.util.Scanner;

import co.yedam.common.Utils;
import co.yedam.control.CourseControl;
import co.yedam.control.StudentControl;

public class MainApplication {
	public static void main(String[] args) {
		// 프로그램의 시작.
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while (run) {
			Utils.printMainMenu("\n================================");
			Utils.printMainMenu("1.학생관리 2.강좌관리 3.수강관리 4.종료");
			Utils.printMainMenu("================================");
			
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				StudentControl control1 = new StudentControl();
				control1.run();
				break;
			case 2:
				CourseControl control2 = new CourseControl();
				control2.run();
				break;
			case 3:
				System.out.println("수강관리.");
				break;
			case 4:
				System.out.println("종료합니다.");
				run = false;
			}
			// 요기수정됨.
		}
	}
}
