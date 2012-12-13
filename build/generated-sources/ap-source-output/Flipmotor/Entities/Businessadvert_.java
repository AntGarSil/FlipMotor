package Flipmotor.Entities;

import Flipmotor.Entities.Conciliation;
import Flipmotor.Entities.Offer;
import Flipmotor.Entities.Registeredclient;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-12-13T13:19:47")
@StaticMetamodel(Businessadvert.class)
public class Businessadvert_ { 

    public static volatile SingularAttribute<Businessadvert, Date> dat;
    public static volatile SingularAttribute<Businessadvert, String> sector;
    public static volatile SingularAttribute<Businessadvert, String> text;
    public static volatile CollectionAttribute<Businessadvert, Conciliation> conciliationCollection;
    public static volatile SingularAttribute<Businessadvert, String> state;
    public static volatile SingularAttribute<Businessadvert, Registeredclient> clientID;
    public static volatile SingularAttribute<Businessadvert, Date> endDate;
    public static volatile SingularAttribute<Businessadvert, Integer> code;
    public static volatile SingularAttribute<Businessadvert, Offer> offer;
    public static volatile SingularAttribute<Businessadvert, byte[]> imag;
    public static volatile SingularAttribute<Businessadvert, String> business;

}