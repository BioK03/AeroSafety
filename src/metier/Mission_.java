package metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.129+0200")
@StaticMetamodel(Mission.class)
public class Mission_ {
	public static volatile SingularAttribute<Mission, Integer> id;
	public static volatile SingularAttribute<Mission, String> wording;
	public static volatile SingularAttribute<Mission, Game> game;
	public static volatile ListAttribute<Mission, Goal> goals;
}
