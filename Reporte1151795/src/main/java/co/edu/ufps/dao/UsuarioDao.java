package co.edu.ufps.dao;

import co.edu.ufps.entities.Usuario;
import co.edu.ufps.util.Conexion;

public class UsuarioDao extends Conexion<Usuario> implements GenericDao<Usuario>{

	private static final long serialVersionUID = 1L;
	
	public UsuarioDao() {
		super(Usuario.class);
	}
}
