package cali.eventkalender.interceptor;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
public class DefaultInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultInterceptor.class);

	@PostConstruct
	public void postConstruct(InvocationContext ctx) {
		Object ctxTarget = ctx.getTarget();
		if (ctxTarget == null) {
			throw new UnsupportedOperationException("Target can't be null");
		}
		try {
			LOGGER.info("PostConstruct - {}", ctxTarget.getClass().getName());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@PreDestroy
	public void preDestroy(InvocationContext ctx) {
		Object ctxTarget = ctx.getTarget();
		if (ctxTarget == null) {
			throw new UnsupportedOperationException("Target can't be null");
		}
		try {
			LOGGER.info("PreDestroy - {}, proceed={}", ctxTarget.getClass().getName(), ctx.proceed());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ctx) throws Exception {
		Method ctxMethod = ctx.getMethod();
		Object ctxTarget = ctx.getTarget();
		if (ctxMethod == null) {
			throw new UnsupportedOperationException("Method can't be null");
		}
		if (ctxTarget == null) {
			throw new UnsupportedOperationException("Target can't be null");
		}

		String targetName = ctxTarget.getClass().getName();
		String methodName = ctxMethod.getName();

		String parameterString = getParameterString(ctxMethod.getParameterTypes(), ctx.getParameters());

		LOGGER.info("AroundInvoke - {}.{}{}", targetName, methodName, parameterString);

		return ctx.proceed();
	}

	private String getParameterString(Class<?>[] parameterTypes, Object[] parameterValues) {
		String formattedParameters = "";
		if (parameterTypes.length != 0) {
			formattedParameters += "(";
			for (int i = 0; i < parameterTypes.length; i++) {
				String typeName = (parameterTypes[i] != null ? parameterTypes[i].getName() : "null");
				String variableValue = (parameterValues[i] != null ? parameterValues[i].toString() : "null");
				formattedParameters += String.format("%s=%s", typeName, variableValue);
				if (i != parameterTypes.length - 1) {
					formattedParameters += ", ";
				}
			}
			formattedParameters += ")";
		}
		return formattedParameters;
	}

}
