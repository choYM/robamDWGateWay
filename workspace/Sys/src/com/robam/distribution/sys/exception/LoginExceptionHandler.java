package com.robam.distribution.sys.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.digiwin.app.restful.handler.exception.DWExceptionHandler;

/**
 * DemoAP Exception Handler
 * @author falcon
 *
 */
public class LoginExceptionHandler extends DWExceptionHandler {

	private static Log log = LogFactory.getLog(LoginExceptionHandler.class);
	
	@Override
	public void handle(Exception e) throws Exception {

		LoginExceptionHandler.log.error("!!!DWLoginExceptionHandler handle exception...");
	}
}
