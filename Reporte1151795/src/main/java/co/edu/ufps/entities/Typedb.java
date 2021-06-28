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
@NamedQuery(name="Typedb.findAll", query="SELECT t FROM Typedb t")
public class Typedb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String aditional;

	private String description;

	private String driver;

	//bi-directional many-to-one association to Connectiontoken
	@OneToMany(mappedBy="typedb")
	private List<Connectiontoken> connectiontokens;

	
	public List<Connectiontoken> getConnectiontokens() {
		return this.connectiontokens;
	}

	public void setConnectiontokens(List<Connectiontoken> connectiontokens) {
		this.connectiontokens = connectiontokens;
	}

	public Connectiontoken addConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().add(connectiontoken);
		connectiontoken.setTypedb(this);

		return connectiontoken;
	}

	public Connectiontoken removeConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().remove(connectiontoken);
		connectiontoken.setTypedb(null);

		return connectiontoken;
	}

	public Typedb(String aditional, String description, String driver) {
		super();
		this.aditional = aditional;
		this.description = description;
		this.driver = driver;
	}
	
	

}