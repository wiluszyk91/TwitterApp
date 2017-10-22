package twitter.enums;

public enum TwitterMessages {

	TWITT_ADDED("New Twitt was added");
	
	private String value;
	
	public String getValue() {
		return value;
	}

	private TwitterMessages(String value) {
		this.value = value;
	}
}
