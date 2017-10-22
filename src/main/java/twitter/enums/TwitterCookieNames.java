package twitter.enums;

public enum TwitterCookieNames {
	
	FAVOURITE_TWITTS("twitts_id");
	
	private String value; 
	
	public String getValue() {
		return value;
	}

	private TwitterCookieNames(String value) {
		this.value = value;
	}
	
	
}
