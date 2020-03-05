package com.rp.edu.designpattern.facade;

import lombok.Data;

/**
 *
 */
@Data
public class GiftPojo {
    private String name;

    public GiftPojo(String name) {
        this.name = name;
    }
}
