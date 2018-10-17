package br.ifpb.ads.bd2.main;

import java.util.ArrayList;

import br.ifpb.ads.bd2.dao.EmailDAO;
import br.ifpb.ads.bd2.dao.TelefoneDAO;
import br.ifpb.ads.bd2.dao.UsuarioDAO;
import br.ifpb.ads.bd2.modelos.Email;
import br.ifpb.ads.bd2.modelos.Telefone;
import br.ifpb.ads.bd2.modelos.Usuario;

public class ListandoUsuarios {

	public static void main(String[] args) {
		fonesEmailDoUsuario(1);

	}

	/**
	 * metodo que imprime o usuario por id junto com seu telefone e email
	 * 
	 * @param id
	 */
	public static void fonesEmailDoUsuario(int id) {
		UsuarioDAO uDao = new UsuarioDAO();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) uDao.listaUsuarios();
		TelefoneDAO tDao = new TelefoneDAO();
		ArrayList<Telefone> fones = (ArrayList<Telefone>) tDao.listaTelefones();
//		EmailDAO eDao = new EmailDAO();
//		ArrayList<Email> emails = (ArrayList<Email>) eDao.listaUsuariosEmail();

		for (Usuario u : usuarios) {
			if (u.getId() == id) {
				System.out.println("Usuario: Nome= " + u.getPrimeiroNome());
				for (Telefone t : fones) {
					if (t.getUsuario().getId() == id)
						System.out.println("telefone= " + t.getNumero());
				}
//				for (Email e : emails) {
//					for (Usuario usu : e.getUsuarios()) {
				/**
				 * Lista todos os email, porém quando pega os usuarios, retorna que é interno
				 */
//						if (usu.getId() == id)
//							System.out.println("email= " + e.getEmail());
//					}
//				}
			}
		}
	}

}
