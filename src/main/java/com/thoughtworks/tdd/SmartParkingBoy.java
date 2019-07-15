package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @title: SmartParkingBoy
 * @projectName: ParkingLot-2019-7-11-13-35-0-378
 * @description: TODO
 * @author: macmanboy@foxmail.com(Gio Zhang)
 * @date: 2019/7/13 15:45
 */
public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {
        super();
    }

    public SmartParkingBoy(int parkingLotCount) {
        super(parkingLotCount);
    }
    public SmartParkingBoy(int parkingLotCount,int capacity) {
        super(parkingLotCount,capacity);
    }

    @Override
    public Ticket park(Car car) throws Exception {
        if (isAllParkingLotFull()) {
            throw new NotEnoughPositionException("Not enough position.");
        } else {
            ParkingLot parkingLot = getParkingLotWithMostPosition();
            return parkingLot.Park(car);
        }
    }

    private ParkingLot getParkingLotWithMostPosition() {
        return getParkingLots().stream()
                          .filter(e -> !(e.isCapacityFull()))
                          .sorted(Comparator.comparing(e->e.getTicketCars().size()))
                          .collect(Collectors.toList()).get(0);
    }


}
