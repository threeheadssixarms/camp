package jp.co.netprotections.dto;

import java.util.ArrayList;

public class MemberJudgeResponseDto {
	private ArrayList<MemberResult> judgedCandidatesResultList = new ArrayList<MemberResult>();

	public ArrayList<MemberResult> getJudgedCandidatesResultList() {
		return judgedCandidatesResultList;
	}

	public void setJudgedCandidatesResultList(ArrayList<MemberResult> judgedCandidatesResultList) {
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	}
	
	public static MemberJudgeResponseDto generateResponseFrom(MemberJudgeRequestDto request) {
		ArrayList<Member> memberList = request.getmemberCandidatesList();
		MemberJudgeResponseDto response = new MemberJudgeResponseDto();
		for (int i=0; i< memberList.size(); i++) {
			Member member = memberList.get(i);
			response.judgedCandidatesResultList.add(new MemberResult(member.getMemberName(), member.isEnlistedPropriety()));
		}	
		return response;
	}
}
