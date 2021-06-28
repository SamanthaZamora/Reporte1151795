package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@NamedQuery(name="Connectiontoken.findAll", query="SELECT c FROM Connectiontoken c")
public class Connectiontoken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String db;

	private String host;

	private String pass;

	private short port;

	private short state;

	private String token;

	private String userdb;

	//bi-directional many-to-one association to Typedb
	@ManyToOne
	@JoinColumn(name="type")
	private Typedb typedb;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="user")
	private Usuario usuario;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="connectiontoken")
	private List<Reporte> reportes;

	
	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setConnectiontoken(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setConnectiontoken(null);

		return reporte;
	}

}