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
		String parameterValues = getParameterString(ctx.getParameters());

		LOGGER.info("AroundInvoke - {}.{}{}", targetName, methodName, parameterValues);

		return ctx.proceed();
	}

	private String getParameterString(Object[] parameters) {
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
