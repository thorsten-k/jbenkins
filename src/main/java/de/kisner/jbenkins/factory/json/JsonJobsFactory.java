package de.kisner.jbenkins.factory.json;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;

import de.kisner.jbenkins.model.json.JbenkinsJobs;

public class JsonJobsFactory implements Serializable
{
	public static final long serialVersionUID=1;

	public static JbenkinsJobs build(JenkinsServer jenkins) throws IOException
	{
		JbenkinsJobs json = new JbenkinsJobs();
		
		Map<String,Job> jobs = jenkins.getJobs();
		for(String key : jobs.keySet())
		{
			json.getJobs().add(JsonJobFactory.build(jobs.get(key)));
		}
		
		return json;
	}
}