package com.coderli.yami.common.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author li.hzh
 * @date 16/2/24
 */
public abstract class AbstractInitializer implements Initializer {

    private static Logger logger = LoggerFactory.getLogger(AbstractInitializer.class);

    @Override
    public int compareTo(Object o) {
        Initializer target = (Initializer) o;
        return this.getOrder() - target.getOrder();
    }
}
