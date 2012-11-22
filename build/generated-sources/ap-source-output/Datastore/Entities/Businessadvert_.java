package Datastore.Entities;

import Datastore.Entities.Administrato;
import Datastore.Entities.BusinessadvertPK;
import Datastore.Entities.Registeredclient;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-11-22T14:16:18")
@StaticMetamodel(Businessadvert.class)
public class Businessadvert_ { 

    public static volatile SingularAttribute<Businessadvert, Date> dat;
    public static volatile SingularAttribute<Businessadvert, String> sector;
    public static volatile SingularAttribute<Businessadvert, String> text;
    public static volatile SingularAttribute<Businessadvert, Administrato> adminID;
    public static volatile SingularAttribute<Businessadvert, String> state;
    public static volatile SingularAttribute<Businessadvert, BusinessadvertPK> businessadvertPK;
    public static volatile SingularAttribute<Businessadvert, byte[]> imag;
    public static volatile SingularAttribute<Businessadvert, Registeredclient> registeredclient;
    public static volatile SingularAttribute<Businessadvert, String> business;

}