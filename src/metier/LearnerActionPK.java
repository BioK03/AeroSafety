package metier;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the learner__action database table.
 * 
 */
@Embeddable
public class LearnerActionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="fk_learner", insertable=false, updatable=false)
	private int fkLearner;

	@Column(name="fk_action", insertable=false, updatable=false)
	private int fkAction;

	public LearnerActionPK() {
	}
	public int getFkLearner() {
		return this.fkLearner;
	}
	public void setFkLearner(int fkLearner) {
		this.fkLearner = fkLearner;
	}
	public int getFkAction() {
		return this.fkAction;
	}
	public void setFkAction(int fkAction) {
		this.fkAction = fkAction;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LearnerActionPK)) {
			return false;
		}
		LearnerActionPK castOther = (LearnerActionPK)other;
		return 
			(this.fkLearner == castOther.fkLearner)
			&& (this.fkAction == castOther.fkAction);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fkLearner;
		hash = hash * prime + this.fkAction;
		
		return hash;
	}
}