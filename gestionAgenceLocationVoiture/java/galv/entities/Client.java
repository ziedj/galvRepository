package galv.entities;

import java.io.Serializable;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String cin;
	private String firstname;
	private String lastname;
	private String telephone;
	private String email;
	private String address;

	public Client() {
	}

	public Client(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// ======================================
	// = hash, equals, toString =
	// ======================================

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Client client = (Client) o;

		if (email != null ? !email.equals(client.email)
				: client.email != null)
			return false;
		if (!firstname.equals(client.firstname))
			return false;
		if (!cin.equals(client.cin))
			return false;
		if (!lastname.equals(client.lastname))
			return false;
		if (telephone != null ? !telephone.equals(client.telephone)
				: client.telephone != null)
			return false;
		if (address != null ? !address.equals(client.address)
				: client.address != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		result = cin.hashCode();
		result = 31 * result + firstname.hashCode();
		result = 31 * result + lastname.hashCode();
		result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Client");
		sb.append("{CIN=").append(cin);
		sb.append(", firstname='").append(firstname).append('\'');
		sb.append(", lastname='").append(lastname).append('\'');
		sb.append(", telephone='").append(telephone).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", address=").append(address).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
