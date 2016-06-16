package metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.038+0200")
@StaticMetamodel(Action.class)
public class Action_ {
	public static volatile SingularAttribute<Action, Integer> id;
	public static volatile SingularAttribute<Action, Integer> scoreMinimum;
	public static volatile SingularAttribute<Action, String> wording;
	public static volatile SingularAttribute<Action, Action> action;
	public static volatile ListAttribute<Action, Action> actions;
	public static volatile ListAttribute<Action, Game> games;
	public static volatile ListAttribute<Action, Goal> goals;
	public static volatile ListAttribute<Action, Indicator> indicators;
	public static volatile ListAttribute<Action, LearnerAction> learnerActions;
}
