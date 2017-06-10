package com.xgy.thrift;

/**
 * Created by root on 16-11-1.
 */


import org.apache.thrift.TException;


public class ThriftServiceImpl implements ThriftService.Iface {
    @Override
    public int add(int a, int b) throws TException {
        return a + b;
    }
}


