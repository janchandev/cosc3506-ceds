package application;

public class Clubs {
	private String clubName;
	private String clubDescription;
	private String clubEmail;
	private double clubPrice;
	private int numMembers;
	private double clubFunds;
	private int clubId;
	
	public Clubs(String clubName, String clubDescription, String clubEmail, double clubPrice, int numMembers,
			double clubFunds, int clubId) {
		this.clubName = clubName;
		this.clubDescription = clubDescription;
		this.clubEmail = clubEmail;
		this.clubPrice = clubPrice;
		this.numMembers = numMembers;
		this.clubFunds = clubFunds;
		this.clubId = clubId;
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
	public double getClubPrice() {
		return clubPrice;
	}
	public void setClubPrice(double clubPrice) {
		this.clubPrice = clubPrice;
	}
	public int getNumMembers() {
		return numMembers;
	}
	public void setNumMembers(int numMembers) {
		this.numMembers = numMembers;
	}
	public double getClubFunds() {
		return clubFunds;
	}
	public void setClubFunds(double clubFunds) {
		this.clubFunds = clubFunds;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	
	
	
	
	

}
