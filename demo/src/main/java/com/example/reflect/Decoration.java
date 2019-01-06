package com.example.reflect;

interface Logger {
    public void writeLog();
}

class BaseLogger implements Logger {
    public void writeLog(){
        System.out.println("writeLog");
    }
}

class DecorationLogger implements Logger{
    private Logger logger;
    DecorationLogger(Logger logger){
        this.logger = logger;
    }
    @Override
    public void writeLog(){
        logger.writeLog();
        System.out.println("Decoration");
    }
}

class DecorationLogger2 implements Logger{
    private Logger logger;
    DecorationLogger2(Logger logger){
        this.logger = logger;
    }
    @Override
    public void writeLog(){
        logger.writeLog();
        System.out.println("Decoration2");
    }
}

/**
 * the core of Decoration design pattern is strengthen
 * @author yangZhen
 *
 */
public class Decoration {
    public static void main(String []argvs){
        Logger logger = new DecorationLogger2(new DecorationLogger(new BaseLogger()));
        logger.writeLog();

        Logger logger1 = new DecorationLogger(new DecorationLogger2(new BaseLogger()));
        logger1.writeLog();

        Logger logger2 = new DecorationLogger(new BaseLogger());
        logger2.writeLog();
    }
}