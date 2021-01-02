package jp.ac.shibaura.it.ie.domain.model.user;

public class UserSession {
	private UserId id;
	private UserName name;
	private String session;

	public UserSession(UserId id, UserName name, String session) {
		this.id = id;
		this.name = name;
		this.session = session;
	}

	public UserId getId() { return id; }
	public UserName getName() { return name; }
	public String getSession() { return session; }

}
