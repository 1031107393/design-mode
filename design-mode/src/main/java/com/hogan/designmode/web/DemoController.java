package com.hogan.designmode.web;

import com.hogan.designmode.aspect.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试端点
 * wujun
 * 2019/12/09 14:30
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/echo")
    @Log
    public String echo(@RequestParam String param) {
        return param;
    }
}
