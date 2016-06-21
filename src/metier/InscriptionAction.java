package metier;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the mission database table.
 * 
 */
@Entity
@Table(name="inscription__action")
public class InscriptionAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int sort;
	
	private int score;
	
	//bi-directional many-to-one association to Action
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_action")
	private Action action;

	//bi-directional many-to-one association to Inscription
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_inscription")
	private Inscription inscription;


	public InscriptionAction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
}