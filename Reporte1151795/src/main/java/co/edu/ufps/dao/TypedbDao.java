package co.edu.ufps.dao;

import co.edu.ufps.entities.Typedb;
import co.edu.ufps.util.Conexion;

public class TypedbDao extends Conexion<Typedb> implements GenericDao<Typedb>{

	private static final long serialVersionUID = 1L;
	
	public TypedbDao() {
		super(Typedb.class);
	}
}
