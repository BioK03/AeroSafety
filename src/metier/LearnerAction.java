package metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the learner__action database table.
 * 
 */
@Entity
@Table(name="learner__action")
@NamedQuery(name="LearnerAction.findAll", query="SELECT l FROM LearnerAction l")
public class LearnerAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LearnerActionPK id;

	private int value;

	//bi-directional many-to-one association to Action
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_action")
	private Action action;

	//bi-directional many-to-one association to Learner
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_learner")
	private Learner learner;

	public LearnerAction() {
	}

	public LearnerActionPK getId() {
		return this.id;
	}

	public void setId(LearnerActionPK id) {
		this.id = id;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Learner getLearner() {
		return this.learner;
	}

	public void setLearner(Learner learner) {
		this.learner = learner;
	}

}