package jp.co.netprotections.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.netprotections.dto.Member;
import jp.co.netprotections.dto.MemberJudgeRequestDto;

/**
 * @author p.le
 *　リクエスト処理の前提チェックのクラスです。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestShould {
	/**
	 * 属性が既定の数値以上の場合はリクエストが不正とされるかチェックするテストです。
	 */
	@Test
	public void beRejectedIfAnAttributeIsOutOfRange() {
		MemberJudgeRequestDto request = new MemberJudgeRequestDto ();
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("thao", 1, 2, 3, 4, 5));
		memberList.add(new Member("thao2", 1, 2, 3, 4, 8));
		request.setMemberCandidatesList(memberList);
		assertTrue(request.isInvalid());
	}
	
	/**
	 * すべての属性が０−５以内の場合はリクエストが正当とされるかチェックするテストです。
	 */
	@Test
	public void beAcceptedIfAllAttributesAreInRange() {
		MemberJudgeRequestDto request = new MemberJudgeRequestDto ();
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("thao", 1, 2, 3, 4, 5));
		memberList.add(new Member("thao2", 1, 2, 3, 4, 3));
		request.setMemberCandidatesList(memberList);
		assertFalse(request.isInvalid());
	}
	
	/**
	 * 空リクエストリストが不正とされるかチェックするテストです。
	 */
	@Test
	public void beRejectedIfEmpty() {
		MemberJudgeRequestDto request = new MemberJudgeRequestDto ();
		ArrayList<Member> memberList = new ArrayList<Member>();
		request.setMemberCandidatesList(memberList);
		assertTrue(request.isInvalid());
	}
}
