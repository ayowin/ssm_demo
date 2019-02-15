package com.wz.test.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Test {

    public static Logger logger = (Logger) LogManager.getLogger(Test.class);

    public static void main(String[] args) {

	for(int i = 0; i < 1000; i++) {
	    logger.trace("trace level");
	    logger.debug("debug level");
	    logger.info("info level");
	    logger.warn("warn level");
	    logger.error("error level");
	    logger.fatal("fatal level");
	}

	Thread t1 = new Thread(new Runnable() {

	    public void run() {
		for(int i = 0; i<5 ; i++) {
		    logger.error("t1 error");
		}
	    }
	});
	t1.start();

	Thread t2 = new Thread(new Runnable() {

	    public void run() {
		for(int i = 0; i<5 ; i++) {
		    logger.error("t2 error");
		}
	    }
	});
	t2.start();

    }
}
