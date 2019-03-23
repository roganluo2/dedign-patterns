package com.gupaoedu.adapter.msg;

/**
 * 基于适配器设计一个可以变换供应商的短信发送接口
 * Created by 召君王 on 2019/3/23.
 */
public interface MsgAdapter {

    /**
     * 判断是否匹配
     * @param company 供应商
     * @return
     */
    boolean supports(Object company);

    /**
     * 执行发送
     * @param phone
     * @param code
     * @param company
     * @return 返回发送结果，是否发送成功
     * @throws Exception
     */
    boolean send(String phone, String code, Object company) throws Exception;

}
