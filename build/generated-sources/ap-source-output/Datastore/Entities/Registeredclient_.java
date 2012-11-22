package Datastore.Entities;

import Datastore.Entities.Businessadvert;
import Datastore.Entities.Fav;
import Datastore.Entities.Vehicleadvert;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-11-22T14:16:18")
@StaticMetamodel(Registeredclient.class)
public class Registeredclient_ { 

    public static volatile CollectionAttribute<Registeredclient, Vehicleadvert> vehicleadvertCollection;
    public static volatile SingularAttribute<Registeredclient, Integer> anuncio;
    public static volatile SingularAttribute<Registeredclient, Integer> phone;
    public static volatile SingularAttribute<Registeredclient, String> nam;
    public static volatile SingularAttribute<Registeredclient, String> nif;
    public static volatile SingularAttribute<Registeredclient, Integer> fav;
    public static volatile SingularAttribute<Registeredclient, Integer> flat;
    public static volatile SingularAttribute<Registeredclient, String> street;
    public static volatile SingularAttribute<Registeredclient, Integer> clientID;
    public static volatile SingularAttribute<Registeredclient, String> surname;
    public static volatile CollectionAttribute<Registeredclient, Fav> favCollection;
    public static volatile SingularAttribute<Registeredclient, String> city;
    public static volatile SingularAttribute<Registeredclient, Long> creditCard;
    public static volatile SingularAttribute<Registeredclient, Integer> numbe;
    public static volatile SingularAttribute<Registeredclient, String> nationality;
    public static volatile SingularAttribute<Registeredclient, String> email;
    public static volatile SingularAttribute<Registeredclient, Integer> pc;
    public static volatile SingularAttribute<Registeredclient, String> province;
    public static volatile SingularAttribute<Registeredclient, Character> leter;
    public static volatile SingularAttribute<Registeredclient, String> passwor;
    public static volatile CollectionAttribute<Registeredclient, Businessadvert> businessadvertCollection;

}