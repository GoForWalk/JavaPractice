package com.lec.spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.lec.beans.Logger;

// Aspect : Advisor 들을 모아 놓은 객체
// Advisor : Advice + PointCut
// Advice : 공통기능 (메소드)

// 이 클래스가 Aspect 역할을 할 클래스 임을 명시
@Aspect
public class LogAspect { // Spring Container 에 설정되어야 한다.
	
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc1() {} // 특정 pointCut 을 메소드 이름으로 지정 할 수 있다. 

	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc2() {}
	
	// 이름으로 설정하면 연산자를 사용 할 수 있다. ( &&, ||, ! )
	
	
//	@Before("within(com.lec.spring.aop02.*)") // PointCut 
	@Before("pc1()") 
	// com.lec.spring.aop02.* 의 메소드가 호출되기 전에 해당 메소드(advice) 실행 
	public void beforeAdvice() {
		System.out.print("[Before] ");
		new Logger().LogIn(); // 공통 코드. Advice!! 
	}
	
//	@After("pc2()")
//	@After("within(com.lec.spring.aop02.*)") // PointCut
//	@After("execution(* com.lec.spring.aop02.MyService22.*(..))")
	@After("execution(* con.lec.spring.aop02.*2.*(..))")
	public void afterAdvice() {
		System.out.print("[After] ");
		new Logger().LogOut(); // Advice
	}
	
	// Around advice: 메소드 실행을 제어하는 가장 강력한 코드
	// 					직접 해당 메소드를 호출하고 결과나 예외처리도 가능
	@Around("within(com.lec.spring.aop02.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// JointPoint 메소드 이름
		String signatureStr = joinPoint.getSignature().toLongString();
		
		// JoinPoint 메소드 수행 전
		System.out.println("[Around] " + signatureStr + " 시작");
		long st = System.currentTimeMillis(); // 시작시간 기록
		
		// JoinPint 메소드 수행
		try {
			Object obj = joinPoint.proceed(); // 오브젝트 리턴
			return obj;
		
		} finally {
			// joinPoint 메소드 수행 후
			long et = System.currentTimeMillis(); // 종료시간 기록
			System.out.println("[Around] " + signatureStr + " 종료, 경과 시간 : " + (et - st) + " ms");

		}

		
		// JoinPint 메소드 수행 후 
	
		
	} // end aroundAdvice
	
	// PointCut + advice -> Advisor 생성
} // end LogAspect
