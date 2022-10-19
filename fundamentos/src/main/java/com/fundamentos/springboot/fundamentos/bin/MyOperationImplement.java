package com.fundamentos.springboot.fundamentos.bin;

public class MyOperationImplement implements  MyOperation{

    @Override
    public int suma(int num) {
        return num + 2 + num;
    }
}
