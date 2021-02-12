package fr.upec.episen.mounir;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("/bikes")
public class BikeResource {


@GET
@Produces(MediaType.APPLICATION_JSON)
public List< Bike> getAllBikes(){

    ArrayList <Bike> bikes = new ArrayList<>();

    Bike bike1 = new Bike();
    bike1.setIdentification("AB-123-CD");
    bike1.setModel("VTT maître des montagnes 200");
    bike1.setPrice(500);

    Bike bike2 = new Bike();
    bike2.setIdentification("MC-007-CM");
    bike2.setModel("VTT maître des champs 007");
    bike2.setPrice(300);

    bikes.add(bike1);
    bikes.add(bike2);


    return bikes;


}



}
