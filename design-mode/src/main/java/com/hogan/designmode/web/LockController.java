package com.hogan.designmode.web;

import com.hogan.designmode.aspect.Log;
import com.yzw.mro.distributelock.constant.Constant;
import com.yzw.mro.distributelock.service.LockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 * wujun
 * 2019/12/16 18:10
 */

@RestController
@RequestMapping("/lock")
@Slf4j
public class LockController {

    @Autowired
    LockService lockService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/getLock")
    @Log
    public String getLock() {

        String value = lockService.getLock(Constant.DISTRIBUTE_LOCK_KEY, 5000L, TimeUnit.MILLISECONDS);
        System.out.println(value);
        lockService.unlock(Constant.DISTRIBUTE_LOCK_KEY, value);
        return value;
    }

    @GetMapping("/unLock")
    @Log
    public void unLock(@RequestParam String value) {

        lockService.unlock(Constant.DISTRIBUTE_LOCK_KEY, value);
    }

    @GetMapping("/rLock")
    @Log
    public void rLock() throws InterruptedException {

        try {
            lockService.lock("wujun", -1);
            log.info("加锁wujun成功");
            Thread.sleep(9000);
        } finally {
            lockService.unlock("wujun");
            log.info("释放锁wujun成功");
        }

    }
}
