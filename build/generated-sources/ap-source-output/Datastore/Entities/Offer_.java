package Datastore.Entities;

import Datastore.Entities.Administrato;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-11-22T14:16:18")
@StaticMetamodel(Offer.class)
public class Offer_ { 

    public static volatile SingularAttribute<Offer, Integer> fee;
    public static volatile SingularAttribute<Offer, String> nam;
    public static volatile SingularAttribute<Offer, Integer> months;
    public static volatile SingularAttribute<Offer, Administrato> adminID;
    public static volatile SingularAttribute<Offer, Integer> numAds;
    public static volatile SingularAttribute<Offer, Date> endDate;
    public static volatile SingularAttribute<Offer, String> typ;
    public static volatile SingularAttribute<Offer, Date> publicationDate;

}