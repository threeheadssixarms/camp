package jp.co.netprotections.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.netprotections.service.MemberJudgeService;

/**
 * @author p.le
 *コントローラーテストのクラスです。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberJudgeControllerTest {
	private MockMvc mockMvc;
	
	@Mock
	MemberJudgeService memberJudgeService;
	
	@InjectMocks
	MemberJudgeController memberJudgeController;

	@Before
	    public void init(){
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	        	.standaloneSetup(memberJudgeController)
	            .build();
	}

	/**
	 * コントローラーのリクエストの受取と処理可能のテストです。
	 * @throws Exception
	 */
	@Test
	public void processNormalRequest() throws Exception {
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
		
		mockMvc.perform(post("/camp")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(request)
			)
			.andExpect(status().isOk())                   
			.andReturn();
	}
	
	/**
	 * 空のリクエストリストの処理可能のテストです。
	 * @throws Exception
	 */
	@Test
	public void processEmptyListRequest() throws Exception {
		//空のリクエストリスト
		String request = "	{																												\n" + 
				"			\"memberCandidatesList\" : []																								\n" + 
				"		}	";
		
		mockMvc.perform(post("/camp")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(request)
				)
				.andExpect(status().isOk())                   
				.andReturn();
	}
	
	/**
	 * リクエストを受け取って、希望なリスポンスを返却する可能のテストです。
	 * @throws Exception
	 */
	@Test
	public void returnCorrectResponse() throws Exception {
		//クライエントが送るリクエスト
		String request = "{																												\n" + 
				"			\"memberCandidatesList\" : [																											\n" + 
				"				{																										\n" + 
				"					\"memberName\" : \"snozaki\",																									\n" + 
				"					\"eventPlanning\" : \"2\",																									\n" + 
				"					\"cogitation\" : \"3\",																									\n" + 
				"					\"coodination\" : \"2\",																									\n" + 
				"					\"programmingKnowledge\" : \"2\",																									\n" + 
				"					\"infrastructureKnowledge\" : \"2\"																									\n" + 
				"				},																										\n" + 
				"				{																										\n" + 
				"					\"memberName\" : \"vle\",																									\n" + 
				"					\"eventPlanning\" : \"3\",																									\n" + 
				"					\"cogitation\" : \"3\",																									\n" + 
				"					\"coodination\" : \"3\",																									\n" + 
				"					\"programmingKnowledge\" : \"4\",																									\n" + 
				"					\"infrastructureKnowledge\" : \"5\"																									\n" + 
				"				}		]																								\n" + 
				"		}";
		// 正しいリスポンス
		String response = "{\n" + 
				"    \"judgedCandidatesResultList\": [\n" + 
				"        {\n" + 
				"            \"memberName\": \"snozaki\",\n" + 
				"            \"enlistedPropriety\": false\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"memberName\": \"vle\",\n" + 
				"            \"enlistedPropriety\": false\n" + 
				"        }\n" + 
				"    ]\n" + 
				"}";
		
		mockMvc.perform(post("/camp")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(request)
				)
				.andExpect(status().isOk())
				.andExpect(content().json(response))
				.andReturn();
	}
}
