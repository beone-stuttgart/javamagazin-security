package javamag.model;

public class Profile {
	private String login;
	String name;
	String description;
	
	public Profile(String login, String name, String description) {
		this.login = login;
		this.name = name;
		this.description = description;
	}
	
	public String getLogin() {
		return login;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
