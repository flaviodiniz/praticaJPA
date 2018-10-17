package br.ifpb.ads.bd2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpb.ads.bd2.modelos.Email;

public class EmailDAO extends DAO {

	public void create(Email email) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(email);
			em.getTransaction().commit();
			System.out.println("Email Salvo!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar Email!");
		} finally {
			em.close();
			close();
		}
	}

	public Email find(Email email) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		String mail = email.getEmail();
		try {
			Email p = em.find(Email.class, mail);
			System.out.println("Email recuperado!");
			return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar Email!");
		} finally {
			em.close();
			close();
		}
		return null;
	}

	public Email update(Email email) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		String mail = email.getEmail();
		try {
			Email e = em.find(Email.class, mail);
			if (e != null) {
				e = email;
				em.merge(e);
				em.getTransaction().commit();
				System.out.println("Email atualizado!");
			} else {
				System.out.println("Email inexistente!");
			}
			return e;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar Email!");
		} finally {
			em.close();
			close();
		}
		return null;

	}

	public void remove(Email email) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Email e = em.find(Email.class, email.getEmail());
			if (e != null)
				em.remove(e);
			em.getTransaction().commit();
			System.out.println("Email removido!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover Email!");
		} finally {
			em.close();
			close();
		}
	}

	public List<Email> listaUsuariosEmail() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Email> emails = em.createQuery("Select e from Email e").getResultList();
		em.close();
		close();
		return emails;
	}

}
