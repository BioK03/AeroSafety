package metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.104+0200")
@StaticMetamodel(Learner.class)
public class Learner_ {
	public static volatile SingularAttribute<Learner, Integer> id;
	public static volatile SingularAttribute<Learner, String> forname;
	public static volatile SingularAttribute<Learner, String> surname;
	public static volatile ListAttribute<Learner, Game> games;
	public static volatile ListAttribute<Learner, LearnerAction> learnerActions;
}
