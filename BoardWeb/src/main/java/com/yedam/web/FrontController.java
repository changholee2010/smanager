package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardForm;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoard;
import com.yedam.control.ModifyBoard;
import com.yedam.control.RemoveBoard;
import com.yedam.control.StudentListControl;
import com.yedam.control.UpdateBoard;

/*
 * FrontController 역할은 사용자의 모든 요청을 처리.
 * 서블릿. a.do, sample.do
 * 객체생성 -> init -> service -> destroy.
 */
public class FrontController extends HttpServlet {

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		// 글등록 구현: 등록화면(boardForm.do) + DB등록(addBoard.do) -> 글목록페이지이동.
		map.put("/boardForm.do", new BoardForm());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/board.do", new BoardControl());
		// 삭제
		map.put("/removeBoard.do", new RemoveBoard()); // 삭제화면
		map.put("/deleteBoard.do", new DeleteBoard()); // 삭제처리
		// 수정
		map.put("/modifyBoard.do", new ModifyBoard()); // 수정화면
		map.put("/updateBoard.do", new UpdateBoard()); // 수정처리

		// 학생목록.
		map.put("/stdList.do", new StudentListControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		// boardList.do -목록. addBoard.do -등록.
		String uri = req.getRequestURI(); // URL(http://localhost/BoardWeb/boardList.do) vs. URI
		String context = req.getContextPath(); // 프로젝트 명.
		String path = uri.substring(context.length()); // "/boardList.do"

		System.out.println(path); // /board.do
		Control sub = map.get(path);
		sub.exec(req, resp);

	}
}
