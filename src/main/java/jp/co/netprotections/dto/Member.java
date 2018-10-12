package jp.co.netprotections.dto;

import lombok.Data;

/**
 * @author p.le
 * 隊員のクラスです。
 */
@Data public class Member {
	private String memberName; //隊員氏名
	private int eventPlanning; //イベント企画力
	private int cognitation; //思考力
	private int coordination; //調整力
	private int programmingKnowledge; //ログラム製造力
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
