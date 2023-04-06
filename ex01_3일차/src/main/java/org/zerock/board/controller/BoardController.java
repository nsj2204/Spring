package org.zerock.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.board.service.BoardServiceImpl;
import org.zerock.board.vo.BoardVO;

import lombok.extern.log4j.Log4j;

//자동 생성 어노테이션 - @Controller - 컨트롤러, @Service - 서비스, @Repository - 저장소(DAO), 
//@Component - 이외의 자동생성이 필요한 구성체, @RestController, @Advice - 예외처리 -> Servlet-context.xml에 선언(URL 관련)
//그 외 어노테이션 - root-context.xml에 선언 (URL 미관련)
@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	@Autowired
	private BoardServiceImpl service;
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		log.info("게시판 리스트........................");
//		System.out.println(10/0);
		model.addAttribute("list", service.list());
		return "board/list";
	}
	
	@RequestMapping("/view.do")
	public String view(long no, int inc) {
		log.info("게시판 글보기........................");
		log.info("no=" + no + "inc=" + inc);
		return "board/view";
	}
	
	@GetMapping("/write.do")
	public String writeForm() {
		log.info("게시판 글쓰기 폼........................");
		return "board/write";
	}
	
	@PostMapping("/write.do")
	public String write(BoardVO vo) {
		log.info("게시판 글쓰기 처리........................");
		log.info(vo);
		return "redirect:list.do";
	}
	
	@GetMapping("/update.do")
	public String UpdateForm() {
		log.info("게시판 수정 폼........................");
		return "board/update";
	}
	
	@PostMapping("/update.do")
	public String update() {
		log.info("게시판 글수정 처리........................");
		return "redirect:view.do?no=10&inc=1";
	}
	
	@PostMapping("/delete.do")
	// @RequestParam([name, defaultValue, required, value]) - 넘어오는 데이터의 이름이 변수와 다른 경우, 값이 넘어오지 않는 경우 기본값, 필수 항목
	// 여러개 데이터를 받을 때 리스트로 받으면 클래스를 사용해야 한다.
	public String delete(@RequestParam("no") ArrayList<Long> no) {
//	public String delete(long[] no) {
		log.info("게시판 글삭제 처리........................");
//		log.info(Arrays.toString(no));
		log.info(no);
		return "redirect:list.do";
	}
	
}
