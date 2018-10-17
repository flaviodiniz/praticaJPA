package br.ifpb.ads.bd2.main;

import java.util.ArrayList;

import br.ifpb.ads.bd2.dao.TelefoneDAO;
import br.ifpb.ads.bd2.modelos.Telefone;

public class PesquisaUsuarioFone {

	public static void main(String[] args) {
		Telefone fone = pesquisa("83 99941-0359");
		System.out.println("Usuario do telefone é "+fone.getUsuario().getPrimeiroNome());
		pesquisaPorUsuario(1);
	}
	
	public static Telefone pesquisa(String numero) {
		TelefoneDAO foneDao = new TelefoneDAO();
		Telefone fone = new Telefone();
		fone.setNumero(numero);
		
		return foneDao.find(fone);
	}
	
	public static void pesquisaPorUsuario(int id) {
		TelefoneDAO tDao = new TelefoneDAO();
		ArrayList<Telefone> fones = (ArrayList<Telefone>) tDao.listaTelefones();
		for (Telefone t : fones) {
			if (t.getUsuario().getId() == id)
				System.out.println("telefone= " + t.getNumero());
		}
	}

}
