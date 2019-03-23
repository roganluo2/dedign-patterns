package com.gupaoedu.adapter.msg.wangyi;


import com.gupaoedu.adapter.msg.MsgSender;

/**
 * Created by 召君王 on 2019/3/23.
 */
public class WangyiyunMsg implements MsgSender {


    @Override
    public boolean send(String phone, String code) {
        System.out.println("启动网易云的通道发送短信");
        System.out.println("phone:"+ phone +"您的验证码是,code" + code);
        return true;
    }
}
