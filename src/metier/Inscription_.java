package metier;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T13:36:56.129+0200")
@StaticMetamodel(Inscription.class)
public class Inscription_ {
	public static volatile SingularAttribute<Inscription, Integer> id;
	public static volatile SingularAttribute<Inscription, Action> mission;
	public static volatile SingularAttribute<Inscription, Learner> learner;
	public static volatile SingularAttribute<Inscription, Date> date;
	public static volatile ListAttribute<Inscription, InscriptionAction> inscriptionActions;
}
