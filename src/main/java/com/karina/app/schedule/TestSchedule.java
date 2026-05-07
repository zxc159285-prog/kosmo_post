package com.karina.app.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class TestSchedule {

	//클라이언트 요청없이 고정간격으로 반복하는 메서드
	//@Scheduled(fixedRate = 2000,initialDelay = 1000)
	public void useFixRate()throws Exception{
		
		System.out.println("고정 간격으로 반복할 코드");
	}
	//@Scheduled(fixedDelay = 2000,initialDelay = 1000)
	public void useFixDelay()throws Exception{
		System.out.println("고정 간격으로 반복 Delay");
	}
	
	@Scheduled(cron = "* * * * * *")
	public void useCron()throws Exception{
		System.out.println("Cron");
	}
}
