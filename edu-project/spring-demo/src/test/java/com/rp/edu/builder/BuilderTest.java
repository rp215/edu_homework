package com.rp.edu.builder;

import com.rp.edu.designpattern.builder.BuilderUtil;

/**
 * @功能描述：
 */
public class BuilderTest {
    public static void main(String[] args) {

        BuilderUtil build = new BuilderUtil();
        build.buildForJava();
        System.out.println("================================");
        build.buildForPython();

    }
}
