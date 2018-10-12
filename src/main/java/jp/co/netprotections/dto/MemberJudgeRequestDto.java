package jp.co.netprotections.dto;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * @author p.le
 * リクエストdtoのクラスです。
 */
public class MemberJudgeRequestDto {
	@Getter @Setter
	private ArrayList<Member> memberCandidatesList; //隊員候補リスト
	
	public MemberJudgeRequestDto () {}
	
	public MemberJudgeRequestDto (ArrayList<Member> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
    }
}