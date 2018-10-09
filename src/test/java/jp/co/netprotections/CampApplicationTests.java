package jp.co.netprotections;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.netprotections.dto.Member;
import jp.co.netprotections.dto.MemberJudgeRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CampApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void eventPlanningLessThanOrEqualTo1() {
		Member member = new Member("thao", 1, 2, 3, 4, 5);
		assertFalse(member.isEnlistedPropriety());
	}
	
	@Test
	public void coordinationLessThanOrEqualTo1() {
		Member member = new Member("thao", 2, 2, 1, 4, 5);
		assertFalse(member.isEnlistedPropriety());
	}
	
	@Test
	public void allCriteriaExceptEventPlanningEqualZero() {
		Member member = new Member("thao", 5, 0, 0, 0, 0);
		assertFalse(member.isEnlistedPropriety());
	}
	
	@Test
	public void someCriteriaEqualZeroButTotalLargerThan10() {
		Member member = new Member("thao", 5, 0, 2, 5, 2);
		assertTrue(member.isEnlistedPropriety());
	}
	
	@Test
	public void totalLessThanOrEqualTo10() {
		Member member = new Member("thao", 2, 2, 2, 1, 2);
		assertFalse(member.isEnlistedPropriety());
	}
	
	@Test
	public void properMember() {
		Member member = new Member("thao", 2, 2, 3, 4, 5);
		assertTrue(member.isEnlistedPropriety());
	}
	
	
	@Test
	public void requestWithAnAttributeOutOfRange() {
		MemberJudgeRequestDto request = new MemberJudgeRequestDto ();
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("thao", 1, 2, 3, 4, 5));
		memberList.add(new Member("thao2", 1, 2, 3, 4, 8));
		request.setmemberCandidatesList(memberList);
		assertTrue(request.isInvalid());
	}
	
	@Test
	public void validRequest() {
		MemberJudgeRequestDto request = new MemberJudgeRequestDto ();
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("thao", 1, 2, 3, 4, 5));
		memberList.add(new Member("thao2", 1, 2, 3, 4, 3));
		request.setmemberCandidatesList(memberList);
		assertFalse(request.isInvalid());
	}
	
	@Test
	public void emptyRequest() {
		MemberJudgeRequestDto request = new MemberJudgeRequestDto ();
		ArrayList<Member> memberList = new ArrayList<Member>();
		request.setmemberCandidatesList(memberList);
		assertTrue(request.isInvalid());
	}


}
