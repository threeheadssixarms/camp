package jp.co.netprotections.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


/**
 * @author p.le
 *コントローラーテストのクラスです。
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MemberJudgeController.class)
public class MemberJudgeControllerTest {
	@Autowired
	MockMvc mvc;

	@Test
	public void receiveRequest() throws Exception {
		String request = "{																												\n" + 
				"			\"memberCandidatesList\" : [																											\n" + 
				"				{																										\n" + 
				"					\"memberName\" : \"snozaki\",																									\n" + 
				"					\"eventPlanning\" : \"3\",																									\n" + 
				"					\"cogitation\" : \"3\",																									\n" + 
				"					\"coordination\" : \"5\",																									\n" + 
				"					\"programmingKnowledge\" : \"2\",																									\n" + 
				"					\"infrastructureKnowledge\" : \"2\"																									\n" + 
				"				},																										\n" + 
				"				{																										\n" + 
				"					\"memberName\" : \"vle\",																									\n" + 
				"					\"eventPlanning\" : \"3\",																									\n" + 
				"					\"cogitation\" : \"3\",																									\n" + 
				"					\"coordination\" : \"5\",																									\n" + 
				"					\"programmingKnowledge\" : \"4\",																									\n" + 
				"					\"infrastructureKnowledge\" : \"5\"																									\n" + 
				"				},\n" + 
				"				{\n" + 
				"					\"memberName\" : \"thao\",																									\n" + 
				"					\"eventPlanning\" : \"0\",																									\n" + 
				"					\"cogitation\" : \"5\",																									\n" + 
				"					\"coordination\" : \"5\",																									\n" + 
				"					\"programmingKnowledge\" : \"5\",																									\n" + 
				"					\"infrastructureKnowledge\" : \"0\"																									\n" + 
				"				}]																								\n" + 
				"		}	";
		
		this.mvc.perform(MockMvcRequestBuilders.post("/camp")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(request)
			)
			.andExpect(status().isOk())                   
			.andReturn();
	}
}
