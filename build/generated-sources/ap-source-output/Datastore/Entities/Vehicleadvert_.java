package Datastore.Entities;

import Datastore.Entities.Administrato;
import Datastore.Entities.Fav;
import Datastore.Entities.Registeredclient;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-11-22T14:16:18")
@StaticMetamodel(Vehicleadvert.class)
public class Vehicleadvert_ { 

    public static volatile SingularAttribute<Vehicleadvert, String> vehicle;
    public static volatile SingularAttribute<Vehicleadvert, Registeredclient> clientID;
    public static volatile SingularAttribute<Vehicleadvert, String> state;
    public static volatile CollectionAttribute<Vehicleadvert, Fav> favCollection;
    public static volatile SingularAttribute<Vehicleadvert, Integer> code;
    public static volatile SingularAttribute<Vehicleadvert, String> offer;
    public static volatile SingularAttribute<Vehicleadvert, byte[]> imag;
    public static volatile SingularAttribute<Vehicleadvert, Integer> km;
    public static volatile SingularAttribute<Vehicleadvert, Integer> yearV;
    public static volatile SingularAttribute<Vehicleadvert, Integer> price;
    public static volatile SingularAttribute<Vehicleadvert, Administrato> adminID;
    public static volatile SingularAttribute<Vehicleadvert, String> color;
    public static volatile SingularAttribute<Vehicleadvert, String> email;
    public static volatile SingularAttribute<Vehicleadvert, String> modelV;
    public static volatile SingularAttribute<Vehicleadvert, String> brand;
    public static volatile SingularAttribute<Vehicleadvert, Date> publicationDate;

}