package com.test.model;

import java.util.ArrayList;
import java.util.List;

import com.linecorp.bot.model.message.Message;

public class PushAPIInfo {
	private final String channelToken;
	private final String to; 		//userID
	private List<Message> userMessagelist= new ArrayList<Message>();
	
	public PushAPIInfo(String channelToken,String to) {
		this.channelToken=channelToken;
		this.to=to;
	}
	public String getchannelToken() {
		return this.channelToken;
	}
	public String getUserID() {
		return this.to;
	}
	public List<Message> getMessagelist() {
		return this.userMessagelist;
	}
	public void msglistadd(Message msg) {
		userMessagelist.add(msg);
	}
}
