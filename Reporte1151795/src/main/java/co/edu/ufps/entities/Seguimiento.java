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
@NamedQuery(name="Seguimiento.findAll", query="SELECT s FROM Seguimiento s")
public class Seguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp dategenerate;

	private String detailrequest;

	private String filegenerate;

	private String result;

	private short state;

	private String type;

	//bi-directional many-to-one association to Reporte
	@ManyToOne
	@JoinColumn(name="report")
	private Reporte reporte;

	

}