package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp datecreate;

	private String description;

	private String file;

	private String name;

	private String state;

	//bi-directional many-to-one association to Connectiontoken
	@ManyToOne
	@JoinColumn(name="conexion")
	private Connectiontoken connectiontoken;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="reporte")
	private List<Seguimiento> seguimientos;

	public List<Seguimiento> getSeguimientos() {
		return this.seguimientos;
	}

	public void setSeguimientos(List<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public Seguimiento addSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().add(seguimiento);
		seguimiento.setReporte(this);

		return seguimiento;
	}

	public Seguimiento removeSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().remove(seguimiento);
		seguimiento.setReporte(null);

		return seguimiento;
	}

}