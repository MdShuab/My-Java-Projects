package com.shuaib.gmailspring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shuaib.gmailspring.model.InfoDTO;
import com.shuaib.gmailspring.model.RegDTO;

public interface MyService {

	public boolean regUser(RegDTO rdto);
	public boolean sent(HttpServletRequest req);
	public List<InfoDTO> sentInbox(String em);
	public String login(HttpServletRequest req);
	public List<InfoDTO> inbox(String em);
	public List<InfoDTO> draft(String em);
	public boolean forgPw(HttpServletRequest req);
	public boolean chngPw(HttpServletRequest req);
	public boolean dInbox(HttpServletRequest req, String string);
	public List<InfoDTO> dSentf(String em);
	public List<InfoDTO> dDraft(String em);
	public List<InfoDTO> dInboxf(String em);
	public InfoDTO inboxShow(HttpServletRequest req, String em);
	public InfoDTO editDraft(HttpServletRequest req);
	public RegDTO profile(String em);
	public boolean updateProfile(HttpServletRequest req);
	public boolean accDelete(String em);
	public List<InfoDTO> sentDelete(int[] d, String em, String pdel);
	public List<InfoDTO> inboxPDelete(int[] inbtDel, String em, String string);
	public List<InfoDTO> draftPDelete(int[] drDel, String em, String string);
	public List<InfoDTO> reStore(String sss, String string);
	public List<InfoDTO> reStoreDarft(String em);
	public List<InfoDTO> reStoreSent(String sss);
	public int visitTime(String em);
	public boolean draftEditSent(HttpServletRequest req);
}
