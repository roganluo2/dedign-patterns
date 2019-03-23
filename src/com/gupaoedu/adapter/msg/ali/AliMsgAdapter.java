package com.gupaoedu.adapter.msg.ali;

import com.gupaoedu.adapter.msg.MsgAdapter;
import com.gupaoedu.adapter.msg.Sender;

/**
 * Created by 召君王 on 2019/3/24.
 */
public class AliMsgAdapter implements MsgAdapter {
    @Override
    public boolean supports(Object company) {
        Sender annotation = company.getClass().getAnnotation(Sender.class);
        return annotation != null && annotation.name().equals("aLi");
    }

    @Override
    public boolean send(String phone, String code, Object company) throws Exception {
        AliMsgSender sender = (AliMsgSender) company;
        return sender.send(phone, code);
    }
}
