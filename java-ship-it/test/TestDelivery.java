import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandartParcel;


public class TestDelivery {
    @Test
    public void standartParcelDeliverPriceCheck(){
        StandartParcel standartParcel = new StandartParcel("кирпич",  5,"Кудыкина гора", 13);
        int realCost = standartParcel.calculateDeliveryCost();
        assertEquals(10, realCost);
    }

    @Test
    public void fragileParcelDeliverPriceCheck(){
        FragileParcel fragileParcel = new FragileParcel("карточные домики", 1, "цирк 'du Soleil'", 7);
        int realCost = fragileParcel.calculateDeliveryCost();
        assertEquals(4, realCost);
    }

    @Test
    public void perishableParcelDeliverPriceCheck(){
        PerishableParcel perishableParcel = new PerishableParcel("пакетик молока", 2, "г Москва, Нахимовский пр. д 14стр2, кв118", 21, 24);
        int realCost = perishableParcel.calculateDeliveryCost();
        assertEquals(6, realCost);
    }

    @Test
    public void isExpiredMethodCheckIfTrue(){
        PerishableParcel perishableParcel = new PerishableParcel("пакетик молока", 2, "г Москва, Нахимовский пр. д 14стр2, кв118", 21, 24);
        assertTrue(perishableParcel.isExpired(26));
    }

    @Test
    public void isExpiredMethodCheckIfFalse(){
        PerishableParcel perishableParcel = new PerishableParcel("пакетик молока", 2, "г Москва, Нахимовский пр. д 14стр2, кв118", 21, 24);
        assertFalse(perishableParcel.isExpired(22));
    }


    @Test
    public void addParcelIntoBoxMethodOverloadCheck(){
        StandartParcel standartParcel1 = new StandartParcel("кувалда",  25,"Кудыкина гора", 13);
        StandartParcel standartParcel2 = new StandartParcel("мешок песка",  50,"Кудыкина гора", 13);
        ParcelBox<StandartParcel> standartParcelParcelBox = new ParcelBox<>(50);
        standartParcelParcelBox.addParcelIntoBox(standartParcel1);
        standartParcelParcelBox.addParcelIntoBox(standartParcel2);
        assertEquals(1, standartParcelParcelBox.box.size());
    }

    @Test
    public void addParcelIntoBoxMethodTightPackCheck(){
        StandartParcel standartParcel1 = new StandartParcel("кувалда",  25,"Кудыкина гора", 13);
        StandartParcel standartParcel2 = new StandartParcel("полмешка песка",  25,"Кудыкина гора", 13);
        ParcelBox<StandartParcel> standartParcelParcelBox = new ParcelBox<>(50);
        standartParcelParcelBox.addParcelIntoBox(standartParcel1);
        standartParcelParcelBox.addParcelIntoBox(standartParcel2);
        assertEquals(2, standartParcelParcelBox.box.size());
    }

    @Test
    public void addParcelIntoBoxMethodManyParcelsCheck(){
        StandartParcel standartParcel1 = new StandartParcel("игрушечная кувалда",  1,"Кудыкина гора", 13);
        StandartParcel standartParcel2 = new StandartParcel("наполнитель лотка",  3,"Кудыкина гора", 13);
        ParcelBox<StandartParcel> standartParcelParcelBox = new ParcelBox<>(50);
        standartParcelParcelBox.addParcelIntoBox(standartParcel1);
        standartParcelParcelBox.addParcelIntoBox(standartParcel2);
        standartParcelParcelBox.addParcelIntoBox(standartParcel1);
        standartParcelParcelBox.addParcelIntoBox(standartParcel2);
        standartParcelParcelBox.addParcelIntoBox(standartParcel1);
        standartParcelParcelBox.addParcelIntoBox(standartParcel2);
        standartParcelParcelBox.addParcelIntoBox(standartParcel1);
        standartParcelParcelBox.addParcelIntoBox(standartParcel2);
        assertEquals(8, standartParcelParcelBox.box.size());
    }
}
