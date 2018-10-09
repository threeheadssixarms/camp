package jp.co.netprotections.dto;

public class MemberResult {
	private String memberName;
	private boolean enlistedPropriety;
	
	public MemberResult(String memberName, boolean enlistedPropriety) {
		super();
		this.memberName = memberName;
		this.enlistedPropriety = enlistedPropriety;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public boolean isEnlistedPropriety() {
		return enlistedPropriety;
	}
	public void setEnlistedPropriety(boolean enlistedPropriety) {
		this.enlistedPropriety = enlistedPropriety;
	}
//	public void checkPropriety() {
//	if (eventPlanning <= 1) {
//		enlistedPropriety = false;
//		return;
//	}
//	if (coordination <= 1) {
//		enlistedPropriety = false;
//		return;
//	}
//	if ((cognitation + coordination + programmingKnowledge + infrastructureKnowledge) == 0) {
//		enlistedPropriety = false;
//		return;
//	}
//	if ((eventPlanning + cognitation + coordination + programmingKnowledge + infrastructureKnowledge) <= 10) {
//		enlistedPropriety = false;
//		return;
//	}	
//	enlistedPropriety=true;
//}

}
