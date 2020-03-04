package com.rp.edu.proxy;

import com.rp.edu.designpattern.proxy.staticproxy.Gouzi;
import com.rp.edu.designpattern.proxy.staticproxy.GouziFather;

/**
 * @功能描述：
 */
public class StaticProxyTest {
    public static void main(String[] args) {

        GouziFather gouziFather = new GouziFather(new Gouzi());
        gouziFather.findLove();

    }
}
