package com.utils;

import java.lang.invoke.MethodHandles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Log {
	
	private Log() {}
	
    private static final Logger log =  LogManager.getLogger(MethodHandles.lookup().lookupClass());
    
    /**
	 * Report status as info with message in log file.
	 * @param message -> The message which needs to log.
	 */
	public static void info(String message) {
		log.info(message);
	}

	/**
	 * Report status as fail with message in report and log file.<br>
	 * @param Message which need to log.
	 */
	public static void fail(String message) {
		log.error(message);
	}
	
	/**
	 * Report status as fail with stack trace message in log file.
	 * @param message -> report the message in log file.
	 */
	public static void fail(Throwable message) {
		log.error(message);
	}

	/**
	 * Report status as skip with message in log file.
	 * @param Message which need to log.
	 */
	public static void skip(String message) {
		log.error(message);
	}
	
	/**
	 * Report status as skip in log file.
	 * @param Exception which need to log.
	 */
	public static void skip(Throwable message) {
		log.error(message);
	}
	
	/**
	 * Report status as info with message in log file.
	 * @param message -> The message which needs to log.
	 */
	public static void logInfo(String message) {
		log.info(message);
	}
	
}
