package com.youtube.aspect;

import org.apache.log4j.Logger;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	java.util.logging.Logger log1= java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
	Logger log= Logger.getLogger(LoggingAspect.class);
	
	
//	@Before("execution(public void savePost())")
//	public void doLogAdvice() {
//		System.out.println("Calling Log for all save methods");
//	}
//	
//	@After("pointCutForAllGetters()")
//	public void doLogAdviceForGetters() {
//		System.out.println("Calling Log for all getters methods");
//	}
//	
//	@AfterThrowing(pointcut="execution(public void save*())", throwing="exception")
//	public void doLogAdvice1(Exception exception) {
//		System.out.println("Calling Log for all exception thrown "+exception);
//	}
//	
//	@Pointcut("execution( * get*()) && !within(is(FinalType)) && !within(com.spring.hib.model.Post)")//can avoid creating proxy for enumtype too using !within(is(EnumType))
//	public void pointCutForAllGetters() {
//		
//	}
//	
//	@AfterReturning(pointcut="args(name)", returning="returnedValue")//can avoid creating proxy for enumtype too using !within(is(EnumType))
//	public void pointCutForMethodsWithSingleArgument(Object name, Object returnedValue) {
//		System.out.println("Argument "+name+"  "+"returned value "+returnedValue);
//	}
	
	@Before("execution(* com.youtube.dao.VideoService.get*(..))")
	public void doLogAdviceForDao() {
		System.out.println("Calling Log for all getter methods in videodao");
		log1.info("Calling Log for all getter methods in videodao through Java Logger");
		log.info("Calling Log for all getter methods in videodao through Log4j");
	}

}
