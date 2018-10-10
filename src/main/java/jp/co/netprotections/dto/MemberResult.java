package jp.co.netprotections.dto;

public class MemberResult {
	private String memberName; //隊員氏名
	private boolean enlistedPropriety; //入隊可否
	
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
}
