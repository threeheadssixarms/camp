package jp.co.netprotections.dto;

import lombok.Getter;
import lombok.Setter;

public class MemberResult {
	@Getter @Setter
	private String memberName; //隊員氏名
	@Getter @Setter
	private boolean enlistedPropriety; //入隊可否
	
	public MemberResult(String memberName, boolean enlistedPropriety) {
		super();
		this.memberName = memberName;
		this.enlistedPropriety = enlistedPropriety;
	}
}
