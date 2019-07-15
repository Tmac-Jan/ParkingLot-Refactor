package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingManagerTest {
  @Test
  void should_get_exception_show_message_when_fetch_car_by_used_ticket_and_by_ParkingManger_specify_ParkingBoy()throws Exception{
    Car car = new Car();
    ParkingManager parkingManager = new ParkingManager();
    int i=0;
    while(i<2){
      parkingManager.addParkBoy(new ParkingBoy());
      i++;
    }
    ParkingBoy parkingBoy =parkingManager.getParkingBoyList().get(0);
    Ticket ticket =parkingBoy.park(car);
    parkingBoy.fetch(ticket);
    try {
      parkingBoy.fetch(ticket);
    }catch (NULLTicketException ex){
      System.out.println(ex.getMessage());
      Assertions.assertEquals("Your ticket is unlawful!",ex.getMessage());
    }
  }
  @Test void should_get_exception_show_message_when_fetch_car_by_null_ticket_and_by_ParkingManger_specify_ParkingBoy()throws Exception{
    ParkingManager parkingManager = new ParkingManager();
    int i=0;
    while(i<2){
      parkingManager.addParkBoy(new ParkingBoy());
      i++;
    }
    ParkingBoy parkingBoy =parkingManager.getParkingBoyList().get(0);
    try {
      parkingBoy.fetch(null);
    }catch (Exception ex){
      System.out.println(ex.getMessage());
      Assertions.assertEquals("Please provide your parking ticket.",ex.getMessage());
    }
  }
  @Test void should_get_exception_show_message_when_park_car_in_parkingLot_and_capacity_is_full_and_by_ParkingManger_specify_ParkingBoy()throws Exception{
    ParkingManager parkingManager = new ParkingManager();
    int i=0;
    while(i<2){
      parkingManager.addParkBoy(new ParkingBoy());
      i++;
    }
    ParkingBoy parkingBoy =parkingManager.getParkingBoyList().get(0);
    try {
      while(1==1){
        parkingBoy.park(new Car());
      }
    }catch (Exception ex){
      System.out.println(ex.getMessage());
      Assertions.assertEquals("Not enough position.",ex.getMessage());
    }
  }
  @Test void should_add_parkingBoy_into_paringLot_when_operator_is_manager()throws Exception{
    ParkingManager parkingManager = new ParkingManager();
    int i=0;
    while(i<4){
      parkingManager.addParkBoy(new ParkingBoy());
      i++;
    }
    Assertions.assertEquals(4
        ,parkingManager.getParkingBoyList().size());
  }
  @Test void should_park_car_by_paringBoy_specified_by_parkingManager_when_give_car()throws Exception{
    ParkingManager parkingManager = new ParkingManager();
    int i=0;
    while(i<4){
      parkingManager.addParkBoy(new ParkingBoy());
      i++;
    }
    Car expectedCar = new Car();
    Ticket ticket = parkingManager.getParkingBoyList().get(0).park(expectedCar);
    Car actualCarBySameParingBoy = parkingManager.getParkingBoyList().get(0).fetch(ticket);
    Assertions.assertEquals(expectedCar
        ,actualCarBySameParingBoy);
  }
  @Test void  should_park_car_by_parkingManager_when_give_car()throws Exception{
    ParkingManager parkingManager = new ParkingManager();
    Car expectedCar = new Car();
    Ticket ticket = parkingManager.park(expectedCar);
    Car actualCar = parkingManager.fetch(ticket);
    Assertions.assertEquals(expectedCar,actualCar);
  }
  @Test void should_get_exception_show_message_when_fetch_car_by_wrong_ticket_and_by_ParkingManger_specify_ParkingBoy()throws Exception{
    Car car = new Car();
    ParkingManager parkingManager = new ParkingManager();
    int i=0;
    while(i<2){
      parkingManager.addParkBoy(new ParkingBoy());
      i++;
    }
    ParkingBoy parkingBoy =parkingManager.getParkingBoyList().get(0);
    parkingBoy.park(car);
    Ticket wrongTicket = new Ticket();
    try {
      parkingBoy.fetch(wrongTicket);
    }catch (Exception ex){
      System.out.println(ex.getMessage());
      Assertions.assertEquals("Your ticket is unlawful!",ex.getMessage());
    }

  }
}
