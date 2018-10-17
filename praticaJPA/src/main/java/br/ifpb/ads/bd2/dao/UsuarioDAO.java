package br.ifpb.ads.bd2.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.ifpb.ads.bd2.modelos.Usuario;

public class UsuarioDAO extends DAO {

	public void create(Usuario usuario) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.persist(usuario);
			em.getTransaction().commit();
			System.out.println("Usuario Salvo!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao salvar usuario!");
		} finally {
			em.close();
			close();
		}
	}

	public Usuario findId(Usuario usuario) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = usuario.getId();
		try {
			Usuario p = em.find(Usuario.class, id);
			System.out.println("Usuario recuperado por id!");
			return p;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar Usuario!");
		} finally {
			em.close();
			close();
		}
		return null;
	}

	public Usuario find(String primeiroNome, Date dataNascimento) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			CriteriaBuilder buil = em.getCriteriaBuilder();
			CriteriaQuery<Usuario> query = buil.createQuery(Usuario.class);
			Root<Usuario> usuarios = query.from(Usuario.class);
			Predicate p = null;
			if (primeiroNome != null)
				p = buil.equal(usuarios.get("primeiroNome"), primeiroNome);
			else if (dataNascimento != null)
				p = buil.equal(usuarios.get("dataNascimento"), dataNascimento);
			
			query.select(usuarios).where(p);
			Usuario u = em.createQuery(query).getSingleResult();
			System.out.println("Usuario recuperado por nome!");
			return u;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao recuperar Usuario!");
		} finally {
			em.close();
			close();
		}
		return null;
	}

	public Usuario update(Usuario usuario) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		int id = usuario.getId();
		try {
			Usuario u = em.find(Usuario.class, id);
			if (u != null) {
				u = usuario;
				em.merge(u);
				em.getTransaction().commit();
				System.out.println("Usuario atualizado!");
			} else {
				System.out.println("Usuario inexistente!");
			}
			return u;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao atualizar Usuario!");
		} finally {
			em.close();
			close();
		}
		return null;

	}

	public void remove(Usuario usuario) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			Usuario u = em.find(Usuario.class, usuario.getId());
			if (u != null)
				em.remove(u);
			em.getTransaction().commit();
			System.out.println("Usuario removido!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Erro ao remover Usuario!");
		} finally {
			em.close();
			close();
		}
	}

	/**
	 * Metodo que retorna todos os usuarios
	 * 
	 * @return
	 */
	public List<Usuario> listaUsuarios() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		List<Usuario> usuarios = em.createQuery("Select u from Usuario u").getResultList();
		em.close();
		close();
		return usuarios;
	}

}
