package com.hogan.designmode.factory;

import com.hogan.designmode.factory.entity.Animal;
import com.hogan.designmode.factory.entity.Fruit;

/**
 * 农场抽象接口
 * wujun
 * 2019/12/02 11:00
 */
public interface Farm {

    Animal produceAnimal();

    Fruit produceFruit();
}
