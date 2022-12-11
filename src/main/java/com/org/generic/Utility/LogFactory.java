package com.org.generic.Utility;

import org.apache.log4j.Logger;

public class LogFactory {

	private LogFactory() {

	}

	private static LogFactory logFactory;

	public static LogFactory getInstance() {

		return (logFactory == null) ? logFactory = new LogFactory() : logFactory;

	}

	ThreadLocal<Logger> logger = new ThreadLocal<Logger>();

	public void setLogger(Logger logParam) {
		logger.set(logParam);
	}

	public Logger getLogger() {
		return logger.get();
	}

	public void clearLogger() {
		logger.remove();

	}

}
