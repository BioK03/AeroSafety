package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the action database table.
 * 
 */
@Entity
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int scoreMinimum;

	private String wording;

	//bi-directional many-to-one association to Action
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_action")
	private Action action;

	//bi-directional many-to-one association to Action
	@OneToMany(mappedBy="action")
	private List<Action> actions;

	//bi-directional many-to-many association to Game
	@ManyToMany(mappedBy="actions")
	private List<Game> games;

	//bi-directional many-to-many association to Goal
	@ManyToMany(mappedBy="actions")
	private List<Goal> goals;

	//bi-directional many-to-one association to Indicator
	@OneToMany(mappedBy="action")
	private List<Indicator> indicators;

	//bi-directional many-to-one association to LearnerAction
	@OneToMany(mappedBy="action")
	private List<LearnerAction> learnerActions;

	public Action() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScoreMinimum() {
		return this.scoreMinimum;
	}

	public void setScoreMinimum(int scoreMinimum) {
		this.scoreMinimum = scoreMinimum;
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

	public List<Action> getActions() {
		return this.actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Action addAction(Action action) {
		getActions().add(action);
		action.setAction(this);

		return action;
	}

	public Action removeAction(Action action) {
		getActions().remove(action);
		action.setAction(null);

		return action;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<Goal> getGoals() {
		return this.goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public List<Indicator> getIndicators() {
		return this.indicators;
	}

	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}

	public Indicator addIndicator(Indicator indicator) {
		getIndicators().add(indicator);
		indicator.setAction(this);

		return indicator;
	}

	public Indicator removeIndicator(Indicator indicator) {
		getIndicators().remove(indicator);
		indicator.setAction(null);

		return indicator;
	}

	public List<LearnerAction> getLearnerActions() {
		return this.learnerActions;
	}

	public void setLearnerActions(List<LearnerAction> learnerActions) {
		this.learnerActions = learnerActions;
	}

	public LearnerAction addLearnerAction(LearnerAction learnerAction) {
		getLearnerActions().add(learnerAction);
		learnerAction.setAction(this);

		return learnerAction;
	}

	public LearnerAction removeLearnerAction(LearnerAction learnerAction) {
		getLearnerActions().remove(learnerAction);
		learnerAction.setAction(null);

		return learnerAction;
	}

}