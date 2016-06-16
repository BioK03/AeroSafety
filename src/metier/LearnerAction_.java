package metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.114+0200")
@StaticMetamodel(LearnerAction.class)
public class LearnerAction_ {
	public static volatile SingularAttribute<LearnerAction, LearnerActionPK> id;
	public static volatile SingularAttribute<LearnerAction, Integer> value;
	public static volatile SingularAttribute<LearnerAction, Action> action;
	public static volatile SingularAttribute<LearnerAction, Learner> learner;
}
