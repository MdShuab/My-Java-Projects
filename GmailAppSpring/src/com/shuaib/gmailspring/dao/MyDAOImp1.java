package com.shuaib.gmailspring.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shuaib.gmailspring.model.InfoDTO;
import com.shuaib.gmailspring.model.RegDTO;

@Component
public class MyDAOImp1 implements MyDAO{
 @Autowired
 SessionFactory sf;
 HttpSession ss=null;
 Date d=new Date();
 int i;
 

 
 
 
	@Override
	public boolean regUser(RegDTO rdto) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		 Criteria cr =ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email", rdto.getEmail()));
		 RegDTO dto=(RegDTO) cr.uniqueResult();
		if(dto==null) {
			
			d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			try {
				d=sdf.parse(sdf.format(d));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		rdto.setLoginTime(d);
		rdto.setCount(0);
		ss.save(rdto);
		ss.beginTransaction().commit();
		ss.close();
		return true;
		}else {
			return false;
		}
		
	}
	
	
//	===============================Login DATE()=============================
	@Override
	public String login(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String pw=req.getParameter("password");
		String email=req.getParameter("email");
		Session ss=sf.openSession();
		
		 SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		 Date dd=null;
			try {
				d=new Date();
				dd = df.parse(df.format(d));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  Criteria cr =ss.createCriteria(RegDTO.class);
		  cr.add(Restrictions.eq("password",pw));
		  cr.add(Restrictions.eq("email",email));
		 RegDTO dto=(RegDTO) cr.uniqueResult();
		//ss.beginTransaction().commit();
		
	
		if(dto!=null&&dto.getCount()<=2){
								
									dto.setLoginTime(dd);
							    	 dto.setCount(0); 
							    	ss.update(dto);
									ss.beginTransaction().commit();
								ss.close();
							return "success";
								
		}else {
			Criteria cr1 =ss.createCriteria(RegDTO.class);
			 cr1.add(Restrictions.eq("email",email));
			  RegDTO dto1=(RegDTO) cr1.uniqueResult();
			  
			  if(dto1!=null) { 
		    if(dto1.getCount()==0) {
		    	d=new Date();
		    	i=dto1.getCount();
		    df=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			try {
				dd = df.parse(df.format(d));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("insu "+i);
			dto1.getCount();
			 dto1.setCount(++i); 
			dto1.setLoginTime(dd);
			ss.update(dto1);
			ss.beginTransaction().commit();
			ss.close();
			//i++;
			return "Incorrect Password";
		    }
		    else if(dto1.getCount()>=1&&dto1.getCount()<=2) {
		    	System.out.println(i);
		    	i=dto1.getCount();
		    	 dto1.setCount(++i); 
		    	ss.update(dto1);
				ss.beginTransaction().commit();
				ss.close();
				//i++;
				return "Incorrect Password";
		    }
		    else if(dto!=null&&(((dd.getHours()*60)+dd.getMinutes())-((dto1.getLoginTime().getHours()*60)+dto1.getLoginTime().getMinutes())>=3)) {
		    	
		    	System.out.println("hello inside dd get "+pw+" "+dd.getMinutes());
		    	dto1.setLoginTime(dd);
		    	 dto1.setCount(0); 
		    	ss.update(dto1);
				ss.beginTransaction().commit();
				ss.close();
		    	return "Success";
		    	
		    }
		    else if (dto1!=null&&(((dd.getHours()*60)+dd.getMinutes())-((dto1.getLoginTime().getHours()*60)+dto1.getLoginTime().getMinutes())<=3))  {
		    	System.out.println("Date "+((dd.getMinutes())-(dto1.getLoginTime()).getMinutes()));
		    	System.out.println("login d "+dto1.getLoginTime().getMinutes());
		    	System.out.println("new d "+dd.getMinutes());
		    	
		    	return "Try Limit Exeed!! Your Account Locked for 3 min";
		    }
		    else {
		    	
		    	return "Your Account Has been Unlock Enter Correct Crendential";
		    }
			
			
			  }else {
				  System.out.println("outer Else ...");
				  return "Mail Id Inccorrect";
			  }
		}
	}
	@Override
	public boolean sent(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String	tem=req.getParameter("email");
		String ibx=	req.getParameter("uinbox");
		String sub=req.getParameter("msub");
		this.ss=req.getSession(false);
		String memail=(String) this.ss.getAttribute("email");
		Session ss=sf.openSession();
		
		InfoDTO idto=null;
		Query qry=ss.createQuery("from RegDTO where email='"+tem+"'");
		RegDTO rdto=(RegDTO) qry.uniqueResult();
		List<InfoDTO>ilist;  
		
		
		d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		try {
			d=sdf.parse(sdf.format(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(rdto!=null) {
			
		
			idto=new InfoDTO();
			idto.setUto(tem); 
			idto.setUinbox(ibx);
			idto.setUsent(memail);
			idto.setMsub(sub); 
			idto.setStatus("sent");
			idto.setMailTime(d);
			idto.setUdraft(null);
			ilist=rdto.getInfolist();
			ilist.add(idto);
			ss.saveOrUpdate(rdto);
			ss.beginTransaction().commit();
			ss.close();
		return true;
		}else {
				idto=new InfoDTO(); 
				idto.setUdraft(tem);
				idto.setMsub(sub);
				idto.setUsent(memail); 
				idto.setUinbox(ibx);
				idto.setMailTime(d); 
				idto.setStatus("draft");
				qry=ss.createQuery("from RegDTO where email='"+memail+"'");
				rdto=(RegDTO) qry.uniqueResult();
				ilist=rdto.getInfolist();
				ilist.add(idto);
				ss.saveOrUpdate(rdto);
				ss.beginTransaction().commit();
				ss.close();
			return false;
		}
	}
	@Override
	public List<InfoDTO> sentInbox(String em) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		//Query qry=ss.createQuery("from InfoDTO where usent='"+em+"' and uinbox NOT '"+null+"'");
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("usent", em));
	//	cr.add(Restrictions.eq("status", "sent"));
		cr.add(Restrictions.ne("status", "deleteDraft"));
		cr.add(Restrictions.isNotNull("uto"));
		cr.add(Restrictions.ne("status","deleteSent"));
		
		
		List<InfoDTO>ilist=cr.list();
		ss.close();
		return ilist;
	}
	@Override
	public List<InfoDTO> inbox(String em) {
		// TODO Auto-generated method stub
		System.out.println(em);
		Session ss=sf.openSession();
	//	Query qry=ss.createQuery("from InfoDTO where uto='"+em+"'");
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("uto", em));
		cr.add(Restrictions.ne("status", "deleteDraft"));
		cr.add(Restrictions.ne("status", "deleteInbox"));
		cr.add(Restrictions.isNull("udraft"));
		//cr.add(Restrictions.isNotNull("uto"));
	
		List<InfoDTO>ilist=cr.list();
		ss.close();
		return ilist;
	}
	@Override
	public List<InfoDTO> draft(String em) {
		// TODO Auto-generated method stub
		
		Session ss=sf.openSession();
		//Query qry=ss.createQuery("from InfoDTO where usent='"+em+"' and uinbox='"+null+"'" );
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("usent", em));
		cr.add(Restrictions.isNull("uto"));
		cr.add(Restrictions.isNotNull("udraft"));
		cr.add(Restrictions.eq("status", "draft"));
		List<InfoDTO>ilist=cr.list();
		ss.close();
		return ilist;
		
	}
	@Override
	public boolean forgPw(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email", req.getParameter("email")));
		RegDTO rdto=(RegDTO) cr.uniqueResult();
		
		if(rdto!=null) {
			rdto.setPassword(req.getParameter("password2"));
			ss.update(rdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
		
		return false;
		}
	}
	@Override
	public boolean chngPw(HttpServletRequest req) {
		Session ss=sf.openSession();
		this.ss=req.getSession(false);
		String mem=(String) this.ss.getAttribute("email");
		Criteria cr=ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email",mem ));
		RegDTO rdto=(RegDTO) cr.uniqueResult();
		
		if(rdto!=null) {
			rdto.setPassword(req.getParameter("password2"));
			ss.update(rdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
		
		return false;
		}
	}

	@Override
	public boolean dInbox(HttpServletRequest req,String string) {
		Session ss=sf.openSession();
		this.ss=req.getSession(false);
		String mem=(String) this.ss.getAttribute("email");
		Criteria cr=ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email",mem ));
		RegDTO rdto=(RegDTO) cr.uniqueResult();
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		Criteria cr1=ss.createCriteria(InfoDTO.class);
		cr1.add(Restrictions.eq("infid", id));
		InfoDTO idto=(InfoDTO) cr1.uniqueResult();
		
		
		if(idto!=null)
		{ 
		     idto.setStatus(string);
			List<InfoDTO>ilist=rdto.getInfolist();
			ilist.add(idto);
			ss.update(rdto);;
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else
			return false;
	
	
	}

	@Override
	public List<InfoDTO> dSentf(String em) {
		// TODO Auto-generated method stub
				Session ss=sf.openSession();
				//Query qry=ss.createQuery("from InfoDTO where usent='"+em+"' and uinbox NOT '"+null+"'");
				Criteria cr=ss.createCriteria(InfoDTO.class);
				cr.add(Restrictions.eq("usent", em));
				cr.add(Restrictions.eq("status","deleteSent"));
				cr.add(Restrictions.isNull("udraft"));
				List<InfoDTO>ilist=cr.list(); 
				ss.close();
				return ilist;
	}
	@Override
	public List<InfoDTO> dDraft(String em) {
		Session ss=sf.openSession();
		//Query qry=ss.createQuery("from InfoDTO where usent='"+em+"' and uinbox NOT '"+null+"'");
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("usent", em));
		cr.add(Restrictions.eq("status","deleteDraft"));
		List<InfoDTO>ilist=cr.list();
		ss.close();
		return ilist;
	}
	@Override
	public List<InfoDTO> dInboxf(String em) {
		Session ss=sf.openSession();
		//Query qry=ss.createQuery("from InfoDTO where usent='"+em+"' and uinbox NOT '"+null+"'");
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("uto", em));
		cr.add(Restrictions.eq("status", "deleteInbox"));
		List<InfoDTO>ilist=cr.list();
		ss.close();
		return ilist;
	}
	@Override
	public InfoDTO inboxShow(HttpServletRequest req, String em) {
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		Session ss=sf.openSession();
	//	Query qry=ss.createQuery("from InfoDTO where uto='"+em+"'");
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("infid", id));
		cr.add(Restrictions.eq("uto", em));
		cr.add(Restrictions.ne("status", "deleteDraft"));
		cr.add(Restrictions.isNull("udraft"));
		//cr.add(Restrictions.isNotNull("uto"));
	
		InfoDTO dto=(InfoDTO) cr.uniqueResult();
		ss.close();
		return dto;
	}
	@Override
	public InfoDTO editDraft(HttpServletRequest req) {
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		Session ss=sf.openSession();
		//Query qry=ss.createQuery("from InfoDTO where usent='"+em+"' and uinbox='"+null+"'" );
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("infid",id));
		cr.add(Restrictions.eq("status", "draft"));
		InfoDTO dto=(InfoDTO) cr.uniqueResult();
		ss.close();
		return dto;
	}


