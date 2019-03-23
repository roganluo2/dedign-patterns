package com.gupaoedu.adapter.msg.yunpian;

import com.gupaoedu.adapter.msg.MsgAdapter;
import com.gupaoedu.adapter.msg.Sender;

/**
 * Created by 召君王 on 2019/3/24.
 */
public class YunpianAdapter implements MsgAdapter {

    @Override
    public boolean supports(Object company) {
        Sender annotation = company.getClass().getAnnotation(Sender.class);
        return annotation != null && annotation.name().equals("yunpian");
    }

    @Override
    public boolean send(String phone, String code, Object company) throws Exception {
        YunpianMsgSender sender = (YunpianMsgSender) company;
        return sender.push(phone, code);
    }
}
