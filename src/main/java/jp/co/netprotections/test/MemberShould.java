package jp.co.netprotections.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.netprotections.dto.Member;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author p.le
 * 入隊可否計算テストのクラスです。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberShould {
	/**
	 * 1点以下のイベント企画力の場合は入隊可否をfalseとすらかどうかチェックするメソットです。
	 */
	@Test
	public void beRejectedIfEventPlanningLessThanOrEqualTo1() {
		Member member = new Member("thao", 1, 2, 3, 4, 5);
		assertFalse(member.isEnlistedPropriety());
	}
	
	/**
	 * 1点以下の調整力の場合は入隊可否をfalseとすらかどうかチェックするメソットです。
	 */
	@Test
	public void beRejectedIfCoordinationLessThanOrEqualTo1() {
		Member member = new Member("thao", 2, 2, 1, 4, 5);
		assertFalse(member.isEnlistedPropriety());
	}
	
	/**
	 * イベント企画力以外が全て0点である場合は入隊可否をfalseとするかどうかチェックするメソットです。
	 */
	@Test
	public void beRejectedIfCriteriaOtherThanEventPlanningAreAllZero() {
		Member member = new Member("thao", 5, 0, 0, 0, 0);
		assertFalse(member.isEnlistedPropriety());
	}
	
	/**
	 * 合計が10点以上である場合は入隊可否をtrueとするかどうかチェックするメソットです。
	 */
	@Test
	public void beAcceptedIfTheTotalIsMoreThan10() {
		Member member = new Member("thao", 5, 0, 2, 5, 2);
		assertTrue(member.isEnlistedPropriety());
	}
	
	/**
	 * 合計が10点以下である場合は入隊可否をfalseとするかどうかチェックするメソットです。
	 */
	@Test
	public void beRejectedIfTheTotalIsLessThanOrEqualTo10() {
		Member member = new Member("thao", 2, 2, 2, 1, 2);
		assertFalse(member.isEnlistedPropriety());
	}
	
	/**
	 * 全ての要求にこたえる場合は入隊可否をtrueとするかどうかチェックするメソットです。
	 */
	@Test
	public void beAcceptedIfMeetAllRequirements() {
		Member member = new Member("thao", 2, 2, 3, 4, 5);
		assertTrue(member.isEnlistedPropriety());
	}

}
