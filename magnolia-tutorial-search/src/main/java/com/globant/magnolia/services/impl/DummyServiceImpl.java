package com.globant.magnolia.services.impl;

import com.globant.magnolia.services.DummyService;

public class DummyServiceImpl implements DummyService {

    @Override
    public String sayHello() {
        return "hello there!!";
    }

}
