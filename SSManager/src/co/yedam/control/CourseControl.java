package co.yedam.control;

import java.util.Scanner;

import co.yedam.common.Utils;
import co.yedam.dao.CourseDAO;

public class CourseControl {
	Scanner scn = new Scanner(System.in);
	CourseDAO sdao = new CourseDAO();

	public void run() {
		boolean isTrue = true;

		while (isTrue) {
			Utils.printSubMenu("-------------------------------------------");
			Utils.printSubMenu("1.강좌목록 2.강좌등록 3.강좌수정 4.강좌삭제 5.상위메뉴");
			Utils.printSubMenu("-------------------------------------------");
			Utils.printSubMenuNoLine("선택> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				Utils.printSubMenu("강좌목록보기 기능입니다.");
				break;
			case 2:
				Utils.printSubMenu("강좌등록 기능입니다.");
				break;
			case 3:
				Utils.printSubMenu("강좌수정 기능입니다.");
				break;
			case 4:
				Utils.printSubMenu("강좌삭제 기능입니다.");
				break;
			case 5:
				Utils.printSubMenu("상위메뉴로 이동합니다.");
				isTrue = false;
			}
		}
	} // end of run().
}
