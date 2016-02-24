package com.coderli.yami.common.init;

/**
 * 初始化器
 *
 * @author li.hzh
 * @date 16/2/22
 */
public interface Initializer extends Comparable {

    /**
     * 初始化
     */
    void init() throws Exception;


    /**
     * 获取优先级
     * 正整数,数量小,优先级越高
     *
     * @return
     */
    int getOrder();

}
