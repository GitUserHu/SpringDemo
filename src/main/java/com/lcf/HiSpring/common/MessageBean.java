package com.lcf.HiSpring.common;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("msg")
@Scope("singleton")
public class MessageBean {
	private List<String> msg;

	public List<String> getMsg() {
		return msg;
	}

	public void setMsg(List<String> msg) {
		this.msg = msg;
	}
	
	

	
	
}
