package org.zerock.exception;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

//자동 생성 어노테이션 - @Controller - 컨트롤러, @Service - 서비스, @Repository - 저장소(DAO), 
//@Component - 이외의 자동생성이 필요한 구성체, @RestController, @Advice - 예외처리 -> Servlet-context.xml에 선언(URL 관련)
//그 외 어노테이션 - root-context.xml에 선언 (URL 미관련)
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	// 500 번 예외 전체 - Exception
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, Model model) {
		
		log.error("Exception ....");
		model.addAttribute("exception", e);
		log.error(model);
		
		return "error/error_page";
	}
	
	// 404번 오류 처리
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException e) {
		
		log.error("404 Error");
		
		return "error/custom404";
	}
	
}
