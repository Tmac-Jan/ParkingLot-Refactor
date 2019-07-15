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


  private final Integer PARKINGLOT_COUNT = 2;

  public ParkingManager() {
    super();
    parkingBoyList = new ArrayList<>(0);
  }

  public List<ParkingBoy> getParkingBoyList() {
    return parkingBoyList;
  }

  public void addParkBoy(ParkingBoy parkingBoy) {
    parkingBoyList.add(parkingBoy);
  }

}
