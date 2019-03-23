package com.gupaoedu.adapter.msg.wangyi;

import com.gupaoedu.adapter.msg.MsgAdapter;
import com.gupaoedu.adapter.msg.MsgSender;

/**
 * Created by 召君王 on 2019/3/24.
 */
public class WangyiAdapter implements MsgAdapter {
    @Override
    public boolean supports(Object company) {
        return MsgSender.class.isAssignableFrom(company.getClass());
    }

    @Override
    public boolean send(String phone, String code, Object company) throws Exception {
        WangyiyunMsg msg = (WangyiyunMsg) company;
        return msg.send(phone, code);
    }
}
