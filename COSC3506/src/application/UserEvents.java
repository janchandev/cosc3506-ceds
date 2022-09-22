package application;
//Added in part 2
public class UserEvents {
	private String eventName;
	private String clubName;
	private String description;
	private String dateTime;
	private int eventId;
	
	public UserEvents(String eventName, String clubName, String description, String dateTime, int eventId) {
		this.eventName = eventName;
		this.clubName = clubName;
		this.description = description;
		this.dateTime = dateTime;
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	
	
	
}
