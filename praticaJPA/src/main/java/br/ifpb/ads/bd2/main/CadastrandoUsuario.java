package br.ifpb.ads.bd2.main;

import java.sql.Date;
import java.util.ArrayList;

import br.ifpb.ads.bd2.dao.EmailDAO;
import br.ifpb.ads.bd2.dao.TelefoneDAO;
import br.ifpb.ads.bd2.dao.UsuarioDAO;
import br.ifpb.ads.bd2.modelos.Email;
import br.ifpb.ads.bd2.modelos.Telefone;
import br.ifpb.ads.bd2.modelos.Usuario;

public class CadastrandoUsuario{
	/**
	 * Main que ira cadastrar o usuario com emails e telefones
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Usuario usu = new Usuario();
		usu.setId(1);
		usu.setPrimeiroNome("Flávio");
		usu.setUltimoNome("Diniz");
		usu.setDataNascimento(new Date(1991, 2, 7));
		
		Telefone fone1 = new Telefone();
		fone1.setNumero("83 99945-0664");
		fone1.setUsuario(usu);
		
		Telefone fone2 = new Telefone();
		fone2.setNumero("83 99941-0359");
		fone2.setUsuario(usu);
		
		Email email1 = new Email();
		email1.setEmail("flvdiniz91@gmail.com");
		
		Email email2 = new Email();
		email2.setEmail("f-s.b@hotmail.com");
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usu);
		email1.setUsuarios(usuarios);
		email2.setUsuarios(usuarios);
		
		ArrayList<Telefone> fones = new ArrayList<Telefone>();
		fones.add(fone1);
		fones.add(fone2);
		usu.setTelefones(fones);
		
		ArrayList<Email> emails = new ArrayList<Email>();
		emails.add(email1);
		emails.add(email2);
		usu.setEmails(emails);
		
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.create(usu);
		
		TelefoneDAO tDao = new TelefoneDAO();
		tDao.create(fone1);
		tDao.create(fone2);
		
		EmailDAO eDao = new EmailDAO();
		eDao.create(email1);
		eDao.create(email2);
		
		
	}

}
