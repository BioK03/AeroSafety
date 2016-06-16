package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the learner database table.
 * 
 */
@Entity
@NamedQuery(name="Learner.findAll", query="SELECT l FROM Learner l")
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

	//bi-directional many-to-many association to Game
	@ManyToMany
	@JoinTable(
		name="inscription"
		, joinColumns={
			@JoinColumn(name="fk_learner")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_game")
			}
		)
	private List<Game> games;

	//bi-directional many-to-one association to LearnerAction
	@OneToMany(mappedBy="learner")
	private List<LearnerAction> learnerActions;

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

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
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
	
	public List<LearnerAction> getLearnerActions() {
		return this.learnerActions;
	}

	public void setLearnerActions(List<LearnerAction> learnerActions) {
		this.learnerActions = learnerActions;
	}

	public LearnerAction addLearnerAction(LearnerAction learnerAction) {
		getLearnerActions().add(learnerAction);
		learnerAction.setLearner(this);

		return learnerAction;
	}

	public LearnerAction removeLearnerAction(LearnerAction learnerAction) {
		getLearnerActions().remove(learnerAction);
		learnerAction.setLearner(null);

		return learnerAction;
	}

}