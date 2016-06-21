package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mission database table.
 * 
 */
@Entity
public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String wording;
	
	//bi-directional many-to-many association to Action
	@ManyToMany
	@JoinTable(
		name="action__mission"
		, joinColumns={
			@JoinColumn(name="fk_mission")
			}
		, inverseJoinColumns={
			@JoinColumn(name="fk_action")
			}
		)
	private List<Action> actions;
		
	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="mission")
	private List<Inscription> inscriptions;


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


	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
}