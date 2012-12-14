package Flipmotor.Entities;

import Flipmotor.Entities.Businessadvert;
import Flipmotor.Entities.Registeredclient;
import Flipmotor.Entities.Vehicleadvert;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-12-14T00:44:29")
@StaticMetamodel(Conciliation.class)
public class Conciliation_ { 

    public static volatile SingularAttribute<Conciliation, Registeredclient> userID;
    public static volatile SingularAttribute<Conciliation, Integer> price;
    public static volatile SingularAttribute<Conciliation, Vehicleadvert> vehicleID;
    public static volatile SingularAttribute<Conciliation, Date> tdate;
    public static volatile SingularAttribute<Conciliation, Long> creditcard;
    public static volatile SingularAttribute<Conciliation, Businessadvert> businessID;
    public static volatile SingularAttribute<Conciliation, Integer> code;

}