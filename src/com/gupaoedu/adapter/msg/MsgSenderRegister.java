package com.gupaoedu.adapter.msg;

import com.gupaoedu.adapter.msg.ali.AliMsgAdapter;
import com.gupaoedu.adapter.msg.ali.AliMsgSender;
import com.gupaoedu.adapter.msg.wangyi.WangyiAdapter;
import com.gupaoedu.adapter.msg.wangyi.WangyiyunMsg;
import com.gupaoedu.adapter.msg.yunpian.YunpianAdapter;
import com.gupaoedu.adapter.msg.yunpian.YunpianMsgSender;

import java.util.*;

/**
 * Created by 召君王 on 2019/3/24.
 */
public class MsgSenderRegister {

    /**
     * 注册短信发送平台
     */
    private List<Class> senders = new ArrayList<>();

    /**
     * 注册适配器
     */
    private List< MsgAdapter> adapters = new ArrayList<>();

    public List<MsgAdapter> getAdapters() {
        return adapters;
    }

    /**
     * 只能在构造方法中注册短信发送平台，如果哪一家不用了，直接删除就可以了
     */
    private MsgSenderRegister(){
        senders.add( AliMsgSender.class);
        senders.add( YunpianMsgSender.class);
        senders.add(WangyiyunMsg.class);
        Collections.unmodifiableList(senders);
        initAdapters();
    }

    public static synchronized MsgSenderRegister getInstance(){
        return  new MsgSenderRegister();
    }

    public List<Class> getSenders() {
        return senders;
    }

    private void initAdapters()
    {
        adapters.add(new AliMsgAdapter());
        adapters.add(new YunpianAdapter());
        adapters.add(new WangyiAdapter());
        Collections.unmodifiableList(adapters);
    }
}
