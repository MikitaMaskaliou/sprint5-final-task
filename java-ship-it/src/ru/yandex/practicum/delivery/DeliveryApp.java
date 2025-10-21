package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandartParcel> standartParcelParcelBox = new ParcelBox<>(50);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(30);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(20);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatuses();
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить посылки, поддерживающие трекинг");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        //***нужно ли делать через nextLine все параметры???
        System.out.println("какой тип посылки добавить? 1 - обычная, 2 - хрупкая, 3 - скоропортящаяся");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("укажите описание посылки");
        String description = scanner.next();
        System.out.println("укажите вес посылки");
        int weight = scanner.nextInt();
        System.out.println("укажите адрес доставки посылки");
        String deliveryAddress = scanner.next();
        System.out.println("укажите день отправления посылки. от 1 до 30");
        int sendDay = scanner.nextInt();
        switch (choice) {
            case 1:
                StandartParcel standardParcel = new StandartParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                System.out.println("Обычная посылка " + description + " успешно добавлена.");
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                System.out.println("Хрупкая посылка " + description + " успешно добавлена.");
                break;
            case 3:
                System.out.println("укажите 'срок годности до' посылки. от 1 до 30");
                int timeToLive = scanner.nextInt();
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                System.out.println("Скоропортящаяся посылка " + description + " успешно добавлена.");
                break;
            default:
                System.out.println("Неверный выбор. Указанный тип посылки отсутствует. Добавление невозможно.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        System.out.println("Посылки отправлены");
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int cost = 0;
        for (Parcel parcel : allParcels) {
            cost+=parcel.calculateDeliveryCost();
        }
        System.out.println("Стоимость доставки всех посылок: " + cost);
    }

    private static void reportStatuses() {
        for (FragileParcel fragileParcel : trackableParcels) {
            System.out.println("Введите новую локацию для посылки" + fragileParcel.description);
            String newLocation = scanner.next();
            fragileParcel.reportStatus(newLocation);
        }
    }

}

