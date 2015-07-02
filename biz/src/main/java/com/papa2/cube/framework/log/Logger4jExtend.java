package com.papa2.cube.framework.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Logger4jExtend.
 * 
 * @author xujiakun
 * 
 */
public class Logger4jExtend {

	private Logger logger;

	public Logger4jExtend() {
		super();
	}

	public Logger4jExtend(String clazzName) {
		super();
		logger = LogManager.getLogger(clazzName);
	}

	public void info(Object message) {
		logger.info(message);
	}

	public void info(Object message, Throwable e) {
		logger.info(message, e);
	}

	public void warn(Object message) {
		logger.warn(message);
	}

	public void warn(Object message, Throwable e) {
		logger.warn(message, e);
	}

	public void debug(Object message) {
		logger.debug(message);
	}

	public void debug(Object message, Throwable e) {
		logger.debug(message, e);
	}

	public void error(Object message) {
		logger.error(message);
	}

	public void error(Object message, Throwable e) {
		logger.error(message, e);
	}

}
