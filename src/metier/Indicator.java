package metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indicator database table.
 * 
 */
@Entity
@NamedQuery(name="Indicator.findAll", query="SELECT i FROM Indicator i")
public class Indicator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int weight;

	//bi-directional many-to-one association to Action
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_action")
	private Action action;

	public Indicator() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}