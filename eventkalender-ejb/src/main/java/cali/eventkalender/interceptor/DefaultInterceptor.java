package cali.eventkalender.interceptor;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
public class DefaultInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultInterceptor.class);

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		Object ctxTarget = ctx.getTarget();
		Method ctxMethod = ctx.getMethod();
		if (ctxTarget == null) {
			throw new UnsupportedOperationException("Target can't be null");
		}
		if (ctxMethod == null) {
			throw new UnsupportedOperationException("Method can't be null");
		}

		String methodToLog = ctxMethod.getName();
		Object[] parameters = ctx.getParameters();
		
		methodToLog += getMethodParametersLog(parameters);

		String logResult = String.format("Call to %s.%s", ctxTarget.getClass().getSimpleName(), methodToLog);
		LOGGER.info(logResult);

		return ctx.proceed();
	}
	
	private String getMethodParametersLog(Object[] parameters) {
		String formattedParameters = "";
		if (parameters.length != 0) {
			formattedParameters += "(";
			for (int i = 0; i < parameters.length; i++) {
				Object object = parameters[i];
				formattedParameters += object.toString();
				if (i != parameters.length - 1) {
					formattedParameters += ", ";
				}
			}
			formattedParameters += ")";
		}
		return formattedParameters;
	}

}
