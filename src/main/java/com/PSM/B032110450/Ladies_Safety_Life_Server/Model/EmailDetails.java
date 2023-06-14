package com.PSM.B032110450.Ladies_Safety_Life_Server.Model;


//Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotations

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailDetails {

	private String recipient;
	private String msgBodyString;
	private String subject;
	private String attachment;
	
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMsgBodyString() {
		return msgBodyString;
	}
	public void setMsgBodyString(String msgBodyString) {
		this.msgBodyString = msgBodyString;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
}
