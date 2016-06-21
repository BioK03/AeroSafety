package metier;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mission database table.
 * 
 */
@Entity
@NamedQuery(name="Inscription.findAll", query="SELECT i FROM Inscription i")
public class Inscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Date date;
	
	//bi-directional many-to-one association to Mission
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_mission")
	private Mission mission;

	//bi-directional many-to-one association to Learner
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_learner")
	private Learner learner;
	
	//bi-directional many-to-one association to InscriptionAction
	@OneToMany(mappedBy="inscription")
	private List<InscriptionAction> inscriptionActions;


	public Inscription() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Learner getLearner() {
		return learner;
	}

	public void setLearner(Learner learner) {
		this.learner = learner;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<InscriptionAction> getInscriptionActions() {
		return inscriptionActions;
	}

	public void setInscriptionActions(List<InscriptionAction> inscriptionActions) {
		this.inscriptionActions = inscriptionActions;
	}
}