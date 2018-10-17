package br.ifpb.ads.bd2.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	@Id
	@Column(length = 15)
	private String numero;

	@ManyToOne
	@JoinColumn(name = "id")
	private Usuario usuario;

	public Telefone() {

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
