package Flipmotor.Entities;

import Flipmotor.Entities.Businessadvert;
import Flipmotor.Entities.Vehicleadvert;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-12-14T00:44:29")
@StaticMetamodel(Offer.class)
public class Offer_ { 

    public static volatile SingularAttribute<Offer, Integer> fee;
    public static volatile SingularAttribute<Offer, String> nam;
    public static volatile SingularAttribute<Offer, Integer> months;
    public static volatile CollectionAttribute<Offer, Vehicleadvert> vehicleadvertCollection;
    public static volatile SingularAttribute<Offer, Integer> active;
    public static volatile SingularAttribute<Offer, Date> endDate;
    public static volatile SingularAttribute<Offer, String> typ;
    public static volatile CollectionAttribute<Offer, Businessadvert> businessadvertCollection;
    public static volatile SingularAttribute<Offer, Date> publicationDate;

}