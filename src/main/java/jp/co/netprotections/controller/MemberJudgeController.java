package jp.co.netprotections.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.service.MemberJudgeService;
import jp.co.netprotections.service.impl.MemberJudgeServiceImpl;

/**
 * @author p.le
 * リクエストを処理するControllerクラスです.
 */
@Controller
public class MemberJudgeController {
	
//	@Autowired
//	MemberJudgeService memberJudgeService;
		
	/**
	 * Controllerの実行メソッドです.
	 * @param MemberJudgeRequestDto request
	 * @return MemberJudgeResponseDto response
	 */
	@ResponseBody
	@RequestMapping(value="/camp", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces =  org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public MemberJudgeResponseDto camp(@RequestBody MemberJudgeRequestDto request) {
		if (MemberJudgeServiceImpl.checkInvalidRequest(request)) return null;
		return MemberJudgeServiceImpl.generateResponseFrom(request);
	}
	
	/**
	 * A method to handle requests that cannot be parsed correctly
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void handleException() {  
    }
}

