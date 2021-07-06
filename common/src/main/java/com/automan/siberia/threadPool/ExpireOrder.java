package com.automan.siberia.threadPool;

import java.util.logging.Logger;

/**
 * @Author: he.zhou
 * @Date: 2018-10-18
 */
public class ExpireOrder extends AbstractOrder {
    @Override
    protected String getAppId() {
        return null;
    }

    @Override
    protected String[] getSectionNameArray() {
        return new String[0];
    }

    @Override
    protected Logger getLogger() {
        return null;
    }
}
