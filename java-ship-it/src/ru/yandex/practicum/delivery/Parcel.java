package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы

    protected String description;

    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;
    protected String packMessage = "Посылка " + description + " упакована";
    protected String deliverMessage = "Посылка " + description + " доставлена по адресу " + deliveryAddress;

    protected Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    protected abstract void packageItem();
    protected void deliver(){
        System.out.println(deliverMessage);
    }
    protected abstract int calculateDeliveryCost();

    @Override
    public String toString() {
        return "Посылка [" +
                "описание: " + description + '\'' +
                ", вес: " + weight +
                ']';
    }

}
