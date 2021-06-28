package co.edu.ufps.dao;

import co.edu.ufps.entities.Seguimiento;
import co.edu.ufps.util.Conexion;

public class SeguimientoDao extends Conexion<Seguimiento> implements GenericDao<Seguimiento>{

	private static final long serialVersionUID = 1L;
	
	public SeguimientoDao() {
		super(Seguimiento.class);
	}
}
