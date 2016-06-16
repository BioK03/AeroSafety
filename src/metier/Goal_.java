package metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.085+0200")
@StaticMetamodel(Goal.class)
public class Goal_ {
	public static volatile SingularAttribute<Goal, Integer> id;
	public static volatile SingularAttribute<Goal, String> wording;
	public static volatile ListAttribute<Goal, Action> actions;
	public static volatile ListAttribute<Goal, Mission> missions;
}
