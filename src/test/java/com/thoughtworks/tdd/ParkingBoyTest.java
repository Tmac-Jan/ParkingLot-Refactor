package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * @title: ParkingBoyTest
 * @projectName: ParkingLot-2019-7-11-13-35-0-378
 * @description: TODO
 * @author: macmanboy@foxmail.com(Gio Zhang)
 * @date: 2019/7/13 11:07
 */
class ParkingBoyTest {

    @Test
    public void should_return_car_when_park_car_and_fetch_it_by_ticket()throws Exception{
        Car actualCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.park(actualCar);
        Car expectedCar = parkingBoy.fetch(ticket);
        Assertions.assertEquals(actualCar,expectedCar);
    }
    @Test void should_return_correct_car_when_parks_cars_and_fecth_it_by_ticket()throws Exception{
        Car actualFirstCar = new Car();
        Car actualSecondCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket firstTicket = parkingBoy.park(actualFirstCar);
        Ticket secondTicket = parkingBoy.park(actualSecondCar);
        Car expectedFirstCar = parkingBoy.fetch(firstTicket);
        Car expectedSecondCar = parkingBoy.fetch(secondTicket);
        Assertions.assertEquals(actualFirstCar,expectedFirstCar);
        Assertions.assertEquals(actualSecondCar,expectedSecondCar);
    }
    @Test void should_get_exception_when_give_wrong_ticket()throws Exception{
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket wrongTicket = new Ticket();
        parkingBoy.park(car);
        Assertions.assertThrows(UnlawfulTicketException.class,()->{
            parkingBoy.fetch(wrongTicket);
        });
    }
    @Test void should_get_exception_when_give_ticket_has_been_used()throws Exception{
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket actualTicket = parkingBoy.park(car);//Not Used
        parkingBoy.fetch(actualTicket);
        Assertions.assertThrows(UnlawfulTicketException.class,()->{
            parkingBoy.fetch(actualTicket);
        });
    }
    @Test void should_get_exception_when_fetch_car_and_parkingLot_capacity_is_full()throws Exception{
        ParkingBoy parkingBoy = new ParkingBoy();
        Assertions.assertThrows(Exception.class,()->{
           while (1==1){
               parkingBoy.park(new Car());
           }
        });
    }
    @Test void should_get_exception_when_fetch_car_has_been_parked()throws Exception{
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.park(car);
        Assertions.assertThrows(Exception.class,()->{
            parkingBoy.park(car);
        });
    }
    @Test void should_get_exception_when_park_car_is_null()throws Exception{
        ParkingBoy parkingBoy = new ParkingBoy();
        Assertions.assertThrows(Exception.class,()->{
            parkingBoy.park(null);
        });
    }
    @Test void should_get_exception_show_message_when_fetch_car_by_wrong_ticket()throws Exception{
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
            parkingBoy.park(car);

        Ticket wrongTicket = new Ticket();
            try {
                parkingBoy.fetch(wrongTicket);
            }catch (UnlawfulTicketException ex){
                System.out.println(ex.getMessage());
                Assertions.assertEquals("Your ticket is unlawful!",ex.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    @Test void should_get_exception_show_message_when_fetch_car_by_used_ticket()throws Exception{
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket =parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        try {
            parkingBoy.fetch(ticket);
        }catch (UnlawfulTicketException ex){
            System.out.println(ex.getMessage());
            Assertions.assertEquals("Your ticket is unlawful!",ex.getMessage());
        }
    }
    @Test void should_get_exception_show_message_when_fetch_car_by_null_ticket()throws Exception{
        ParkingBoy parkingBoy = new ParkingBoy();
        try {
            parkingBoy.fetch(null);
        }catch (NULLTicketException ex){
            System.out.println(ex.getMessage());
            Assertions.assertEquals("Please provide your parking ticket.",ex.getMessage());
        }
    }
    @Test void should_get_exception_show_message_when_park_car_in_parkingLot_and_capacity_is_full()throws Exception{
        ParkingBoy parkingBoy = new ParkingBoy();
        try {
          while(1==1){
              parkingBoy.park(new Car());
          }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            Assertions.assertEquals("Not enough position.",ex.getMessage());
        }
    }
    @Test void should_park_car_in_paringLot_contains_more_capacity_firstLy_when_park_car()throws Exception{
        ParkingBoy parkingBoy = new SmartParkingBoy(2);
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        Assertions.assertEquals(parkingBoy.getParkingLots().get(0).getTicketCars().size()
                ,parkingBoy.getParkingLots().get(1).getTicketCars().size());
    }



}