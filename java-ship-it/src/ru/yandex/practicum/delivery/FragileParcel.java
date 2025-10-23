package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{

    private final int BASE_COST = 4;
    private String reportStatusMessage = "Хрупкая посылка " + description + "изменила местоположение на ";
    private String protectPackMessage = "Посылка " + description + " обёрнута в защитную плёнку";

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected void packageItem() {
        System.out.println(protectPackMessage);
        System.out.println(packMessage);
    }

    @Override
    public int getBaseCost() {
        return BASE_COST;
    }

    @Override
    public void reportStatus(String newLocation){
        System.out.println(reportStatusMessage + newLocation);
    }

}
