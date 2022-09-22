package application;
//Added in part 2
public class Attendees {
	private String eventName;
	private int studentId;
	private String memberName;
	private String contactEmail;
	private int attendeeId;
	
	public Attendees(String eventName, int studentId, String memberName, String contactEmail, int attendeeId) {
		this.eventName = eventName;
		this.studentId = studentId;
		this.memberName = memberName;
		this.contactEmail = contactEmail;
		this.attendeeId = attendeeId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	public int getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(int attendeeId) {
		this.attendeeId = attendeeId;
	}
	
	
	
	

}
