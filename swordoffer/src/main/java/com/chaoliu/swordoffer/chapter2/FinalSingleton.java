package com.chaoliu.swordoffer.chapter2;

// todo 2 实现singleton模式
public class FinalSingleton {

    private FinalSingleton() {
    }

    public static FinalSingleton getInstance() {
        return SingletonHold.hold;
    }

    private static class SingletonHold {
        static final FinalSingleton hold = new FinalSingleton();
    }

}
