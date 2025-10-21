package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {

    private final int baseCost = 3;
    int timeToLive;

    protected PerishableParcel (String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        if ((timeToLive>=currentDay) || (timeToLive>=currentDay)) {
            return false;
        }
        return true;
    }

    @Override
    protected void packageItem() {
        System.out.println(packMessage);
    }

    @Override
    protected int calculateDeliveryCost() {
        return baseCost*weight;
    }

}
