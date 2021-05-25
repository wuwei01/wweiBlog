package io.github.wuwei01.controller;

import io.github.wuwei01.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName：TestController
 * @Description：Redis控制器
 * @Author：wuwei
 * @Date：2021年5月25日20:35:09
 * @Versiion：1.0
 */
@RestController
public class RedisController {
    @Autowired
    private RedisUtils redisUtils;
    @RequestMapping("setAndGet")
    public String test(String k,String v){
        redisUtils.set(k,v);
        return (String) redisUtils.get(k);
    }
}
