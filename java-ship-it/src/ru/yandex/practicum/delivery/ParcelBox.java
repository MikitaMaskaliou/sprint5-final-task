package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox <T extends Parcel> {

    private int maxWeight = 50;
    private int remainWeight = maxWeight;
    public List<T> box = new ArrayList<>();

    public ParcelBox(int maxWeight){
        this.maxWeight = maxWeight;
    }
    public void addParcelIntoBox(T parcel){
            if (parcel.weight>remainWeight){
                System.out.println("Посылка не помещается, при добавлении превысится максимальный вес коробки");
                return;
            }
            box.add(parcel);
            remainWeight = maxWeight - parcel.weight;
    }

    void getAllParcels(){
        for (T parcel : box){
            System.out.println(parcel.toString());
        }
    }
}
