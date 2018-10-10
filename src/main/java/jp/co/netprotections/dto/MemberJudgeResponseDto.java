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

	/**
	 * リクエストdtoの情報からリスポンスdtoを作るメソットです。
	 * @param MemberJudgeRequestDto request
	 * @return　MemberJudgeResponseDto response
	 */
	public static MemberJudgeResponseDto generateResponseFrom(MemberJudgeRequestDto request) {
		ArrayList<Member> memberList = request.getMemberCandidatesList();
		MemberJudgeResponseDto response = new MemberJudgeResponseDto();
		
		// from each member in the requested list, create an instance of MemberResult (including memberName
		// and calculated enlistedPropriety) and add it to the response dto.
		for (int i=0; i< memberList.size(); i++) {
			Member member = memberList.get(i);
			response.judgedCandidatesResultList.add(new MemberResult(member.getMemberName(), member.isEnlistedPropriety()));
		}
		return response;
	}
}
