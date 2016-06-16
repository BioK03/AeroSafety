package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String wording;

	//bi-directional many-to-many association to Action
	@ManyToMany
	@JoinTable(
		name="game__action"
		, joinColumns={
			@JoinColumn(name="fk_game")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_action")
			}
		)
	private List<Action> actions;

	//bi-directional many-to-many association to Learner
	@ManyToMany(mappedBy="games")
	private List<Learner> learners;

	//bi-directional many-to-one association to Mission
	@OneToMany(mappedBy="game")
	private List<Mission> missions;

	public Game() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWording() {
		return this.wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Learner> getLearners() {
		return this.learners;
	}

	public void setLearners(List<Learner> learners) {
		this.learners = learners;
	}

	public List<Mission> getMissions() {
		return this.missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public Mission addMission(Mission mission) {
		getMissions().add(mission);
		mission.setGame(this);

		return mission;
	}

	public Mission removeMission(Mission mission) {
		getMissions().remove(mission);
		mission.setGame(null);

		return mission;
	}

}