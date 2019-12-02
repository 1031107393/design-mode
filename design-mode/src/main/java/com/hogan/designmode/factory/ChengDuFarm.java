package com.hogan.designmode.factory;

import com.hogan.designmode.factory.entity.Animal;
import com.hogan.designmode.factory.entity.Fruit;
import com.hogan.designmode.factory.entity.Horse;
import com.hogan.designmode.factory.entity.Pear;
import lombok.extern.slf4j.Slf4j;

/**
 * 成都农场
 * 生产马和梨
 * wujun
 * 2019/12/02 11:20
 */
@Slf4j
public class ChengDuFarm implements Farm {

    @Override
    public Animal produceAnimal() {
        log.warn("{}生产马", this.getClass().getSimpleName());
        return new Horse();
    }

    @Override
    public Fruit produceFruit() {
        log.warn("{}生产梨", this.getClass().getSimpleName());
        return new Pear();
    }
}
