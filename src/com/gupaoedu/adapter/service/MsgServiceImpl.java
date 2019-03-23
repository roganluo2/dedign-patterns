package com.gupaoedu.adapter.service;

import com.gupaoedu.adapter.msg.MsgAdapter;
import com.gupaoedu.adapter.msg.MsgSenderRegister;

import java.util.List;
import java.util.Random;

/**
 * Created by 召君王 on 2019/3/23.
 */
public class MsgServiceImpl {


    public int sendVertifyCode(String phone, String code) throws Exception {
        List<Class> senders = MsgSenderRegister.getInstance().getSenders();
        Random random = new Random();
        int i = random.nextInt(senders.size());
        Class aClass = senders.get(i);
        Object o = aClass.newInstance();
        getMsgAdapter(o).send(phone, code, o);
        return 1;
    }

    private MsgAdapter getMsgAdapter(Object o) {
        List<MsgAdapter> adapters = MsgSenderRegister.getInstance().getAdapters();
//        return adapters.stream().filter(e -> e.supports(0)).findFirst().orElse(new AliMsgAdapter());
        for(MsgAdapter adapter : adapters)
        {
            if(adapter.supports(o))
            {
                return adapter;
            }
        }
        return null;
    }
}
