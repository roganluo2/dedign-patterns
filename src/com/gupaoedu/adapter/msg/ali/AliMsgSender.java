package com.gupaoedu.adapter.msg.ali;

import com.gupaoedu.adapter.msg.Sender;

/**
 * 启动阿里云的通道发送短信
 * Created by 召君王 on 2019/3/23.
 */
@Sender(name = "aLi")
public class AliMsgSender {

    public boolean send(String phone, String code)
    {
        System.out.println("启动阿里云的通道发送短信");
        System.out.println("phone:"+ phone +"您的验证码是,code" + code);
        return true;
    }


}
