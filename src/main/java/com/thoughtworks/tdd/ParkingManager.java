package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: ParkingManager
 * @projectName: ParkingLot-2019-7-11-13-35-0-378
 * @description: TODO
 * @author: macmanboy@foxmail.com(Gio Zhang)
 * @date: 2019/7/13 16:44
 */
public class ParkingManager extends ParkingBoy {

  private List<ParkingBoy> parkingBoyList;
//  private List<ParkingLot> parkingLots;

  private final Integer PARKINGLOT_COUNT = 2;

  public ParkingManager() {
    super();
    parkingBoyList = new ArrayList<>(0);
//   for (int i=0;i<2;i++){
//     parkingLots.add(new ParkingLot())
//   }
  }

  public ParkingManager(List<ParkingBoy> parkingBoyList) {
    this.parkingBoyList = parkingBoyList;
  }

  public List<ParkingBoy> getParkingBoyList() {
    return parkingBoyList;
  }

  public void addParkBoy(ParkingBoy parkingBoy) {
    parkingBoyList.add(parkingBoy);
  }

//  @Override
//  public Ticket park(Car car) throws Exception {
//    if (isAllParkingLotFull()) {
//      throw new Exception("Not enough position.");
//    } else {
//      return parkingLot.Park(car);
//    }
//  }

//  @Override
//  public Car fetch(Ticket ticket) throws Exception {
//    return parkingLot.fetchCar(ticket);
//  }
}
