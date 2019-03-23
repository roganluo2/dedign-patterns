package com.gupaoedu.adapter.msg.yunpian;

import com.gupaoedu.adapter.msg.Sender;

/**
 * Created by 召君王 on 2019/3/23.
 */
@Sender(name = "yunpian")
public class YunpianMsgSender {


    public boolean push(String phone, String code)
    {
        System.out.println("启动云片的通道发送短信");
        System.out.println("phone:"+ phone +"您的验证码是,code" + code);
        return true;
    }


}
