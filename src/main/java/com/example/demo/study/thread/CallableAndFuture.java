package com.example.demo.study.thread;

import com.example.demo.model.bo.PeopleTypeQueryBO;
import com.example.demo.model.vo.UserInfoVO;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author didi
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setName("zhuxu");
        Callable<UserInfoVO> callable = new Callable<UserInfoVO>() {
            @Override
            public UserInfoVO call() {

                userInfoVO.setAccount("zhuluxu");
                userInfoVO.setDept("基础平台部");
                userInfoVO.setName("朱路旭");
                return userInfoVO;
//                return new Random().nextInt(100);
            }
        };
        FutureTask<UserInfoVO> future = new FutureTask<>(callable);
        System.out.println(userInfoVO.toString());
        new Thread(future).start();
        System.out.println(userInfoVO.toString());
        try {
            // 可能做一些事情

            System.out.println(userInfoVO.toString());
            Thread.sleep(5000);
            System.out.println(future.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(userInfoVO.toString());
    }
}
