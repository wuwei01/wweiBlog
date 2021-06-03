package io.github.wuwei01.controller;

import io.github.wuwei01.entity.MyAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class MyAccountController {
    @PostMapping("/mytest")
    @ResponseBody
    public Object myTest(@RequestBody @Valid MyAccount account) {
        return account;
    }
}
