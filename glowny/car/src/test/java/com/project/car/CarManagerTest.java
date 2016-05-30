package com.project.car;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.project.car.domain.Car;
import com.project.car.service.CarManager;


public class CarManagerTest {
	
	
	CarManager carManager = new CarManager();
	
	private final static String MODEL_1 = "Renault";
	private final static int ROK_1 = 2008;
	
	private final static String MODEL_2 = "Mazda";
	private final static int ROK_2 = 2013;
	
	private final static String MODEL_3 = "Fiat";
	private final static int ROK_3 = 2015;	
	@Test
	public void checkConnection(){
		assertNotNull(carManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Car car1 = new Car(MODEL_1, ROK_1);
		
		carManager.clearCars();
		assertEquals(1, carManager.addCar(car1));
		
		List<Car> cars = carManager.getAllCars();
		Car carRetrieved = cars.get(0);
		
		assertEquals(MODEL_1, carRetrieved.getModel());
		assertEquals(ROK_1, carRetrieved.getRok());
		
	}
	
	@Test
	public void checkUpdating(){
		
		Car car1 = new Car(MODEL_1, ROK_1);
		Car car2 = new Car(MODEL_2, ROK_2);
		Car car3 = new Car(MODEL_3, ROK_3);
		
		carManager.clearCars();
		assertEquals(1, carManager.addCar(car1));
		assertEquals(1, carManager.addCar(car2));
		assertEquals(1, carManager.addCar(car3));
		
		int id = carManager.addCarGetID(car1);
		assertEquals(1, carManager.updateCar(id, car2));
		
		List<Car> cars = carManager.getAllCars();
		Car carRetrieved = cars.get(3);
		
		assertEquals(MODEL_2, carRetrieved.getModel());
		assertEquals(ROK_2, carRetrieved.getRok());
		
	}
	@Test
	public void checkDeleteCar(){
		
		Car car1 = new Car(MODEL_1, ROK_1);
		Car car2 = new Car(MODEL_2, ROK_2);
		Car car3 = new Car(MODEL_3, ROK_3);
		
		carManager.clearCars();
		assertEquals(1, carManager.addCar(car1));
		assertEquals(1, carManager.addCar(car2));
		assertEquals(1, carManager.addCar(car3));
		assertEquals(1, carManager.addCar(car3));
		assertEquals(1, carManager.addCar(car3));
		
		assertEquals(1, carManager.deleteCar(car1));
		
		assertEquals(4, carManager.getAllCars().size());
		
		List<Car> cars = carManager.getAllCars();
		Car carRetrieved2 = cars.get(0);
		Car carRetrieved3 = cars.get(1);
		
		assertEquals(MODEL_2, carRetrieved2.getModel());
		assertEquals(ROK_2, carRetrieved2.getRok());	
		
		assertEquals(MODEL_3, carRetrieved3.getModel());
		assertEquals(ROK_3, carRetrieved3.getRok());
	}
	@Test
	public void checkDeleting(){
		
		Car car1 = new Car(MODEL_1, ROK_1);
		Car car2 = new Car(MODEL_2, ROK_2);
		Car car3 = new Car(MODEL_3, ROK_3);
		
		carManager.clearCars();
		assertEquals(1, carManager.addCar(car1));
		assertEquals(1, carManager.addCar(car2));
		assertEquals(1, carManager.addCar(car3));
		
		carManager.clearCars();
		
		assertEquals(0, carManager.getAllCars().size());
	}
	
	@Test
	public void checkSelectingByModel(){
		
		Car car1 = new Car(MODEL_1, ROK_1);
		Car car2 = new Car(MODEL_2, ROK_2);
		
		carManager.clearCars();
		assertEquals(1, carManager.addCar(car1));
		assertEquals(1, carManager.addCar(car2));
		assertEquals(1, carManager.addCar(car1));
		
		
		assertEquals(2, carManager.getCarsByModel(MODEL_1).size());
	}	

}
