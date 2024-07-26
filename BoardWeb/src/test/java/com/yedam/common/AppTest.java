package com.yedam.common;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();

		SearchVO search = new SearchVO();
		search.setBno(148);
		search.setPage(5);

		svc.replyList(search).forEach(System.out::println);

		System.out.println("- End -");

	}
}
