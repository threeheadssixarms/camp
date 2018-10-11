package jp.co.netprotections.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.netprotections.dto.Member;
import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.service.impl.MemberJudgeServiceImpl;

import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author p.le
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberJudgeServiceImplTest {
	/**
	 * 1点以下のイベント企画力の場合は入隊可否をfalseとすらかどうかチェックするメソットです。
	 */
	@Test
	public void beRejectedIfEventPlanningLessThanOrEqualTo1() {
		Member member = new Member("thao", 1, 2, 3, 4, 5);
		assertFalse(MemberJudgeServiceImpl.checkInvalidMember(member));
	}
	
	/**
	 * 1点以下の調整力の場合は入隊可否をfalseとすらかどうかチェックするメソットです。
	 */
	@Test
	public void beRejectedIfCoordinationLessThanOrEqualTo1() {
		Member member = new Member("thao", 2, 2, 1, 4, 5);
		assertFalse(MemberJudgeServiceImpl.checkMemberEnlistedPropriety(member));
	}
	
	/**
	 * イベント企画力以外が全て0点である場合は入隊可否をfalseとするかどうかチェックするメソットです。
	 */
	@Test
	public void beRejectedIfCriteriaOtherThanEventPlanningAreAllZero() {
		Member member = new Member("thao", 5, 0, 0, 0, 0);
		assertFalse(MemberJudgeServiceImpl.checkMemberEnlistedPropriety(member));
	}
	
	/**
	 * 合計が10点以上である場合は入隊可否をtrueとするかどうかチェックするメソットです。
	 */
	@Test
	public void beAcceptedIfTheTotalIsMoreThan10() {
		Member member = new Member("thao", 5, 0, 2, 5, 2);
		assertTrue(MemberJudgeServiceImpl.checkMemberEnlistedPropriety(member));
	}
	
	/**
	 * 合計が10点以下である場合は入隊可否をfalseとするかどうかチェックするメソットです。
	 */
	@Test
	public void beRejectedIfTheTotalIsLessThanOrEqualTo10() {
		Member member = new Member("thao", 2, 2, 2, 1, 2);
		assertFalse(MemberJudgeServiceImpl.checkMemberEnlistedPropriety(member));
	}
	
	/**
	 * 全ての要求にこたえる場合は入隊可否をtrueとするかどうかチェックするメソットです。
	 */
	@Test
	public void beAcceptedIfMeetAllRequirements() {
		Member member = new Member("thao", 2, 2, 3, 4, 5);
		assertTrue(MemberJudgeServiceImpl.checkMemberEnlistedPropriety(member));
	}
	
	/**
	 * 属性が既定の数値以上の場合はリクエストが不正とされるかチェックするテストです。
	 */
	@Test
	public void beRejectedIfAnAttributeIsOutOfRange() {
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("thao", 1, 2, 3, 4, 5));
		memberList.add(new Member("thao2", 1, 2, 3, 4, 8));
		MemberJudgeRequestDto request = new MemberJudgeRequestDto(memberList);
		assertTrue(MemberJudgeServiceImpl.checkInvalidRequest(request));
	}
	
	/**
	 * すべての属性が０−５以内の場合はリクエストが正当とされるかチェックするテストです。
	 */
	@Test
	public void beAcceptedIfAllAttributesAreInRange() {
		ArrayList<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("thao", 1, 2, 3, 4, 5));
		memberList.add(new Member("thao2", 1, 2, 3, 4, 3));
		MemberJudgeRequestDto request = new MemberJudgeRequestDto(memberList);
		assertFalse(MemberJudgeServiceImpl.checkInvalidRequest(request));
	}
	
	/**
	 * 空リクエストリストが不正とされるかチェックするテストです。
	 */
	@Test
	public void beRejectedIfEmpty() {
		MemberJudgeRequestDto request = new MemberJudgeRequestDto(new ArrayList<Member>());
		assertTrue(MemberJudgeServiceImpl.checkInvalidRequest(request));
	}
}
