package br.ifpb.ads.bd2.main;

import br.ifpb.ads.bd2.dao.TelefoneDAO;
import br.ifpb.ads.bd2.dao.UsuarioDAO;
import br.ifpb.ads.bd2.modelos.Telefone;
import br.ifpb.ads.bd2.modelos.Usuario;

public class PesquisaUsuario {

	public static void main(String[] args) {
		UsuarioDAO uDao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setId(1);
		Usuario usuarioRecuperado = uDao.findId(usuario);

		System.out.println("Nome= " + usuarioRecuperado.getPrimeiroNome() + " "
				+ usuarioRecuperado.getUltimoNome() + ", data de nascimento= " + usuarioRecuperado.getDataNascimento());
		
		TelefoneDAO tDao = new TelefoneDAO();
					
		for (Telefone t : tDao.listaTelefones()) {
			if (t.getUsuario().getId() == usuarioRecuperado.getId())
				System.out.println("telefone= " + t.getNumero());
		}
		
	}

}
