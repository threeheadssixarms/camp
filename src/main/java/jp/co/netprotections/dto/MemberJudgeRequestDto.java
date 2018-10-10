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
	
	public MemberJudgeRequestDto() {}
	
	public MemberJudgeRequestDto (ArrayList<Member> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
    }
	
	/**
	 * 隊員候補リストの処理の前提チェックするメソットです。
	 * 0-5以外の属性がある隊員のあるリストおよび空リストの場合はこのメソットを trueを返却します。
	 */
	public boolean isInvalid() {
		//空リストの場合
		if (memberCandidatesList.isEmpty()) return true;

		//各隊員のチェック
		for (int i = 0; i<memberCandidatesList.size(); i++) {
			if (memberCandidatesList.get(i).isInvalid()) return true;
		}
		return false;
	}

}