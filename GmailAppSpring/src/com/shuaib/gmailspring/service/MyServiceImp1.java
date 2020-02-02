package com.shuaib.gmailspring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shuaib.gmailspring.dao.MyDAO;
import com.shuaib.gmailspring.model.InfoDTO;
import com.shuaib.gmailspring.model.RegDTO;
@Component
public class MyServiceImp1 implements MyService{
 @Autowired
 MyDAO md;
	@Override
	public boolean regUser(RegDTO rdto) {
		// TODO Auto-generated method stub
		return md.regUser(rdto);
	}
	@Override
	public String login(HttpServletRequest req) {
		// TODO Auto-generated method stub
	   
		return md.login(req);
	}
	@Override
	public boolean sent(HttpServletRequest req) {
		// TODO Auto-generated method stub
		boolean b=md.sent(req);
		return b;
	}
	@Override
	public List<InfoDTO> sentInbox(String em) {
		// TODO Auto-generated method stub
		
		return md.sentInbox(em);
	}
	@Override
	public List<InfoDTO> inbox(String em) {
		// TODO Auto-generated method stub
		
		return md.inbox(em);
	}
	@Override
	public List<InfoDTO> draft(String em) {
		// TODO Auto-generated method stub
		return md.draft(em);
	}
	@Override
	public boolean forgPw(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return md.forgPw(req);
	}
	@Override
	public boolean chngPw(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return md.chngPw(req);
	}

	@Override
	public boolean dInbox(HttpServletRequest req,String string) {
		// TODO Auto-generated method stub
		return md.dInbox(req,string);
	}

	@Override
	public List<InfoDTO> dSentf(String em) {
		// TODO Auto-generated method stub
		return md.dSentf(em);
	}
	@Override
	public List<InfoDTO> dDraft(String em) {
		// TODO Auto-generated method stub
		return md.dDraft(em);
	}
	@Override
	public List<InfoDTO> dInboxf(String em) {
		// TODO Auto-generated method stub
		return md.dInboxf(em);
	}
	@Override
	public InfoDTO inboxShow(HttpServletRequest req, String em) {
		// TODO Auto-generated method stub
		return md.inboxShow(req, em);
	}
	@Override
	public InfoDTO editDraft(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return md.editDraft(req);
	}
	@Override
	public RegDTO profile(String em) {
		// TODO Auto-generated method stub
		return md.profile(em);
	}
	@Override
	public boolean updateProfile(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return md.updateProfile(req);
	}
	@Override
	public boolean accDelete(String em) {
		// TODO Auto-generated method stub
		return md.accDelete(em);
	}
	@Override
	public List<InfoDTO> sentDelete(int[] d,String em, String pdel) {
		// TODO Auto-generated method stub
		return md.sentDelete(d,em,pdel);
	}
	@Override
	public List<InfoDTO> inboxPDelete(int[] inbtDel, String em, String string) {
		// TODO Auto-generated method stub
		return md.inboxPDelete(inbtDel, em, string);
	}
	@Override
	public List<InfoDTO> draftPDelete(int[] drDel, String em, String string) {
		// TODO Auto-generated method stub
		return md.draftPDelete(drDel, em, string);
	}
	@Override
	public List<InfoDTO> reStore(String sss, String string) {
		// TODO Auto-generated method stub
		return md.reStore(sss, string);
	}
	@Override
	public List<InfoDTO> reStoreDarft(String em) {
		// TODO Auto-generated method stub
		return md.reStoreDarft(em);
	}
	@Override
	public List<InfoDTO> reStoreSent(String sss) {
		// TODO Auto-generated method stub
		return md.reStoreSent(sss);
	}
	@Override
	public int visitTime(String em) {
		// TODO Auto-generated method stub
		return md.visitTime(em);
	}
	@Override
	public boolean draftEditSent(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return md.draftEditSent(req);
	}
	

}
