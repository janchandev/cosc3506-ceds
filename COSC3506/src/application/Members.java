package application;
//Added in part 2
public class Members {
	private String clubName;
	private int studentId;
	private String memberName;
	private String contactEmail;
	private int memberId;
	
	public Members(String clubName, int studentId, String memberName, String contactEmail, int memberId) {
		this.clubName = clubName;
		this.studentId = studentId;
		this.memberName = memberName;
		this.contactEmail = contactEmail;
		this.memberId = memberId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	
	
	

}
