package com.cts.oopp.ui;

import com.cts.oopp.model.Student;

public class StudentClient {

	public static void main(String[] args) {
		Student.setFeePaid(75000);
		Student.setCourse("Java FSD");
		//array of objects
		Student []students= new Student[3];
		students[0]= new Student(1,"Srinivasa");
		students[1]= new Student(2,"Bobby");
		students[2]= new Student(3,"Mike");
		for(Student student: students)
			student.show();
	}

}
