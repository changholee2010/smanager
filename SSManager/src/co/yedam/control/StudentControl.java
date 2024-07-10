package co.yedam.control;

import java.util.List;
import java.util.Scanner;

import co.yedam.common.Utils;
import co.yedam.dao.StudentDAO;
import co.yedam.vo.StudentVO;

/*
 * 사용자입력을 가이드, 처리된 결과 출력.
 */
public class StudentControl {
	Scanner scn = new Scanner(System.in);
	StudentDAO sdao = new StudentDAO();

	public void run() {
		boolean isTrue = true;

		while (isTrue) {
			Utils.printSubMenu("----------------------------------");
			Utils.printSubMenu("1.학생목록 2.등록 3.수정 4.삭제 5.상위메뉴");
			Utils.printSubMenu("----------------------------------");
			Utils.printSubMenuNoLine("선택> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				studentList();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				modifyStudent();
				break;
			case 4:
				break;
			case 5:
				Utils.printSubMenu("상위메뉴로 이동합니다.");
				isTrue = false;
			}
		}
	} // end of run().

	// 수정기능.
	void modifyStudent() {
		String sno = ""; // 블럭레벨 변수.
		while (true) {
			Utils.printSubMenuNoLine("변경할 학생번호>");
			sno = scn.nextLine();
			if (sdao.selectExists(sno) == 1) {
				// 학생번호 존재.
				break;
			}
			Utils.printSubMenu("찾는 학생번호가 없음 학생번호 다시 입력>");
		}

		Utils.printSubMenuNoLine("변경할 연락처>");
		String phone = scn.nextLine();
		Utils.printSubMenuNoLine("변경할 주소>");
		String addr = scn.nextLine();

		StudentVO svo = new StudentVO();
		svo.setAddress(addr);
		svo.setStdPhone(phone);
		svo.setStdNo(sno);

		if (sdao.updateStudent(svo)) {
			Utils.printSubMenu("수정완료!");
		}
	}

	// 등록 기능.
	void addStudent() {
		Utils.printSubMenuNoLine(">학생번호 입력.");
		String sno = scn.nextLine();
		Utils.printSubMenuNoLine(">학생이름 입력.");
		String sname = scn.nextLine(); // ""
		Utils.printSubMenuNoLine(">연락처 입력.");
		String phon = scn.nextLine();
		Utils.printSubMenuNoLine(">주소 입력.");
		String addr = scn.nextLine();
		Utils.printSubMenuNoLine(">생일 입력.");
		String birth = scn.nextLine();

		StudentVO std = new StudentVO();
		std.setStdNo(sno);
		std.setStdName(sname);
		std.setStdPhone(phon);
		std.setAddress(addr);
		std.setBirthDate(birth);

		// 입력기능 호출.
		if (sdao.insertStudent(std)) {
			Utils.printSubMenu("저장완료!");
		} else {
			Utils.printSubMenu("처리중 예외발생!");
		}
	}

	// 목록 출력 기능.
	void studentList() {
		List<StudentVO> students = sdao.selectList();
		Utils.printSubMenu("학생번호   학생이름  연락처");
		Utils.printSubMenu("--------------------------------");
		for (StudentVO svo : students) {
			Utils.printSubMenu(svo.briefShow());
		}

	} // end of studentList().

}
