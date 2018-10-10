package jp.co.netprotections.controller;


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

/**
 * @author p.le
 * リクエストを処理するControllerクラスです.
 */
@Controller
public class MemberJudgeController {
	/**
	 * Controllerの実行メソッドです.
	 * @param MemberJudgeRequestDto request
	 * @return MemberJudgeResponseDto response
	 */
	@ResponseBody
	@RequestMapping(value="/camp", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces =  org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public MemberJudgeResponseDto camp(@RequestBody MemberJudgeRequestDto request) {
		if (request.isInvalid()) return null;
		return MemberJudgeResponseDto.generateResponseFrom(request);
	}
	
	/**
	 * A method to handle requests that cannot be parsed correctly
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void handleException() {  
    }
}

