package org.Bank.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;

public class Response {
	

	private  String message;
	
	private boolean status;
public Response() {
	// TODO Auto-generated constructor stub
}
public Response(String message, boolean status) {
	super();
	 this.message = message;
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
@Override
public String toString() {
	return "Responce [message=" + message + ", status=" + status + "]";
}
 
}
