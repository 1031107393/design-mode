package com.hogan.designmode;

import com.hogan.designmode.factory.ChongQingFarm;
import com.hogan.designmode.factory.Farm;
import com.hogan.designmode.factory.entity.Animal;
import com.hogan.designmode.factory.entity.Fruit;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Farm farm = new ChongQingFarm();
        Animal cow = farm.produceAnimal();
        Fruit apple = farm.produceFruit();
        cow.show();
        apple.show();
    }
}
