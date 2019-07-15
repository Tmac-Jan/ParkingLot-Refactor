package com.thoughtworks.tdd;

import java.util.LinkedHashMap;

/**
 * @title: ParkingLot
 * @projectName: ParkingLot-2019-7-11-13-35-0-378
 * @description: TODO
 * @author: macmanboy@foxmail.com(Gio Zhang)
 * @date: 2019/7/13 10:56
 */
public class ParkingLot {
    private Integer capacity;
    private LinkedHashMap<Ticket, Car> ticketCars;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        this.ticketCars = new LinkedHashMap<>(0);
    }
    public ParkingLot(){
        this.capacity=10;
        this.ticketCars = new LinkedHashMap<>(0);
    }
    public LinkedHashMap<Ticket, Car> getTicketCars() {
        return ticketCars;
    }

    public Car fetchCar(Ticket ticket)throws TicketUnlawfulException{
        if (isTicketLegal(ticket)){
            return  ticketCars.remove(ticket);
        }
       else throw new TicketUnlawfulException("Your ticket is unlawful!");
    }
    public boolean isTicketLegal(Ticket ticket){
        return this.ticketCars.containsKey(ticket)?true:false;
    }

    public Ticket Park(Car car)throws Exception{
        if (this.isCapacityFull()||car==null){
            throw new Exception();
        }else{
            if (ticketCars.containsValue(car)){
                throw new Exception();
            }
            Ticket ticket = new Ticket();
            ticketCars.put(ticket,car);
            return  ticket;
        }

    }
    public boolean isCapacityFull(){
        return ticketCars.size()>=this.capacity;
    }

    public double getParkingLotPositionRate(){
        return  this.getTicketCars().size()/this.capacity.doubleValue();
    }
}
