package com.example.demo;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;










@Controller
public class AppController {

	
	
	@Controller
	public class testController{
		@GetMapping("/twidr")
		public String testForm() {
			System.out.println("YOu have reached my testing page");
			return "test.html";
		}
		@PostMapping("/twidr")
		public String testform(test1 user,Model model) {
			model.addAttribute("user",user);
			String name=user.getTest1();
			String pwd=user.getTest2();
			System.out.println("test1="+name+ "   test2=" + pwd);
			
			
			return "ilyy";
		}
		
	}
	
	
	
	 @RequestMapping("/")
	 public String index() {
			System.out.println("You have reached landiNG page");
		    return "index.html";
		}
	 
	 @Controller
	 public class ownerLoginController {

	     @GetMapping("/ownerLogin")
	     public String ownerLoginForm() {

	    	 System.out.println("Owner Login page reached");
	        return "ownerLogin.html";
	     }
	     @PostMapping("/ownerLogin")
	     public String ownerFormPost(ownerLogin user, Model model) {
	         model.addAttribute("user", user);
	      
	        String name=user.getUsername();
	        String pwd=user.getPassword();
	        System.out.println("Entered detail: usr= " + name + "  pwd="+pwd);
	        
			try {
				checkLogin.verifyPwd(name, pwd,'o');
				if(checkLogin.flag==true) {
					System.out.println("ENTERED LOGIN IS CORRECT");
				}else {
					System.out.println("Wrong details");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        return "form";
	     }
	    

	 }
	 @Controller
	 public class employeeLoginController{
		 
	 
	 @GetMapping("/employeeLogin")
	 public String employeeLogin(Model model) {
			System.out.println("You have reached Employee Login page");
		    return "employeeLogin.html";
		}
	 @PostMapping("/employeeLogin")
	 public String employeeFormPost(employeeLogin user,Model model) {
		 model.addAttribute("user", user);
		 
		 
		 String name=user.getUsername();
	        String pwd=user.getPassword();
	        System.out.println("Entered detail: usr= " + name + "  pwd="+pwd);
	        
		 
		 try {
				checkLogin.verifyPwd(name, pwd,'e');
				if(checkLogin.flag==true) {
					System.out.println("ENTERED LOGIN IS CORRECT");
				}else {
					System.out.println("Wrong details");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return "from";
	 }
	 }
	 
	 
	 @Controller
	 public class signupController{
		 
		 
	 @GetMapping("/signup")
	 public String signupForm(Model model) {
			System.out.println("You have reached Sign up page");
		    return "signup.html";
		}
	 
	 @PostMapping("/signup")
	 public String signupFormPost(signupForm user,Model model){
		   model.addAttribute("user",user);
		   String usr=user.getUsername();
	       String pwd=user.getPassword();
	       int age=user.getAge();
	       String name=user.getName();
	    	String email=user.getEmail();
	    	String gender=user.getGender();
	       System.out.println("Entered detail: usr= " + usr + "  pwd="+pwd + "  age="+age+ "  name="+name+ "  email="+email+ "  gender="+gender);
	       try {
			insertToDb.signupDetails(usr,pwd,age,name,email,gender);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return "form";
	 }
		 
	 }
	 

}
