package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the learner database table.
 * 
 */
@Entity
public class Learner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String forname;

	private String surname;
	
	private String salt;
	
	private String email;
	
	private String mdp;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="learner")
	private List<Inscription> inscriptions;

	public Learner() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getForname() {
		return this.forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}
	
	public List<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setLearnerActions(List<Inscription> inscriptions) {
		this.inscriptions =inscriptions;
	}
}