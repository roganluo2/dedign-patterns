package com.gupaoedu.proxy.jdk;

/**
 * Created by 召君王 on 2019/3/15.
 */
public class ClueServiceImpl implements IClueService {


    /**
     * 我们常常想在方法调用前，和方法调用后打一些日志，方便线上出现业务问题定位
     * @param clue
     * @param userId
     * @return
     */
    @Override
    public int modify(Clue clue, Integer userId) {
        System.out.println("调用数据库修改clue信息");
        return 0;
    }
}
