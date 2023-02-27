package modelo.dao;

import modelo.entidades.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer>{
	Persona autorizar(String usuario, String clave);
}
