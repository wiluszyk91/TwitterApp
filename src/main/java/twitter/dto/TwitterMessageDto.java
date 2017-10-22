package twitter.dto;

import java.util.Date;

public class TwitterMessageDto {

	private long id;
    private String message;
    private Date dateOfCreation;
    private String userName;
	
    private boolean favouriteTweet;
    
	public boolean isFavouriteTweet() {
		return favouriteTweet;
	}

	public void setFavouriteTweet(boolean favouriteTweet) {
		this.favouriteTweet = favouriteTweet;
	}

	public TwitterMessageDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	

}
