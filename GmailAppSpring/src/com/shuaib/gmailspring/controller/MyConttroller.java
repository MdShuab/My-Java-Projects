package com.shuaib.gmailspring.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shuaib.gmailspring.model.InfoDTO;
import com.shuaib.gmailspring.model.RegDTO;
import com.shuaib.gmailspring.service.MyService;

@Component
@RequestMapping("/")
public class MyConttroller {

	@Autowired
	MyService ms;
	
	HttpSession ss=null;
	
	@RequestMapping("/UserRegister")
	public String reg() {
		return "Register";
	}
	@RequestMapping("/Home")
	public ModelAndView home(HttpServletRequest req) {
		ss=req.getSession(false);
		String nm=(String) ss.getAttribute("email");
		return new ModelAndView("Home","name",nm);
	}
	@RequestMapping("/Logout")
	public ModelAndView logOut(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
	
		if(em!=null) {
			int tt=ms.visitTime(em);
			ss.invalidate();
		return new ModelAndView("Login","msg",""+em+" Logout Successfully! You Visited "+tt+" minutes");

		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	@RequestMapping("/DeleteSent")
	public ModelAndView dsent(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String nm=(String) ss.getAttribute("email");
		if(nm!=null) {
			
		boolean b=ms.dInbox(req,"deleteSent");
		if(b) {
		return new ModelAndView("Home","name",nm);
		}else
		{
			return new ModelAndView("Home","name",nm);
			
		}}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	@RequestMapping("/DeleteDraft")
	public ModelAndView dDaft(HttpServletRequest req) {
		ss=req.getSession(false);
		String nm=(String) ss.getAttribute("email");
		if(nm!=null) {
		boolean b=ms.dInbox(req,"deleteDraft");
		if(b) {
			return new ModelAndView("Home","name",nm+"   ===================Message Deleted Successfully===================");
		}else
		{
			return new ModelAndView("Home","name",nm+"   ===============Message Already  Deleted");
			
		}
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	@RequestMapping("/EditDraft")
	public ModelAndView editDaft(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String nm=(String) ss.getAttribute("email");
		if(nm!=null) {
		InfoDTO dto=ms.editDraft(req);
		System.out.println("hello controller edit");
			return new ModelAndView("ComposeDraft","dto",dto);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
		
	}
	@RequestMapping("/Profile")
	public ModelAndView profile(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
			
		RegDTO dto=ms.profile(em);
		return new ModelAndView("Profile","dto",dto);
		}else {
			return new ModelAndView("Login","msg","Login First");
			}
		
	}
	@RequestMapping(value="/AccDelete",method=RequestMethod.POST)
	public ModelAndView accDelt(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		
		if(em!=null) {
			//	ss.invalidate();
			boolean b=ms.accDelete(em);
			return new ModelAndView("Login","msg",em+" Account Deleted Successfully!");
		}else {
			return new ModelAndView("Login","msg","Login First");
			}
		
	}
	@RequestMapping("/UpdateProfile")
	public ModelAndView updatePro(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
			
			boolean b=ms.updateProfile(req);
			if(b) {
			return new ModelAndView("Home","name",em+"===============Profile Updated Successfully!=============");
		}else {
			return new ModelAndView("Home","name",em+"===============Profile Updated Failed!=============");
		}
		}else {
			return new ModelAndView("Login","msg","Login First");
				}
		
	}
	@RequestMapping("/DeleteInbox")
	public ModelAndView dInbox(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String nm=(String) ss.getAttribute("email");
		if(nm!=null) {
			
		boolean b=ms.dInbox(req,"deleteInbox");
		if(b) {
			return new ModelAndView("Home","name",nm);
		}else
		{
			return new ModelAndView("Inbox","msg","Message Already  Deleted");
			
		}
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	
	@RequestMapping("/UserLogin")
	public String log() {
		return "Login";
	}
	
	@RequestMapping("/ForgotPw")
	public String forgotpw() {
		return "ForgotPW";
	}
	@RequestMapping("/ChangePw")
	public ModelAndView changePw(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
	
		if(em!=null) {
		return new ModelAndView("ChangePass");
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	@RequestMapping(value="/RegUser",method=RequestMethod.POST)
	public ModelAndView regUser(@ModelAttribute RegDTO rdto) {
		boolean b=ms.regUser(rdto);
		if(b) {
		return new ModelAndView("Login","msg","Register Succefully");
		}else {
			return new ModelAndView("Register","msg","User Allready Exist");
		}
	}
	
	
	
	@RequestMapping(value="/FPW",method=RequestMethod.POST)
	public ModelAndView forgPw(HttpServletRequest req) {
		 
		
		String email=req.getParameter("email");
		String pw1=req.getParameter("password1");
		String pw2=req.getParameter("password2");
		
		if(pw1.equals(pw2)) {
		boolean b=ms.forgPw(req);
		
		if(b) {
		return new ModelAndView("Login","msg","Password Changed Succefully");
		}else {
			return new ModelAndView("ForgotPW","msg","Email ID does'nt Exist");
		}
		}else
		
		return new ModelAndView("ForgotPW","msg","Password Does'nt Match");
		
	}
	@RequestMapping(value="/ChanGePw",method=RequestMethod.POST)
	public ModelAndView chPw(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
	
		if(em!=null) {
	
		String pw1=req.getParameter("password1");
		String pw2=req.getParameter("password2");
		
							if(pw1.equals(pw2)) {
								boolean b=ms.chngPw(req);
								return new ModelAndView("Home","name",em+"  =========Password Changed Succefully=========");
							}else

								return new ModelAndView("ChangePass","name",em+" =========Password Does'nt Match=========");
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
								}
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req) {
		
		String  b=ms.login(req);
		if(b.equalsIgnoreCase("success")) {
			String em=req.getParameter("email");
			 ss=req.getSession();
			 ss.setAttribute("email", em);
			System.out.println("Success");
			return  new ModelAndView("Home","name",em);
		}
		else if(b.equalsIgnoreCase("Incorrect Password")) {
			
			System.out.println("Failed");
			return new ModelAndView("Login","msg","Invalid Id or Password");
		}else {
			return new ModelAndView("Login","msg",b);
		}
	}
	
	@RequestMapping("/Compose")
	public ModelAndView compose(HttpServletRequest req) {
		ss=req.getSession(false);
		String sss=(String) ss.getAttribute("email");
		if(sss!=null) {
		return new ModelAndView("Compose");
		}else {
			System.out.println("inside compose else");
			return new ModelAndView("Login","msg","Login First");
		}
		
	}
	
	@RequestMapping(value="/Sent",method=RequestMethod.POST)
	public ModelAndView sent(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String sss=(String) ss.getAttribute("email");
		if(sss!=null) {
		
	boolean b=ms.sent(req);
	if(b){
		return new ModelAndView("Home","name",sss+"  ========= Mail Successfull Sent =========");
	}else {
		return new ModelAndView("Home","name",sss+" ========="+"Mail Send Failed Saves in Draft!!=========");
	}}else {
		return new ModelAndView("Login","msg","Login First");
	}
		
	}
	@RequestMapping(value="/draftEditSent",method=RequestMethod.POST)
	public ModelAndView draftEditSentmail(HttpServletRequest req) {
		System.out.println("edit Draft");
		ss=req.getSession(false);
		String sss=(String) ss.getAttribute("email");
		if(sss!=null) {
			
			boolean b=ms.draftEditSent(req);
			if(b){
				return new ModelAndView("Home","name",sss+"  ========= Mail Successfull Sent =========");
			}else {
				return new ModelAndView("Home","name",sss+" ========="+"Mail Send Failed Saves in Draft!!=========");
			}}else {
				return new ModelAndView("Login","msg","Login First");
			}
		
	}
	
	@RequestMapping("/SentInbox")
	public ModelAndView sentInbox(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String sss=(String) ss.getAttribute("email");
		if(sss!=null) {
		List<InfoDTO>plist=ms.sentInbox(sss);
		return new ModelAndView("SentEmail","plist",plist);
		}else {
			
			return new ModelAndView("Login","msg","Login First");
		}
	}
		@RequestMapping("/rStoreSent")
		public ModelAndView resStoreSent(HttpServletRequest req) {
			
			ss=req.getSession(false);
			String sss=(String) ss.getAttribute("email");
			if(sss!=null) {
				List<InfoDTO>plist=ms.reStoreSent(sss);
				return new ModelAndView("SentEmail","plist",plist);
			}else {
				return new ModelAndView("Login","msg","Login First");
			}
		
	}
	@RequestMapping("/Inbox")
	public ModelAndView Inbox(HttpServletRequest req) {

		ss=req.getSession(false);
		String sss=(String) ss.getAttribute("email");
		if(sss!=null) {
		List<InfoDTO>plist=ms.inbox(sss);
		return new ModelAndView("Inbox","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
		
	}
	@RequestMapping("/rStoreInbx")
	public ModelAndView rStoreInbox(HttpServletRequest req) {
		
		ss=req.getSession(false);
		String sss=(String) ss.getAttribute("email");
		if(sss!=null) {
			List<InfoDTO>plist=ms.reStore(sss,"sent");
			return new ModelAndView("Inbox","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
		
	}
	@RequestMapping("/InboxMailShow")
	public ModelAndView InboxShow(HttpServletRequest req) {
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
		InfoDTO indto=ms.inboxShow(req,em);
		return new ModelAndView("InboxShowMail","dto",indto);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
		
	}
	
	@RequestMapping(value="/SentDeletePermanent",method=RequestMethod.POST)
	public ModelAndView InboxShow(@RequestParam int sentDel[],HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
		List<InfoDTO>plist=ms.sentDelete(sentDel,em,"spdelete");
		return new ModelAndView("dSentEmail2","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	@RequestMapping(value="/InboxDeletePermanent",method=RequestMethod.POST)
	public ModelAndView inbtDelete(@RequestParam int inbtDel[],HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		
		if(em!=null) {
			List<InfoDTO>plist=ms.inboxPDelete(inbtDel,em,"ipdelete");
			return new ModelAndView("dInbox2","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
		
	}
	@RequestMapping(value="/DraftDeletePermanent",method=RequestMethod.POST)
	public ModelAndView drfDelete(@RequestParam int drDel[],HttpServletRequest req) {
		
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
			List<InfoDTO>plist=ms.draftPDelete(drDel,em,"dpdelete");
			return new ModelAndView("dDraft2","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
       
	
	@RequestMapping("/Draft")
	public ModelAndView draft(HttpServletRequest req) {
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
	
		if(em!=null) {
		List<InfoDTO>plist=ms.draft(em);
		return new ModelAndView("Draft","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
		}
	@RequestMapping("/rStoreDarft")
	public ModelAndView resStoreDarft(HttpServletRequest req) {
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		
		if(em!=null) {
			List<InfoDTO>plist=ms.reStoreDarft(em);
			return new ModelAndView("Draft","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	@RequestMapping("/dsentf")
	public ModelAndView dsfetch(HttpServletRequest req) {
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		List<InfoDTO>plist=ms.dSentf(em);
		System.out.println(plist.isEmpty());
		if(em!=null) {
		if(plist.isEmpty()) {
			return new ModelAndView("dSentEmail2","sms","Inbox Empty!!");
		}else {
			return new ModelAndView("dSentEmail2","plist",plist);
			
		}}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	@RequestMapping("/ddraft")
	public ModelAndView ddfetch(HttpServletRequest req) {
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
		List<InfoDTO>plist=ms.dDraft(em);
		return new ModelAndView("dDraft2","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}
	@RequestMapping("/dinbox")
	public ModelAndView dinbox(HttpServletRequest req) {
		ss=req.getSession(false);
		String em=(String) ss.getAttribute("email");
		if(em!=null) {
		List<InfoDTO>plist=ms.dInboxf(em);
		return new ModelAndView("dInbox2","plist",plist);
		}else {
			return new ModelAndView("Login","msg","Login First");
		}
	}

}


