package modelo.dao;

public abstract class DAOFactory {
	protected static DAOFactory instance = new JPADAOFactory();
	public static DAOFactory getFactory() {
		return instance;
	}
	
	public abstract BancoDAO getBancoDAO();
	public abstract PersonaDAO getPersonaDAO();
	public abstract CuentaBancariaDAO getCuentaBancariaDAO();
	
}
