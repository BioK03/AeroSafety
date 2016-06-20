package metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.094+0200")
@StaticMetamodel(Indicator.class)
public class Indicator_ {
	public static volatile SingularAttribute<Indicator, Integer> id;
	public static volatile SingularAttribute<Indicator, String> wording;
	public static volatile SingularAttribute<Indicator, Action> action;
	public static volatile SingularAttribute<Indicator, Integer> valueIfCheck;
	public static volatile SingularAttribute<Indicator, Integer> valueIfUnCheck;
}
