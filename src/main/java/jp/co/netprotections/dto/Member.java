package jp.co.netprotections.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author p.le
 * 隊員のクラスです。
 */
public class Member {
	@Getter @Setter
	private String memberName; //隊員氏名
	@Getter @Setter
	private int eventPlanning; //イベント企画力
	@Getter @Setter
	private int cognitation; //思考力
	@Getter @Setter
	private int coordination; //調整力
	@Getter @Setter
	private int programmingKnowledge; //ログラム製造力
	@Getter @Setter
	private int infrastructureKnowledge; //基盤理解
	
	public Member() {} 

	public Member(String memberName, int eventPlanning, int cognitation, int coordination, int programmingKnowledge,
			int infrastructureKnowledge) {
		this.memberName = memberName;
		this.eventPlanning = eventPlanning;
		this.cognitation = cognitation;
		this.coordination = coordination;
		this.programmingKnowledge = programmingKnowledge;
		this.infrastructureKnowledge = infrastructureKnowledge;
	}
}
