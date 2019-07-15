package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: ParkingBoy
 * @projectName: ParkingLot-2019-7-11-13-35-0-378
 * @description: TODO
 * @author: macmanboy@foxmail.com(Gio Zhang)
 * @date: 2019/7/13 10:56
 */
public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    private final int INIT_PARKINGLOT_COUNT = 2;

    public ParkingBoy() {
        parkingLots = new ArrayList<>(0);
        for (int i = 0; i < INIT_PARKINGLOT_COUNT; i++) {
            parkingLots.add(new ParkingLot());
        }
    }

    public ParkingBoy(int parkingLotCount) {
        parkingLots = new ArrayList<>(0);
        for (int i = 0; i < parkingLotCount; i++) {
            parkingLots.add(new ParkingLot());
        }
    }
    public ParkingBoy(int parkingLotCount,int capacity) {
        parkingLots = new ArrayList<>(0);
        for (int i = 0; i < parkingLotCount; i++) {
            parkingLots.add(new ParkingLot(capacity+(i+1)*2));//simulate produces parking lots with different capacities
        }
    }
    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
    public Ticket park(Car car) throws Exception {
        if (isAllParkingLotFull()) {
            throw new Exception("Not enough position.");
        } else {
            ParkingLot parkingLot = parkingLots.stream()
                    .filter(e -> !(e.isCapacityFull()))
                    .collect(Collectors.toList()).get(0);
            return parkingLot.Park(car);
        }

    }

    public boolean isAllParkingLotFull() throws Exception {
        return this.parkingLots.stream().allMatch(e -> e.isCapacityFull());
    }

    public boolean isTicketInAnyOneParkingLot(Ticket ticket) {
        return this.parkingLots.stream().anyMatch(e -> e.getTicketCars().containsKey(ticket));
    }

    public Car fetch(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new NULLTicketException("Please provide your parking ticket.");
        } else {
            if (isTicketInAnyOneParkingLot(ticket)) {
                return parkingLots.stream()
                        .filter(e -> e.getTicketCars().containsKey(ticket))
                        .collect(Collectors.toList()).get(0).fetchCar(ticket);
            } else
                throw new UnlawfulTicketException("Your ticket is unlawful!");
        }
    }

}
