package jp.co.netprotections.service;

import jp.co.netprotections.dto.Member;
import jp.co.netprotections.dto.MemberJudgeRequestDto;

public interface MemberJudgeService {
	static boolean checkInvalidRequest(MemberJudgeRequestDto request) {
		return false;
	};

	static boolean checkMemberEnlistedPropriety(Member member) {
		return true;
	};

	static boolean checkInvalidMember(Member member) {
		return true;
	};
}