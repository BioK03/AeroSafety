package metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.076+0200")
@StaticMetamodel(Game.class)
public class Game_ {
	public static volatile SingularAttribute<Game, Integer> id;
	public static volatile SingularAttribute<Game, String> wording;
	public static volatile ListAttribute<Game, Action> actions;
	public static volatile ListAttribute<Game, Learner> learners;
	public static volatile ListAttribute<Game, Mission> missions;
}
