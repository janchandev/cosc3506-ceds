package application;
//Added in part 2
public class UserClubs {
	private String clubName;
	private String clubDescription;
	private String clubEmail;
	private int tableId;
	
	public UserClubs(String clubName, String clubDescription, String clubEmail, int tableId) {
		this.clubName = clubName;
		this.clubDescription = clubDescription;
		this.clubEmail = clubEmail;
		this.tableId = tableId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubDescription() {
		return clubDescription;
	}

	public void setClubDescription(String clubDescription) {
		this.clubDescription = clubDescription;
	}

	public String getClubEmail() {
		return clubEmail;
	}

	public void setClubEmail(String clubEmail) {
		this.clubEmail = clubEmail;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
	
	
	


	

}
