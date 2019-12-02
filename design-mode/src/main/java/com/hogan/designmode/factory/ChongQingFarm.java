package com.hogan.designmode.factory;

import com.hogan.designmode.factory.entity.Animal;
import com.hogan.designmode.factory.entity.Apple;
import com.hogan.designmode.factory.entity.Cow;
import com.hogan.designmode.factory.entity.Fruit;
import lombok.extern.slf4j.Slf4j;

/**
 * 重庆农场
 * 生产牛和苹果
 * wujun
 * 2019/12/02 11:17
 */
@Slf4j
public class ChongQingFarm implements Farm {

    @Override
    public Animal produceAnimal() {
        log.warn("{}生产牛", this.getClass().getSimpleName());
        return new Cow();
    }

    @Override
    public Fruit produceFruit() {
        log.warn("{}生产苹果", this.getClass().getSimpleName());
        return new Apple();
    }
}
