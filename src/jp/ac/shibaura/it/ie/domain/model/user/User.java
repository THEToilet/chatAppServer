package jp.ac.shibaura.it.ie.domain.model.user;

public class User {
	private UserId id;
	private UserName name;
	private UserPassword pass;

	public User(UserId id, UserName name, UserPassword pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public UserId getId() { return id; }
	public UserName getName() { return name; }
	public UserPassword getPass() { return pass; }

	public void changeName(UserName name) {
		this.name = name;
	}

}
