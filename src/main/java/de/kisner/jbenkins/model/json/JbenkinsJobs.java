package de.kisner.jbenkins.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JbenkinsJobs implements Serializable
{
	public static final long serialVersionUID=1;

	@JsonProperty("jbos")
	private List<JbenkinsJob> jobs;
	public List<JbenkinsJob> getJobs() {if(jobs==null){jobs = new ArrayList<>();}return jobs;}
	public void setJobs(List<JbenkinsJob> jobs) {this.jobs = jobs;}

	@Override public String toString()
	{
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
}