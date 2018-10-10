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

	public Member(String memberName, int eventPlanning, int cognitation, int coordination, int programmingKnowledge,
			int infrastructureKnowledge) {
		super();
		this.memberName = memberName;
		this.eventPlanning = eventPlanning;
		this.cognitation = cognitation;
		this.coordination = coordination;
		this.programmingKnowledge = programmingKnowledge;
		this.infrastructureKnowledge = infrastructureKnowledge;
	}

	/**
	 * 適正判断の計算をするメソットです。
	 */
	public boolean isEnlistedPropriety() {
		//イベント企画力が1以下である場合は結果レスポンスの入隊可否をfalseとします。
		if (eventPlanning <= 1) {
			return false;
		}
		//調整力が1点以下である場合は結果レスポンスの入隊可否をfalseとします。
		if (coordination <= 1) {
			return false;
		}
		//イベント企画力以外が全て0点である場合は結果レスポンスの入隊可否をfalseとします。
		if ((cognitation + coordination + programmingKnowledge + infrastructureKnowledge) == 0) {
			return false;
		}
		//合計が10点以下である場合は結果レスポンスの入隊可否をfalseとします。
		if ((eventPlanning + cognitation + coordination + programmingKnowledge + infrastructureKnowledge) <= 10) {
			return false;
		}	
		//その他は全て入隊可否をtrueとします。
		return true;
	}

	/**
	 * 隊員の処理の前提チェックするメソットです。
	 * 0以下あるいは5以上の属性がある隊員の場合はこのメソットがtrueを返却します。
	 */
	public boolean isInvalid() {
		if((eventPlanning < 0) || (eventPlanning >5)) return true;
		if((coordination < 0) || (coordination >5)) return true;
		if((cognitation < 0) || (cognitation >5)) return true;
		if((programmingKnowledge < 0) || (programmingKnowledge >5)) return true;
		if((infrastructureKnowledge < 0) || (infrastructureKnowledge >5)) return true;
		return false;
	}
}
