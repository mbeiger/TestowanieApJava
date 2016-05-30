package com.project.car.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.project.car.domain.Car;
import com.project.car.service.CarManager;

@Path("car")
public class CarFakeRESTService {	
	
	private CarManager cm = new CarManager();
	
	@GET
	@Path("/{carId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getCar(@PathParam("carId") Long id){
		Car car = cm.getCar(id);
		return car;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Car car) {
 
		cm.addCar(car);
		return Response.status(201).entity("Car").build(); 
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewCar(Car car) {
		Car carToAdd = new Car(car.getModel(), car.getRok());
		cm.addCar(carToAdd);
		return Response.status(201).entity("success").build();
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCar(Car car) {
		Car carToDelete = cm.getCar(car.getId());
		cm.deleteCar(carToDelete);
		return Response.status(201).entity("success").build();
	}
	
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getAllCars() {
		return cm.getAllCars();
	}
	@DELETE
	public Response clearCars(){
		cm.clearCars();
		return Response.status(200).build();
	}
}
