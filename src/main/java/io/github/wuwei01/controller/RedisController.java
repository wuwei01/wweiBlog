package io.github.wuwei01.controller;


import cn.hutool.json.JSONUtil;
import io.github.wuwei01.entity.NbaPlayer;
import io.github.wuwei01.service.NbaPlayerService;
import io.github.wuwei01.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private NbaPlayerService nbaPlayerService;

    @RequestMapping("setAndGet")
    public String test(String k,String v){
        redisUtils.set(k,v);
        return (String) redisUtils.get(k);
    }

    @RequestMapping("test")
    public Object test(){
        //step1 先从redis中取
        String strJson=(String) redisUtils.get("nbaPlayerCache");
        if (strJson==null){
            System.out.println("从db取值");
            // step2如果拿不到则从DB取值
            List<NbaPlayer> listNbaPlayer=nbaPlayerService.ListNbaPlayer();
            // step3 DB非空情况刷新redis值
            if (listNbaPlayer!=null){
                //redisUtils.set("nbaPlayerCache", JSON.toJSONString(listNbaPlayer));
                return listNbaPlayer;
            }
            return null;
        }else
        {
            System.out.println("从redis缓存取值");
            //return JSONObject.parseArray(strJson,NbaPlayer.class);
            return null;
        }
    }
}
