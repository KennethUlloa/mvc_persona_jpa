package modelo.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dao.CuentaBancariaDAO;
import modelo.entidades.CuentaBancaria;

public class JPACuentaBancariaDAO extends JPAGenericDAO<CuentaBancaria, Integer> implements CuentaBancariaDAO {

	public JPACuentaBancariaDAO() {
		super(CuentaBancaria.class);
	}

	@Override
	public List<CuentaBancaria> getAll() {
		TypedQuery<CuentaBancaria> query = em.createNamedQuery("listarCuentas", CuentaBancaria.class);
		return query.getResultList();
	}

}
