package co.edu.ufps.dao;

import co.edu.ufps.entities.Rol;
import co.edu.ufps.util.Conexion;

public class RolDao extends Conexion<Rol> implements GenericDao<Rol>{

	private static final long serialVersionUID = 1L;
	
	public RolDao() {
		super(Rol.class);
	}
}
