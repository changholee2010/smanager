package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		String title = req.getParameter("title");

		BoardVO brd = new BoardVO();
		brd.setContent(content);
		brd.setTitle(title);
		brd.setWriter(writer);

		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(brd)) {
			// 목록이동.
			resp.sendRedirect("boardList.do");
		}
	}

}
