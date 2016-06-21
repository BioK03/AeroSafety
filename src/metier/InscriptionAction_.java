package metier;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.038+0200")
@StaticMetamodel(InscriptionAction.class)
public class InscriptionAction_ {
	public static volatile SingularAttribute<InscriptionAction, Integer> id;
	public static volatile SingularAttribute<InscriptionAction, Action> action;
	public static volatile SingularAttribute<InscriptionAction, Inscription> inscription;
	public static volatile SingularAttribute<InscriptionAction, Integer> sort;
	public static volatile SingularAttribute<InscriptionAction, Integer> score;
}
