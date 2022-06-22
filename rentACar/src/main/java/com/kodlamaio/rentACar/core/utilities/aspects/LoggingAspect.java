package com.kodlamaio.rentACar.core.utilities.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component//nesne yönetimi
public class LoggingAspect {
	//@Before("execution(* com.kodlamaio.rentACar.business.concretes.*.*.(..)")
	
	@Before("execution (* com.kodlamaio.rentACar.business.concretes.*.*(..))")
	public void log(JoinPoint joinPoint) {//advice
		
		System.out.println(joinPoint.FIELD_GET);
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println(signature.getClass());
		
		
	}
	
	

}
