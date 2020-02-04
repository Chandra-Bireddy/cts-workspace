package com.w;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Plying {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Automobile am = context.getBean("myAutomobile",Automobile.class);
		am.plies();

	}

}
