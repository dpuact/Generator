package com.bijw.generator.common;

import com.bijw.generator.common.utils.JwtHelper;
import com.bijw.generator.entity.DemoUser;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2022-12-05 11:27
 */
@Slf4j
@RestController
@RequestMapping("/")
public class Demo {
    public static void main(String[] args) {
        log.info("");
        log.debug("");
    }

//    public Object test(){
//        return Result.success("",1);
//    }

    @Autowired
    private TransactionTemplate transactionTemplate;
    public void testTransaction() {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

                try {

                    // ....  业务代码
                } catch (Exception e){
                    //回滚
                    transactionStatus.setRollbackOnly();
                }

            }
        });
    }


    @Test
    public void test(){
        DemoUser user = new DemoUser();
        user.setId(123L);
        user.setAge(18);
        user.setName("aa");
        String token = JwtHelper.creatToken(user);
        System.out.println(token);
        Claims claims = JwtHelper.getUserClaims(token);
        System.out.println(claims);
    }

}
