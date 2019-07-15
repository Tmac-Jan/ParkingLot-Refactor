package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @title: SuperSmartParkingBoy
 * @projectName: ParkingLot-2019-7-11-13-35-0-378
 * @description: TODO
 * @author: macmanboy@foxmail.com(Gio Zhang)
 * @date: 2019/7/13 16:21
 */
public class SuperSmartParkingBoy extends SmartParkingBoy {
    public SuperSmartParkingBoy() {
    }

    public SuperSmartParkingBoy(int parkingLotCount,int capacity) {
        super(parkingLotCount,capacity);
    }

    @Override
    public Ticket park(Car car) throws Exception {
        if (isAllParkingLotFull()) {
            throw new Exception("Not enough position.");
        } else {
            ParkingLot parkingLot = getParkingLots().stream()
                    .filter(e -> !(e.isCapacityFull()))
                    .sorted(Comparator.comparing(ParkingLot::getParkingLotPositionRate))
                    .collect(Collectors.toList()).get(0);
         getParkingLots().stream()
                .filter(e -> !(e.isCapacityFull()))
                .sorted(Comparator
                    .comparing(ParkingLot::getParkingLotPositionRate))
             .forEach(e->{
                 System.out.println("size:"+e.getTicketCars().size()+"name:"+e+" rate:"+e.getParkingLotPositionRate());
             });
            return parkingLot.Park(car);
        }
    }
}
