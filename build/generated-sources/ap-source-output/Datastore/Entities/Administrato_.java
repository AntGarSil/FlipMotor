package Datastore.Entities;

import Datastore.Entities.Businessadvert;
import Datastore.Entities.Offer;
import Datastore.Entities.Vehicleadvert;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-11-22T14:16:18")
@StaticMetamodel(Administrato.class)
public class Administrato_ { 

    public static volatile SingularAttribute<Administrato, String> username;
    public static volatile CollectionAttribute<Administrato, Vehicleadvert> vehicleadvertCollection;
    public static volatile CollectionAttribute<Administrato, Offer> offerCollection;
    public static volatile SingularAttribute<Administrato, Integer> adminID;
    public static volatile SingularAttribute<Administrato, String> passwor;
    public static volatile CollectionAttribute<Administrato, Businessadvert> businessadvertCollection;

}