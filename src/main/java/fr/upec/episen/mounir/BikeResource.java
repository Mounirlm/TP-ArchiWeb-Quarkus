package fr.upec.episen.mounir;

import fr.upec.episen.mounir.proto.OwnerGrpc;
import fr.upec.episen.mounir.proto.OwnerNameRequest;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("/bikes")
public class BikeResource {

    private HashMap<String, Bike> hashMap = new HashMap<String, Bike>();

    @Inject
    @GrpcService("owner")
    OwnerGrpc.OwnerBlockingStub ownerService;


@GET
@Produces(MediaType.APPLICATION_JSON)
public HashMap<String, Bike> getAllBikes(){

    ArrayList <Bike> bikes = new ArrayList<>();

    Bike bike1 = new Bike();
    bike1.setIdentification("AB-123-CD");
    bike1.setModel("VTT maître des montagnes 200");
    bike1.setPrice(500);
    bike1.setOwner(ownerService.getOwnerName(OwnerNameRequest
            .newBuilder().setIdentification(bike1.getIdentification())
            .build())
    .getName());

    Bike bike2 = new Bike();
    bike2.setIdentification("MC-007-CM");
    bike2.setModel("VTT maître des champs 007");
    bike2.setPrice(300);
    bike2.setOwner(ownerService.getOwnerName(OwnerNameRequest
            .newBuilder().setIdentification(bike2.getIdentification())
            .build())
            .getName());

    bikes.add(bike1);
    bikes.add(bike2);

    hashMap.put(bike1.getOwner(),bike1);
    hashMap.put(bike2.getOwner(),bike2);

    return hashMap;


}



}
