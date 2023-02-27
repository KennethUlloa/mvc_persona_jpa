package modelo.dao;

import modelo.jpa.JPABancoDAO;
import modelo.jpa.JPACuentaBancariaDAO;
import modelo.jpa.JPAPersonaDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public BancoDAO getBancoDAO() {
		return new JPABancoDAO();
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

	@Override
	public CuentaBancariaDAO getCuentaBancariaDAO() {
		return new JPACuentaBancariaDAO();
	}

}
