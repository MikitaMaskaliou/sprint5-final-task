package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{

    private final int baseCost = 4;
    private String reportStatusMessage = "Хрупкая посылка " + description + "изменила местоположение на ";
    private String protectPackMessage = "Посылка " + description + " обёрнута в защитную плёнку";

    protected FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected void packageItem() {
        System.out.println(protectPackMessage);
        System.out.println(packMessage);
    }

    @Override
    protected int calculateDeliveryCost() {
        return baseCost*weight;
    }

    @Override
    public void reportStatus(String newLocation){
        System.out.println(reportStatusMessage + newLocation);
    }

}
