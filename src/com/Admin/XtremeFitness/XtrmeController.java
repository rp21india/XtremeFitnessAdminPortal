package com.Admin.XtremeFitness;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class XtrmeController {	
		@RequestMapping(value="/home")
		public String showHello(){
			System.out.print("**Show Hello**");
			return "HomeDef";
		}
	
		@RequestMapping(value="/addstudent")
	public String addstudent(){
			System.out.print("**Showing addstudent.jsp **");
			return "AddStudentDef";
	}
		@RequestMapping(value="/searchstudent")
	public String searchStudent(){
			System.out.print("**Showing searchstudent.jsp**");
			return "SearchStudentDef";
	}
}

