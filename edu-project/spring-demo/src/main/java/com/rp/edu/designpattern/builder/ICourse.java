package com.rp.edu.designpattern.builder;

/**
 * @功能描述：
 */
public interface ICourse {
    ICourse addPpt();

    ICourse addVideo();

    ICourse addNote();
}
