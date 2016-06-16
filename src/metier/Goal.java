package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the goal database table.
 * 
 */
@Entity
@NamedQuery(name="Goal.findAll", query="SELECT g FROM Goal g")
public class Goal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String wording;

	//bi-directional many-to-many association to Action
	@ManyToMany
	@JoinTable(
		name="action__goal"
		, joinColumns={
			@JoinColumn(name="fk_goal")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_action")
			}
		)
	private List<Action> actions;

	//bi-directional many-to-many association to Mission
	@ManyToMany(mappedBy="goals")
	private List<Mission> missions;

	public Goal() {
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

	public List<Mission> getMissions() {
		return this.missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

}