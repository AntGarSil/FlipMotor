package Flipmotor.Entities;

import Flipmotor.Entities.Registeredclient;
import Flipmotor.Entities.Vehicleadvert;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-12-14T00:44:29")
@StaticMetamodel(Fav.class)
public class Fav_ { 

    public static volatile SingularAttribute<Fav, Integer> id;
    public static volatile SingularAttribute<Fav, Registeredclient> clientID;
    public static volatile SingularAttribute<Fav, Vehicleadvert> code;

}