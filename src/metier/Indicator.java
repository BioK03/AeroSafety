package metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indicator database table.
 * 
 */
@Entity
public class Indicator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String wording;
	
	private int valueIfCheck;
	
	private int valueIfUnCheck;
	
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
	
	public String getWording() {
		return this.wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int getValueIfCheck() {
		return valueIfCheck;
	}

	public void setValueIfCheck(int valueIfCheck) {
		this.valueIfCheck = valueIfCheck;
	}

	public int getValueIfUnCheck() {
		return valueIfUnCheck;
	}

	public void setValueIfUnCheck(int valueIfUnCheck) {
		this.valueIfUnCheck = valueIfUnCheck;
	}
}