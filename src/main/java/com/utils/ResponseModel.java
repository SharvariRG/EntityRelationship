package com.utils;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModel {
	

  @JsonProperty("message")
  private Object message = null;
	
	  
  @JsonProperty("data")
  private Object data = null;
  
	
  
  public Object getData() {
    return this.data;
  }
  
  public void setData(Object data) {
    this.data = data;
  }
  
	
  public Object getMessage() {
	return message;
}

public void setMessage(Object message) {
	this.message = message;
}

@Override
public String toString() {
	return "ResponseModel [message=" + message + ", data=" + data + "]";
}


}
