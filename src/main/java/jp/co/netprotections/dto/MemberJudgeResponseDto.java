package jp.co.netprotections.dto;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * @author p.le
 *リスポンスdtoのクラスです.
 */
public class MemberJudgeResponseDto {
	@Getter @Setter
	private ArrayList<MemberResult> judgedCandidatesResultList = new ArrayList<MemberResult>(); //隊員候補判定結果リスト

	public MemberJudgeResponseDto(ArrayList<MemberResult> judgedCandidatesResultList) {
		super();
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	} 
}
