package io.github.wuwei01;

import io.github.wuwei01.entity.MyAccount;
import io.github.wuwei01.entity.MyAccountTwo;
import io.github.wuwei01.service.AccountGroup;
import io.github.wuwei01.utils.ValidationUtil;
import org.junit.Test;

public class MyAccountTest {
    @Test
    public void test5() {
        MyAccountTwo account = new MyAccountTwo();
        account.setAlias("kalakala");
//      account.setUserName("wokalakala");
        account.setPassWord("密码");
        account.setBirthday("2019.12.1");
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(account);
        if (validResult.hasErrors()) {
            String properties = validResult.getProperties();
            System.out.println(properties);
        }
    }

    @Test
    public void test6() {
        MyAccountTwo account = new MyAccountTwo();
        account.setAlias("kalakala");
        account.setUserName("wokalakala");
        account.setPassWord("密码");
        account.setBirthday("2001.10.02");
        // 指定分组 AccountService.class
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(account, AccountGroup.class);
        if (validResult.hasErrors()) {
            String errors = validResult.getErrors();
            String properties = validResult.getProperties();
            System.out.println(errors);
            System.out.println(properties);
        }
    }
}
