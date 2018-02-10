package by.epam.hotel.entity;

/**
 * The Class User.
 */
public class User extends Entity {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 5824250458152789792L;


	/** The login. */
	private String login;

	/** The password. */
	private int password;

	/** The email. */
	private String email;

	/** The name. */
	private String name;

	/** The first name. */
	private String firstName;

	/** The surname. */
	private String surname;

	/** The age. */
	private int age;

	/** The access. */
	private AccessLevel access;

	/**
	 * Instantiates a new user.
	 */
	public User() {

	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	@Override
	public int getId() {
		return super.getId();
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	@Override
	public void setId(int id) {
		super.setId(id);
	}


	/**
	 * Gets the login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public int getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param i
	 *            the new password
	 */
	public void setPassword(int i) {
		this.password = i;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 * 
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 * 
	 * @param surname
	 *            the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the age.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 * 
	 * @param age
	 *            the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the access.
	 * 
	 * @return the access
	 */
	public AccessLevel getAccess() {
		return access;
	}

	/**
	 * Sets the access.
	 * 
	 * @param access
	 *            the new access
	 */
	public void setAccess(AccessLevel access) {
		this.access = access;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((access == null) ? 0 : access.hashCode());
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + password;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (access != other.access)
			return false;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password != other.password)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", email=" + email + ", name=" + name
				+ ", firstName=" + firstName + ", surname=" + surname + ", age=" + age + ", access=" + access + "]";
	}

	

}
