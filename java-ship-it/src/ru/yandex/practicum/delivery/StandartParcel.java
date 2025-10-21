package ru.yandex.practicum.delivery;

public class StandartParcel extends Parcel {

    private final int baseCost = 2;

    protected StandartParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
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
