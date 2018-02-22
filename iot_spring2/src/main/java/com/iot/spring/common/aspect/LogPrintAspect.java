package com.iot.spring.common.aspect;

import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.DAO.NaverTransDAO;

@Component
@Aspect
public class LogPrintAspect {

	private static final Logger log = LoggerFactory.getLogger(LogPrintAspect.class);

	@Autowired
	private NaverTransDAO nDAO;
	
	@Before("execution(* com.iot.spring.controller.*Controller.*(..))")
	public void beforeLog(JoinPoint jp) {
		log.info("@Before =>{}", jp);
	}

	@Around("execution(* com.iot.spring.controller.*Controller.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws IOException {
		log.info("@Around begin =>{}", pjp);
		Object obj = null;
		long startTime = System.currentTimeMillis();
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			ObjectMapper om = new ObjectMapper();
			log.error("error=>{}", e);
			ModelAndView mav=new ModelAndView("error/error");
			/*NaverMessage nm=om.readValue(nDAO.getText(e.getMessage()), NaverMessage.class);*/
			String data=nDAO.getText(e.getMessage());
			mav.addObject("errorMsg", data);
			return mav;
		}
		log.info("@Around end, RunTime :{}ms", (System.currentTimeMillis() - startTime));
		return obj;
	}

	@After("execution(* com.iot.spring.controller.*Controller.*(..))")
	public void afterLog(JoinPoint jp) {
		log.info("@After =>{}", jp);
	}
}