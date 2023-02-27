package modelo.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dao.BancoDAO;
import modelo.entidades.Banco;

public class JPABancoDAO extends JPAGenericDAO<Banco, Integer> implements BancoDAO {

	public JPABancoDAO() {
		super(Banco.class);
	}

	@Override
	public List<Banco> getAll() {
		TypedQuery<Banco> query = em.createNamedQuery("listarBancos", Banco.class);
		return query.getResultList();
	}

}
