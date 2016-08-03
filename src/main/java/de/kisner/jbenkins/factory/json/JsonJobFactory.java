package de.kisner.jbenkins.factory.json;

import java.io.IOException;
import java.io.Serializable;

import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

import de.kisner.jbenkins.model.json.JbenkinsJob;

public class JsonJobFactory implements Serializable
{
	public static final long serialVersionUID=1;

	public static JbenkinsJob build(Job job) throws IOException
	{
		JobWithDetails details = job.details();
		
		JbenkinsJob json = new JbenkinsJob();
		json.setCode(job.getName());
		json.setBuilding(details.getLastBuild().details().isBuilding());
		json.setQueueing(details.isInQueue());
		json.setStatus(details.getLastCompletedBuild().details().getResult().toString());
		
		return json;
	}
}