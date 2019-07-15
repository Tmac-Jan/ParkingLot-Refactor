package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SuperSmartParkingBoyTest {
@Test
  void should_park_car_in_paringLot_contains_more_capacityRate_firstLy_when_park_car()throws Exception{
    ParkingBoy parkingBoy = new SuperSmartParkingBoy(2,10);
    int i=0;
    while(i<4){
      parkingBoy.park(new Car());
      i++;
    }
    Assertions.assertEquals(2
        ,parkingBoy.getParkingLots().get(0).getTicketCars().size());
    Assertions.assertEquals(2
        ,parkingBoy.getParkingLots().get(1).getTicketCars().size());

  }
}