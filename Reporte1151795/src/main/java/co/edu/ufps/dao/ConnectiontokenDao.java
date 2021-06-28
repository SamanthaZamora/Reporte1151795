package co.edu.ufps.dao;

import co.edu.ufps.entities.Connectiontoken;
import co.edu.ufps.util.Conexion;

public class ConnectiontokenDao extends Conexion<Connectiontoken> implements GenericDao<Connectiontoken>{

	private static final long serialVersionUID = 1L;
	
	public ConnectiontokenDao() {
		super(Connectiontoken.class);
	}
}