package modelo.jpa;

import java.util.List;
import javax.persistence.TypedQuery;

import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO {

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	@Override
	public List<Persona> getAll() {
		TypedQuery<Persona> q = em.createNamedQuery("listarPersonas", Persona.class);
		return q.getResultList();
	}

	@Override
	public Persona autorizar(String nombre, String clave) {
		TypedQuery<Persona> q = em.createNamedQuery("encontrarPersonaPorNombreYClave", Persona.class);
		q.setParameter("param_nombre", nombre);
		q.setParameter("param_clave", nombre);
		return q.getSingleResult();
	}


}
