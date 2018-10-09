package jp.co.netprotections.dto;

import java.util.ArrayList;

public class MemberJudgeRequestDto {
	
	private ArrayList<Member> memberCandidatesList;
	public MemberJudgeRequestDto () {

    }
	
	public MemberJudgeRequestDto (ArrayList<Member> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
    }
	
	public ArrayList<Member> getmemberCandidatesList() {
		return memberCandidatesList;
	}
	public void setmemberCandidatesList(ArrayList<Member> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
	}
	
	public boolean isInvalid() {
		if (memberCandidatesList.isEmpty()) return true;
		for (int i = 0; i<memberCandidatesList.size(); i++) {
			if (memberCandidatesList.get(i).isInvalid()) return true;
		}
		return false;
	}

}