package com.w;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	
	
	
    public static void main( String[] args )
    {
    	
   	
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

Engineer eng = context.getBean("theEngineer",Engineer.class);

Engineer secondEng = context.getBean("theEngineer",Engineer.class);

eng.work();



//if(eng == secondEng)
//{
//	System.out.println("Same : " + eng + ",\n" + secondEng);
//}
//else
//{
//	System.out.println("Different : " + eng + ",\n" + secondEng);
//}

       
    }
}
