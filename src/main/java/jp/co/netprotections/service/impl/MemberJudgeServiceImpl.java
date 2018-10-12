package jp.co.netprotections.service.impl;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.Member;
import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.dto.MemberResult;
import jp.co.netprotections.service.MemberJudgeService;

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService{
	/**
	 * リクエストdtoの情報からリスポンスdtoを作るメソットです。
	 * @param MemberJudgeRequestDto request
	 * @return　MemberJudgeResponseDto response
	 */
	public static MemberJudgeResponseDto generateResponseFrom(MemberJudgeRequestDto request) {
		ArrayList<Member> memberList = request.getMemberCandidatesList();
		ArrayList<MemberResult> responseMemberList = new ArrayList<MemberResult>();
		
		// from each member in the requested list, create an instance of MemberResult (including memberName
		// and calculated enlistedPropriety) and add it to the response dto.
		for (int i=0; i< memberList.size(); i++) {
			Member member = memberList.get(i);
			responseMemberList.add(new MemberResult(member.getMemberName(), checkMemberEnlistedPropriety(member)));
		}
		return (new MemberJudgeResponseDto(responseMemberList));
	}
	/**
	 * 隊員候補リストの処理の前提チェックするメソットです。
	 * 0-5以外の属性がある隊員のあるリストおよび空リストの場合はこのメソットを trueを返却します。
	 */
	public static boolean checkInvalidRequest(MemberJudgeRequestDto request) {
		ArrayList<Member> memberCandidatesList = request.getMemberCandidatesList();
		//空リストの場合
		if (memberCandidatesList.isEmpty()) return true;

		//各隊員のチェック
		for (int i = 0; i<memberCandidatesList.size(); i++) {
			if (checkInvalidMember(memberCandidatesList.get(i))) return true;
		}
		return false;
	}
	
	/**
	 * 適正判断の計算をするメソットです。
	 */
	public static boolean checkMemberEnlistedPropriety(Member member) {
		boolean condition = (member.getEventPlanning() > 1)//イベント企画力が1以下である場合は結果レスポンスの入隊可否をfalseとします。
							&& (member.getCoordination() > 1)//調整力が1点以下である場合は結果レスポンスの入隊可否をfalseとします。
							//イベント企画力以外が全て0点である場合は結果レスポンスの入隊可否をfalseとします。
							&& ((member.getCognitation() + member.getCoordination() + member.getProgrammingKnowledge() + member.getInfrastructureKnowledge()) != 0)
							//合計が10点以下である場合は結果レスポンスの入隊可否をfalseとします。
							&& ((member.getEventPlanning() + member.getCognitation() + member.getCoordination() + member.getProgrammingKnowledge() + member.getInfrastructureKnowledge()) > 10);
		//その他は全て入隊可否をtrueとします。
		return condition;
	}
	
	/**
	 * 隊員の処理の前提チェックするメソットです。
	 * 0以下あるいは5以上の属性がある隊員の場合はこのメソットがtrueを返却します。
	 */
	public static boolean checkInvalidMember(Member member) {
		if (Stream.of(member.getEventPlanning(), member.getCoordination(), member.getCognitation(),member.getProgrammingKnowledge(),member.getInfrastructureKnowledge())
				.allMatch(x -> (x >= 0 && x <= 5 ))) {
		    return false;
		}
		return true;
	}
}
