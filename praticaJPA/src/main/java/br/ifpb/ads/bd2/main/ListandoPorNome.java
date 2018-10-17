package br.ifpb.ads.bd2.main;

import java.util.Date;

import br.ifpb.ads.bd2.dao.UsuarioDAO;
import br.ifpb.ads.bd2.modelos.Usuario;

public class ListandoPorNome {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		UsuarioDAO uDao = new UsuarioDAO();
		Usuario usuarioRecuperado = uDao.find("Flávio", null);
		System.out.println(usuarioRecuperado.getPrimeiroNome() + " " + usuarioRecuperado.getUltimoNome());
		
		Usuario usuarioRecuperado2 = uDao.find(null, new Date(1991, 02, 07));
		System.out.println(usuarioRecuperado2.getUltimoNome()  + " " + usuarioRecuperado2.getUltimoNome());

	}

}
