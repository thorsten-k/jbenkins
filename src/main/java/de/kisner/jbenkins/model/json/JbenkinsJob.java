package de.kisner.jbenkins.model.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JbenkinsJob implements Serializable
{
	public static final long serialVersionUID=1;

	
	@JsonProperty("code")
	private String code;
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	@JsonProperty("building")
	private boolean building;
	public boolean isBuilding() {return building;}
	public void setBuilding(boolean building) {this.building = building;}
	
	@JsonProperty("queing")
	private boolean queueing;
	public boolean isQueueing() {return queueing;}
	public void setQueueing(boolean queueing) {this.queueing = queueing;}
	
	@JsonProperty("status")
	private String status;
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	
	
	@Override public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}