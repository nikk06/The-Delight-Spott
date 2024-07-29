package com.example.demo;
import java.io.File;
import java.net.http.HttpRequest;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RestroController {
	private List<String> foodItems = new ArrayList<>();
	private List<String> prices= new ArrayList<>();
	 
	@Autowired
	private SmsService smsService;
	String otp;
	@Autowired
	private MailService mailservice;
	@Autowired
	private RestroRepo repo;
	@Autowired
	private Customerrepo repo1;
	@Autowired
	private Menurepo repo2;
	@Autowired
	private Basicrepo repo3;
	@Autowired
	private diningrepo repo4;
	@Autowired
	private repo1 reppo1;
	@Autowired
	private CartRepo cartrepo;
	@Autowired
   private finalbillrepo repo5;
	@Autowired
	private CartRepo1 cartrepo1;
    @GetMapping("/")
	public String Home()
	{
		return "index";
	}
    @PostMapping("/Owner")
    public String OwnerSigninuppage()
    {
    	return "Ownerpage";
    }
    @PostMapping("/send")
    public String otpsendtomail(@ModelAttribute Model1 email)
    {
    	otp=mailservice.generateOtp();
    	mailservice.sendMail(email, otp);
    	System.out.println("mail send successfully");
    	return "Otpsend";
    }
    
    @PostMapping("/verify")
	public String otp()
	{
		return "verifyemail";
	}
    
    
    @PostMapping("/otpverify")
	public String otpp(HttpServletRequest request,Model model)
	{
		String n;
		n=request.getParameter("EmailOtp");
		if(n!=null && n.equals(otp))
		{
			HttpSession session=request.getSession();
			 session.setAttribute("Email",n);
			try 
			{
				Thread.sleep(5000);
				 return "finalsignup";
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("equal");
		}
		else
		{
			System.out.println("not equal");
		}
		return "verifyemail";
	}
    
    
      @PostMapping("/savepass")
	 public String saveRestropass(Model2 mod2)
		{ 
			if(mod2!=null)
			{
				repo.save(mod2);
				System.out.println("data saved succesfully to db");
			}
			try 
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "Restrodatasave";
		}
      @PostMapping("/okk")
      public String success()
      {
    	  return "Ownerpage";
      }
      
      
        @PostMapping("/customer")
    public String CustomerSigninuppage()
    {
    	return "Customerpage";
    }
       
          @PostMapping("/csend")
    public String cotpsendtomail(@ModelAttribute Model3 email)
    {
    	otp=mailservice.generateOtp();
    	mailservice.sendMail1(email, otp);
    	System.out.println("mail send successfully");
    	return "Otpsend1";
    }
          
   
    @PostMapping("/verfy")
	public String otp1()
	{
		return "verifyemail1";
	}
    
   
      
        @PostMapping("/otpverify1")
	public String op(HttpServletRequest request,Model model)
	{
		String n1;
		n1=request.getParameter("EmailOtp1");
		if(n1!=null && n1.equals(otp))
		{
			HttpSession session=request.getSession();
			 session.setAttribute("Email",n1);
			try 
			{
				Thread.sleep(5000);
				 return "finalsignup1";
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("equal");
		}
		else
		{
			System.out.println("not equal");
		}
		return "verifyemail1";
	} 
       
       
        
         @PostMapping("/saveupass")
	 public String saveCustomerpass(Model4 mod4)
		{ 
			if(mod4!=null)
			{
				repo1.save(mod4);
				System.out.println("data saved succesfully to db");
			}
			try 
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "Customerdatasave";
		}
         
         
         
      @PostMapping("/okkk")
      public String successs()
      {
    	  return "Customerpage";
      }
         
       
         @PostMapping("/login")
	 public String RestroLogin(HttpServletRequest request,Model model)
	 {
		 String n=request.getParameter("Vemail");
		 String n1=request.getParameter("VPassword");
		 Model2 model2=repo.findByRemaillAndRpasssowrd(n, n1);
		 if(model2!=null)
		 {
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("login Success");
				return"homepageofrestro";
		 }
		 else 
		 {
			 try 
				{
					TimeUnit.SECONDS.sleep(2);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("login Success");
			System.out.println("not login succesully");
			model.addAttribute("msg","Invalid Email or Password!");
			 return "Ownerpage";
		 }
	 }
         @PostMapping("/AddDishes")
         public String Admenu()
         {
        	return"MenuRegister"; 
         }
          @PostMapping("/savedishes")
	 private String saveDishes(@RequestParam MultipartFile dimage1,
			 @RequestParam String Dishname,@RequestParam String DishQuantity,
			 @RequestParam String DishPrice,@RequestParam String Description)
	 {
		 Model5 model5 =new Model5();
		 model5.setDimage1(dimage1.getOriginalFilename());
		 model5.setDishname(Dishname);
		 model5.setDishQuantity(DishQuantity);
		 model5.setDishPrice(DishPrice);
		 model5.setDescription(Description);
		Model5 uploadData=repo2.save(model5);
			if(uploadData!=null)
			{
			try 
			{
				File saveFile=new ClassPathResource("static/Menus").getFile();
				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+dimage1.getOriginalFilename());
			
				
				Files.copy(dimage1.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
				System.out.println(path);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("datasavedsuccessfully");
			return "success";
		}
		else 
		{
			return"index";
		}
	 }
          @PostMapping("/back")
        public String reback()
        {
        	return "homepageofrestro";
        }
         //data fetched successfully 
        @PostMapping("/Menu") 
        public String seeMenu(Model model)
        {
        	List<Model5> model5=repo2.findAll();
        	 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
        	if(model5!=null)
        	{
        		for(Model5 ans:model5)
        		{
        			System.out.println(ans);
        		}
        		 model.addAttribute("list",model5);
        		return "menu";
        	}
        	else 
        	{
        		return "Customerdatasave";
        	}
        }
      
       
        @PostMapping("/delete")
	public String DeleteDish(HttpServletRequest requ)
	{
		String s=requ.getParameter("Dname");
		//repo3.deleteByOvno(s);
		int c=repo2.deleteByDishname(s);
		System.out.println(c);
		
			try 
			{
				TimeUnit.SECONDS.sleep(5);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("Data delete succesully..");
			return"DeletedSuccess";
		
	}
        @PostMapping("/deleteback")
    	public String DeletedDish()
    	{
        	return"redirect:/index1.html";
    	}
        
          @PostMapping("/basic")
	 public String saveBasic(Model6 mod6)
		{ 
			if(mod6!=null)
			{
				repo3.save(mod6);
				System.out.println("data saved succesfully to db");
			}
			try 
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "basicsave";
		}
          @PostMapping("/bok")
        private String gotit()
        {
        	return"homepageofrestro";
        }
          
          
             @PostMapping("/login1")
	 public String CustomerLogin(HttpServletRequest request,Model model)
	 {
		 String n=request.getParameter("CustLogin");
		 String n1=request.getParameter("CustPass");
		 //Model2 model2=repo.findByRemaillAndRpasssowrd(n, n1);
		 Model4 model4=repo1.findByCemaillAndCpasssowrd(n, n1);
		 if(model4!=null)
		 {
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("login Success");
				return"homepageofcutomer";
		 }
		 else 
		 {
			 try 
				{
					TimeUnit.SECONDS.sleep(2);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("login Success");
			System.out.println("not login succesully");
			model.addAttribute("msg","Invalid Email or Password!");
			 return "Customerpage";
		 }
	 }
            @PostMapping("/reserve") 
           public String Reserve()
           {
        	   return "reserveyourtable";
           }
           
             @PostMapping("/bookdining")
	 private String bookDining(@RequestParam MultipartFile ReqidProof,
			 @RequestParam String Reqname,@RequestParam String Reqphone,
			 @RequestParam String ReqtableFor,@RequestParam String Reqdate,
			  @RequestParam String ReqtimeFrom,@RequestParam String ReqtimeTo, @RequestParam String Status)
	 {
         Model7 model7=new Model7();
         model7.setReqidProof(ReqidProof.getOriginalFilename());
         model7.setReqname(Reqname);
         model7.setReqphone(Reqphone);
         model7.setReqtableFor(ReqtableFor);
         model7.setReqdate(Reqdate);
         model7.setReqtimeFrom(ReqtimeFrom);
         model7.setReqtimeTo(ReqtimeTo);
         model7.setStatus(Status);
         Model7 upload=repo4.save(model7);
			if(upload!=null)
			{
			try 
			{
				File saveFile=new ClassPathResource("static/idproof").getFile();
				Path path1=Paths.get(saveFile.getAbsolutePath()+File.separator+ReqidProof.getOriginalFilename());
			
				
				Files.copy(ReqidProof.getInputStream(),path1,StandardCopyOption.REPLACE_EXISTING);
				System.out.println(path1);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("idStoredSuccessfully");
			return"redirect:/ReserveTable.html";
		}
		else 
		{
			return"homepageofcutomer";
		}
	 }
             
    
      @PostMapping("/checkreserv") 
        public String checkreservation(Model model,HttpServletRequest request)
        {
    	  String n=request.getParameter("revphono");
		 try 
			{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 List<Model7> model7=repo4.findAllByReqphone(n);
		 if(model7!=null)
		 {
			 for(Model7 ans1:model7)
     		{
     			System.out.println(ans1);
     		}
			 model.addAttribute("lst1",model7);
			 model.addAttribute("name",n);
			 return"yourreservation";
		 }
		 else 
		 {
			System.out.println("List Not Founx");
			 return "index";
		 }
        }  
      
     
      @PostMapping("/delrev")
	public String Deletereservation(HttpServletRequest reqr,Model mo1)
	{
		String s=reqr.getParameter("revdel");
		repo4.deleteByReqphone(s);
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("Data delete succesully..");
				mo1.addAttribute("dl","Reservation selete Successfully");
				return"redirect:/ReserveTable.html";
	}
      
        @PostMapping("/check") 
        public String checkreservation(Model model)
        {
        	List<Model7> model7=repo4.findAll();
        	 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
        	if(model7!=null)
        	{
        		for(Model7 ans1:model7)
        		{
        			System.out.println(ans1);
        		}
        		 model.addAttribute("list1",model7);
        		return "reservations1";
        	}
        	else 
        	{
        		return "Customerdatasave";
        	}
        }
      
        @PostMapping("/mng") 
        public String managereservation(Model model)
        {
        	return "Manage";
        }
        
        @PostMapping("/svemg")
        public String savemng(Model9 mod9,@RequestParam("tname")String name, @RequestParam("tphone")String phoneno,@RequestParam("ttime")String time,@RequestParam("tableNo") String tableno)
        {
        	
        	if(mod9!=null)
			{
				
        		reppo1.save(mod9);
				System.out.println("data saved succesfully to db");
				
				
			}
			try 
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "Manage";
        }
        @PostMapping("/checkk")
        public String check()
        {
        	return "Checktable";
        }
        //check reservation
         @PostMapping("/tbl101") 
        public String tableno101(Model model)
        {
    	  String n="101";
		 try 
			{
				TimeUnit.SECONDS.sleep(2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 List<Model9> model9=reppo1.findAllByTableNo(n);
		 if(model9!=null)
		 {
			 for(Model9 ans1:model9)
     		{
     			System.out.println(ans1);
     		}
			 model.addAttribute("lstt1",model9);
			 return"Check_for_table";
		 }
		 else 
		 {
			System.out.println("List Not Found");
			 return "Check_for_table";
		 }
        }
         
       
         @PostMapping("/tbl102") 
         public String tableno102(Model model)
         {
     	  String n="102";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
       
         @PostMapping("/tbl103") 
         public String tableno103(Model model)
         {
     	  String n="103";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         
         @PostMapping("/tbl104") 
         public String tableno104(Model model)
         {
     	  String n="104";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         @PostMapping("/tbl201") 
         public String tableno201(Model model)
         {
     	  String n="201";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         @PostMapping("/tbl202") 
         public String tableno202(Model model)
         {
     	  String n="202";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         @PostMapping("/tbl203") 
         public String tableno203(Model model)
         {
     	  String n="203";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			 
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         @PostMapping("/tbl204") 
         public String tableno204(Model model)
         {
     	  String n="204";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         @PostMapping("/tbl301") 
         public String tableno301(Model model)
         {
     	  String n="301";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         @PostMapping("/tbl302") 
         public String tableno302(Model model)
         {
     	  String n="302";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         @PostMapping("/tbl303") 
         public String tableno303(Model model)
         {
     	  String n="303";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         }  
         
         @PostMapping("/tbl304") 
         public String tableno304(Model model)
         {
     	  String n="304";
 		 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		 List<Model9> model9=reppo1.findAllByTableNo(n);
 		 if(model9!=null)
 		 {
 			 for(Model9 ans1:model9)
      		{
      			System.out.println(ans1);
      		}
 			 model.addAttribute("lstt1",model9);
 			 return"Check_for_table";
 		 }
 		 else 
 		 {
 			System.out.println("List Not Found");
 			 return "Check_for_table";
 		 }
         } 
         
            @PostMapping("/deldining")
	public String DeleteteDiningdetails(HttpServletRequest reqq)
	{
		String s=reqq.getParameter("Dcutmb");
		reppo1.deleteByTphone(s);
			 try 
				{
					TimeUnit.SECONDS.sleep(5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.out.println("Data delete succesully..");
				
				return"Checktable";
	}
         @PostMapping("/negackno")   
      public String NegativeAckno()
      {
    	  return"Negativeackno";
      }
         
         
          @PostMapping("/sendSms")
	    public String sendSms(@RequestParam("phone") String phone,  Model model) {
	     String message="Hello Customer, Kindly there is no any seat is present according to your given time and people for dinning!!! \n From, Team Delight Spot(Bar & Restro)";
        	  boolean isSent=smsService.sendSms(phone, message);
        	  model.addAttribute("isSent",isSent);
        	  return "result";
	 }

          @GetMapping("/exit")
          private String GoBack()
          {
        	  return"homepageofrestro";
          }
      
         @PostMapping("/ordermenu") 
        public String menuorder(Model model)
        {
        	List<Model5> model5=repo2.findAll();
        	 try 
 			{
 				TimeUnit.SECONDS.sleep(2);
 			}
 			catch(Exception e)
 			{
 				e.printStackTrace();
 			}
        	if(model5!=null)
        	{
        		for(Model5 ans:model5)
        		{
        			System.out.println(ans);
        		}
        		 model.addAttribute("lt",model5);
        		return "menu1";
        	}
        	else 
        	{
        		return "menu1";
        	}
        }
         

         @PostMapping("/search") 
        public String menuorder(Model model,HttpServletRequest req)
        {
	  String n =req.getParameter("searchitem");
	  List<Model5> mdl5=repo2.findAllByDishname(n);
	  try 
		{
			TimeUnit.SECONDS.sleep(2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        	if(mdl5!=null)
        	{
        		
        		 model.addAttribute("lt",mdl5);
        		return "menu1";
        	}
        	else 
        	{
        		return "menu1";
        	}
        }
         
         public int random()
         {
        	 Random random=new Random();
        	 int min = 20;
             int max = 40;
             int randomNumber = random.nextInt((max - min) + 1) + min;
             return randomNumber;
         }
         public int random1()
         {
        	 Random random=new Random();
        	 int min = 10;
             int max = 25;
             int randomNumber = random.nextInt((max - min) + 1) + min;
             return randomNumber;
         }
         public int random2()
         {
        	 Random random=new Random();
        	 int min = 10001;
             int max = 50001;
             int randomNumber = random.nextInt((max - min) + 1) + min;
             return randomNumber;
         }
            @PostMapping("/addtocart")
	 public String Addtocart(Model10 mod10,HttpServletRequest r, Model modd,Model101 mod101)
		{ 
            	String n=r.getParameter("dishName");
            	String n1=r.getParameter("quantity");
            	String n2=r.getParameter("name");
            	String n3=r.getParameter("mno");
            	String n4=r.getParameter("address");
            	int n5=random();
            	int n6=random1();
            	final int n7=random2();
            	String newItem=n+" (Quantity: " + n1 + ")";
            	foodItems.add(newItem);
            	String modd5=repo2.findDishPricebyDishnameAndDishQuantity(n, n1);
     
            	if(modd5!=null)
            	{
            		int sum=0;
            		prices.add(modd5);
            		for(String an:prices)
            		{
            			 sum += Integer.parseInt(an)+30-n6;
            		}
            		modd.addAttribute("price", modd5);
            		modd.addAttribute("total",sum);
            		
            	}
            	else 
            	{
            		System.out.println("empty set");
            	}
            	
			if(mod10!=null)
			{
				modd.addAttribute("foodItems",foodItems);
				modd.addAttribute("d2",n2);
				modd.addAttribute("d3",n3);
				modd.addAttribute("d4",n4);
				modd.addAttribute("d5",n5);
				modd.addAttribute("d6",n6);
				modd.addAttribute("d7",n7);
				cartrepo.save(mod10);
				System.out.println("data saved succesfully to db");
			}
			if(mod101!=null)
			{
				cartrepo1.save(mod101);
			}
			try 
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "Billing";
		}
            
            @PostMapping("/returnback")
        public String returnagain()
        {
        	return"homepageofcutomer";
        }
            @PostMapping("/returncart")
            public String cart()
            {
            	return"Billing";
            }
            @PostMapping("/finalsave")
            public String finalsave(Model11 mod11)
            {
            	if(mod11!=null)
          	  {
          		  repo5.save(mod11);
          		 System.out.println("data saved succesfully");
          	  }
            	return"orderplacedsuccessfully";
            }
          @PostMapping("/finalBill")
            public String guiest(HttpServletRequest request,Model mod)
            {
        	  String n=request.getParameter("phoneno");
        	  System.out.println(n);
        	 List<Model11>modd11=repo5.findAll();
        	 List<Model10>modd10=cartrepo.findAll();
        	 if(modd11!=null)
        	 {
        		 mod.addAttribute("data",modd11);
        	 }
        	if(modd10!=null)
        	{
        		mod.addAttribute("data1",modd10);
        	}
        	 
        	  return "afterbilling";
            }
          @PostMapping("/rupdate")
          public String forgot1(HttpServletRequest request)
          {
        	  String n=request.getParameter("femail");
        	  String n1=request.getParameter("fpass");
        	 int ans=repo.updatePasswordByEmail(n, n1);
        	  if(ans!=0)
        	  {
        		  System.out.println("Update Successfully");
        		  return "ResturentPasswordSuccessfully";
        	  }
        	  else 
        	  {
        		  System.out.println("nOT uPDATE");
        		  return"notmatched1";
        	  }
          }
          @PostMapping("/cupdate")
          public String forgot2(HttpServletRequest req)
          {
        	  String n=req.getParameter("cemail");
        	  String n1=req.getParameter("cpass");
        	  int ans1=repo1.updatePasswordByEmail1(n, n1);
        	  if(ans1!=0)
        	  {
        		  System.out.print("Update Successfully");
        		  return"CustomerPasswordSuccess";
        	  }
        	  else 
        	  {
        		  System.out.println("nOT uPDATE");
        		  return "notmatched2";
        	  }
          }
          @PostMapping("/udt1success")
          public String udtsucc()
          {
        	  return"Ownerpage";
          }
          @PostMapping("/udt2success")
          public String udtsucc1()
          {
        	  return"Customerpage";
          }
          @PostMapping("/!rmatched")
          public String notmatched()
          {
        	  return "index";
          }
          @PostMapping("/!rmatched1")
          public String notmatched2()
          {
        	  return "index";
          }
          
          @PostMapping("/deleteall")
          public String deleteall(HttpServletRequest request)
          {
        	  String n=request.getParameter("dmo");
        	  /*
        	  try 
        	  {
        		  String messagee="Hello Customer, Your Food will be hand to our delivery partner, contact no(+7549085843) \n From, Team Delight Spot(Bar & Restro)";
            	  boolean isSentt=smsService.sendSms(n, messagee);
            	  System.out.println("Message Send to customer Successfully");
        	  }
        	  catch(Exception e)
        	  {
        		  e.printStackTrace();
        	  }
        	 */
        	  int a=cartrepo.deleteByMno(n);
        	  int b=repo5.deleteByPhoneno(n);
        	  try 
        	  {
        		  Thread.sleep(2000);
        	  }
        	  catch(Exception e)
        	  {
        		  e.printStackTrace();
        	  }
        	  return"homepageofrestro";
          }
          @PostMapping("/ssc")
          public String gotitt()
          {
        	  return"homepageofcutomer";
          }
          
          @PostMapping("/ssc1")
          public String gotittt()
          {
        	  return"homepageofrestro";
          }
          
}

