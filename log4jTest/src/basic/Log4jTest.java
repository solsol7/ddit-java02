package basic;

import org.apache.log4j.Logger;

public class Log4jTest {
	//Logger 클래스의 인스턴스를 구한다.
	static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		//로그 기록 남기는 연습
		//형식) Logger객체.로그레벨명("출력할 메시지");
		logger.trace("이 로그 기록은 TRACE 레벨의 로그 기록입니다.");
		logger.debug("이 로그 기록은 DEBUG 레벨의 로그 기록입니다.");
		logger.info("이 로그 기록은 INFO 레벨의 로그 기록입니다.");
		logger.warn("이 로그 기록은 WARN 레벨의 로그 기록입니다.");
		logger.error("이 로그 기록은 ERROR 레벨의 로그 기록입니다.");
		logger.fatal("이 로그 기록은 FATAL 레벨의 로그 기록입니다.");
		
		System.out.println("작업끝...");
	}
}
