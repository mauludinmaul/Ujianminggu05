package com.juaracoding.ujianminggu05.hooks;


import com.juaracoding.ujianminggu05.DriverSingleton;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public void initialize() {
        DriverSingleton.createOrGetDriver();
    }

    @After
    public void finalTeardown() {
        DriverSingleton.quitDriver();
    }
}
