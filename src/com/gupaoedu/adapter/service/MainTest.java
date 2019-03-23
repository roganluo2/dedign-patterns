package com.gupaoedu.adapter.service;

/**基于适配器设计一个可以变换供应商的短信发送接口
 * 系统原来接了一个平台，后来因为费用太高，或者送达率不高，需要更换
 * Created by 召君王 on 2019/3/24.
 */
public class MainTest {

    public static void main(String[] args) throws Exception{

        new MsgServiceImpl().sendVertifyCode("15877923742", "123456");

    }
}
