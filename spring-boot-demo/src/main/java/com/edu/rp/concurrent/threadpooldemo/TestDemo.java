package com.edu.rp.concurrent.threadpooldemo;

import org.springframework.stereotype.Component;

/**
 * @功能描述：
 */
@Component
public class TestDemo implements TestDemoImpl{

    @Override
    public int print() {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            j = i;
        }
        return j;
    }
}
