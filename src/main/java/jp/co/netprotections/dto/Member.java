package jp.co.netprotections.dto;

public class Member {
	private String memberName;
	private int eventPlanning;
	private int cognitation;
	private int coordination;
	private int programmingKnowledge;
	private int infrastructureKnowledge;
	
	public Member() {
		
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public boolean isEnlistedPropriety() {
		if (eventPlanning <= 1) {
			return false;
		}
		if (coordination <= 1) {
			return false;
		}
		if ((cognitation + coordination + programmingKnowledge + infrastructureKnowledge) == 0) {
			return false;
		}
		if ((eventPlanning + cognitation + coordination + programmingKnowledge + infrastructureKnowledge) <= 10) {
			return false;
		}	
		return true;
	}

	public boolean isInvalid() {
		if((eventPlanning < 0) || (eventPlanning >5)) return true;
		if((coordination < 0) || (coordination >5)) return true;
		if((cognitation < 0) || (cognitation >5)) return true;
		if((programmingKnowledge < 0) || (programmingKnowledge >5)) return true;
		if((infrastructureKnowledge < 0) || (infrastructureKnowledge >5)) return true;
		return false;
	}

	public int getEventPlanning() {
		return eventPlanning;
	}

	public void setEventPlanning(int eventPlanning) {
		this.eventPlanning = eventPlanning;
	}

	public int getCognitation() {
		return cognitation;
	}

	public void setCognitation(int cognitation) {
		this.cognitation = cognitation;
	}

	public int getCoordination() {
		return coordination;
	}

	public void setCoordination(int coordination) {
		this.coordination = coordination;
	}

	public int getProgrammingKnowledge() {
		return programmingKnowledge;
	}

	public void setProgrammingKnowledge(int programmingKnowledge) {
		this.programmingKnowledge = programmingKnowledge;
	}

	public int getInfrastructureKnowledge() {
		return infrastructureKnowledge;
	}

	public void setInfrastructureKnowledge(int infrastructureKnowledge) {
		this.infrastructureKnowledge = infrastructureKnowledge;
	}
}
