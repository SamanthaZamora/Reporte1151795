package co.edu.ufps.dao;

import co.edu.ufps.entities.Reporte;
import co.edu.ufps.util.Conexion;

public class ReporteDao extends Conexion<Reporte> implements GenericDao<Reporte>{

	private static final long serialVersionUID = 1L;
	
	public ReporteDao() {
		super(Reporte.class);
	}
}