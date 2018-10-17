package br.ifpb.ads.bd2.modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Email {
	@Id
	@Column(length = 50)
	private String email;

	@ManyToMany(mappedBy = "emails")
	private List<Usuario> usuarios;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Email() {

	}

}
