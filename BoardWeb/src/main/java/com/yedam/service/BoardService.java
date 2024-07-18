package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * MVC 패턴의 디자인에 따라서 Model영역(service, dao:mapper).
 * 책: 4강 MVC기반 웹프로젝트 참고.
 * 숙제: 536~540 페이지 MVC에 자세히 읽고 오세요.
 */
public interface BoardService {
	List<BoardVO> boardList();
	boolean addBoard(BoardVO board);
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	BoardVO getBoard(int boardNo);
}