	@Override
	public RegDTO profile(String em) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		 Criteria cr =ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email", em));
		 RegDTO dto=(RegDTO) cr.uniqueResult();
 
		return dto;
	}


	@Override
	public boolean updateProfile(HttpServletRequest req) {
		Session ss=sf.openSession();
		this.ss=req.getSession(false);
		String em=(String) this.ss.getAttribute("email");
		 Criteria cr =ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email", em));
		 RegDTO dto=(RegDTO) cr.uniqueResult();
		if(dto!=null) {
		 dto.setAddress(req.getParameter("address"));
		 dto.setNum(req.getParameter("num"));
		 dto.setUn(req.getParameter("un"));
		 ss.save(dto);
		 ss.beginTransaction().commit();
		 ss.close();
		 return true;
		}
		 
		else {
		return false;
		}
	}


	@Override
	public boolean accDelete(String em) {
		
		Session ss=sf.openSession();
		 Criteria cr =ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email", em));
		 RegDTO dto=(RegDTO) cr.uniqueResult();
		 ss.delete(dto);
		 ss.beginTransaction().commit();
		 ss.close();
		  
		return true;
	}


	@Override
	public List<InfoDTO> sentDelete(int[] d,String em, String pdel) {
		
		Session ss=sf.openSession();
		
		for (int i : d) {
			InfoDTO idto=ss.load(InfoDTO.class, i);
			idto.setStatus(pdel);
			ss.update(idto);
			ss.beginTransaction().commit();
		}
		
		 
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("usent", em));
		cr.add(Restrictions.eq("status","deleteSent"));
		cr.add(Restrictions.isNull("udraft"));
		List<InfoDTO>ilist =cr.list(); 
		ss.close();
		return ilist;
	}


	@Override
	public List<InfoDTO> inboxPDelete(int[] inbtDel, String em, String string) {
		
		Session ss=sf.openSession();
		
		for (int i : inbtDel) {
			InfoDTO idto=ss.load(InfoDTO.class, i);
			idto.setStatus(string);
			ss.update(idto);  
			ss.beginTransaction().commit();
		}
	
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("uto", em));
		cr.add(Restrictions.eq("status", "deleteInbox"));
		List<InfoDTO>ilist=cr.list();
		ss.close();
		
		return ilist;
	}


	@Override
	public List<InfoDTO> draftPDelete(int[] drDel, String em, String string) {
		
		Session ss=sf.openSession();
		for (int i : drDel) {
			InfoDTO idto=ss.load(InfoDTO.class, i);
			idto.setStatus(string);
			ss.update(idto);
			ss.beginTransaction().commit();
		}
		
		Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("usent", em));
		cr.add(Restrictions.eq("status","deleteDraft"));
		List<InfoDTO>ilist=cr.list();
		ss.close();
		return ilist;
		
	}


	@Override
	public List<InfoDTO> reStore(String sss, String string) {
		// TODO Auto-generated method stub
		
		Session ss=sf.openSession();
		Query qry=ss.createQuery("update InfoDTO set status='"+string+"' where uto='"+sss+"' and (status='"+"ipdelete"+"' or status='"+"deleteInbox"+"') ");
	    qry.executeUpdate();
	    ss.beginTransaction().commit();
	    
	    
	    Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("uto", sss));
		cr.add(Restrictions.ne("status", "deleteDraft"));
		cr.add(Restrictions.ne("status", "deleteInbox"));
		cr.add(Restrictions.isNull("udraft"));
		//cr.add(Restrictions.isNotNull("uto"));
	
		List<InfoDTO>ilist=cr.list();
	    
		return ilist;
	}


	@Override
	public List<InfoDTO> reStoreDarft(String em) {
		// TODO Auto-generated method stub
		
		Session ss=sf.openSession();
		Query qry=ss.createQuery("update InfoDTO set status='"+"draft"+"' where usent='"+em+"' and (status='"+"deleteDraft"+"' or status='"+"dpdelete"+"') ");
	    qry.executeUpdate();
	    ss.beginTransaction().commit();
	    
	    Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("usent", em));
		cr.add(Restrictions.isNull("uto"));
		cr.add(Restrictions.isNotNull("udraft"));
		cr.add(Restrictions.eq("status", "draft"));
		List<InfoDTO>ilist=cr.list();
		ss.close();
		return ilist;
	}


	@Override
	public List<InfoDTO> reStoreSent(String sss) {
		Session ss=sf.openSession();
		Query qry=ss.createQuery("update InfoDTO set status='"+"sent"+"' where usent='"+sss+"' and (status='"+"deleteSent"+"' or status='"+"spdelete"+"') ");
	    qry.executeUpdate();
	    ss.beginTransaction().commit();
	    
	    Criteria cr=ss.createCriteria(InfoDTO.class);
		cr.add(Restrictions.eq("usent", sss));
	//	cr.add(Restrictions.eq("status", "sent"));
		cr.add(Restrictions.ne("status", "deleteDraft"));
		cr.add(Restrictions.isNotNull("uto"));
		cr.add(Restrictions.ne("status","deleteSent"));
		List<InfoDTO>ilist=cr.list();
		ss.close();
		return ilist; 
	    
	}


	@Override
	public int visitTime(String em) {

		Session ss=sf.openSession();
		 Criteria cr =ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email", em));
		 RegDTO dto=(RegDTO) cr.uniqueResult();
		 
		 
		 d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			try {
				d=sdf.parse(sdf.format(d));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int lt, ct=d.getHours()*60+d.getMinutes();
			lt=dto.getLoginTime().getHours()*60+dto.getLoginTime().getMinutes();
			
		return (ct-lt);
	}


	@Override
	public boolean draftEditSent(HttpServletRequest req) {
			String sid=req.getParameter("infid");
		int id =Integer.parseInt(sid);
		String ibx=	req.getParameter("uinbox");
		String tem=	req.getParameter("email");
		String sub=req.getParameter("msub");
		this.ss=req.getSession(false);
		String memail=(String) this.ss.getAttribute("email");
		Session ss=sf.openSession();
		
		
		Query qry=ss.createQuery("from InfoDTO where infid='"+id+"'");
		InfoDTO idto=(InfoDTO) qry.uniqueResult();
		
		Query qry1=ss.createQuery("from RegDTO  where email='"+tem+"'");
		RegDTO rdto1=(RegDTO) qry1.uniqueResult();
		List<InfoDTO>ilist; 
		
		
		Criteria cr=ss.createCriteria(RegDTO.class);
		cr.add(Restrictions.eq("email", memail));
		RegDTO rdto=(RegDTO) cr.uniqueResult();
		
//		Criteria cr1=ss.createCriteria(RegDTO.class);
//		cr1.add(Restrictions.eq("email", t));
//		RegDTO rdto=(RegDTO) cr1.uniqueResult();
		
		d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		try {
			d=sdf.parse(sdf.format(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		if(rdto1!=null) {
			
			idto.setUto(tem); 
			idto.setUinbox(ibx);
			idto.setUsent(memail);
			idto.setMsub(sub); 
			idto.setStatus("sent");
			idto.setMailTime(d);
			idto.setUdraft(null);
			ilist=rdto.getInfolist();
			ilist.add(idto);
			ss.update(rdto);
			ss.beginTransaction().commit();
			ss.close();
		return true;
		}else {
				
				idto.setUdraft(tem);
				idto.setMsub(sub);
				idto.setUsent(memail); 
				idto.setUinbox(ibx);
				idto.setMailTime(d); 
				idto.setStatus("draft");
				ilist=rdto.getInfolist();
				ilist.add(idto);
				ss.update(rdto);
				ss.beginTransaction().commit();
				ss.close();
			return false;
		}

	}
 	

}
