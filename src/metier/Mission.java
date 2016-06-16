package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mission database table.
 * 
 */
@Entity
@NamedQuery(name="Mission.findAll", query="SELECT m FROM Mission m")
public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String wording;

	//bi-directional many-to-one association to Game
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_game")
	private Game game;

	//bi-directional many-to-many association to Goal
	@ManyToMany
	@JoinTable(
		name="mission_goal"
		, joinColumns={
			@JoinColumn(name="fk_mission")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_goal")
			}
		)
	private List<Goal> goals;

	public Mission() {
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

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Goal> getGoals() {
		return this.goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

}