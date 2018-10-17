package br.ifpb.ads.bd2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ifpb.ads.bd2.modelos.Telefone;

public class TelefoneDAO extends DAO {

	public void create(Telefone telefone) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(telefone);
			em.getTransaction().commit();
			System.out.println("Telefone Salvo!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar Telefone!");
		} finally {
			em.close();
			close();
		}
	}

	public Telefone find(Telefone usuario) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		String numero = usuario.getNumero();
		try {
			Telefone p = em.find(Telefone.class, numero);
			System.out.println("Telefone recuperado!");
			return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar Telefone!");
		} finally {
			em.close();
			close();
		}
		return null;
	}

	public Telefone update(Telefone telefone) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		String numero = telefone.getNumero();
		try {
			Telefone t = em.find(Telefone.class, numero);
			if (t != null) {
				t = telefone;
				em.merge(t);
				em.getTransaction().commit();
				System.out.println("Telefone atualizado!");
			} else {
				System.out.println("Telefone inexistente!");
			}
			return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar Telefone!");
		} finally {
			em.close();
			close();
		}
		return null;

	}

	public void remove(Telefone usuario) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Telefone t = em.find(Telefone.class, usuario.getNumero());
			if (t != null)
				em.remove(t);
			em.getTransaction().commit();
			System.out.println("Telefone removido!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover Telefone!");
		} finally {
			em.close();
			close();
		}
	}
	
	/**
	 * metodo que lista todos os telefones
	 * @return
	 */
	public List<Telefone> listaTelefones(){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Telefone> fones = em.createQuery("Select t from Telefone t").getResultList();
		em.close();
		close();
		return fones;
	}

}
