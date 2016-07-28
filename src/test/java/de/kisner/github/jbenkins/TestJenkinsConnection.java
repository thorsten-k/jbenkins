package de.kisner.github.jbenkins;

import java.net.URI;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

public class TestJenkinsConnection 
{
	final static Logger logger = LoggerFactory.getLogger(TestJenkinsConnection.class);
	
	public static void main(String args[]) throws Exception
	{		
		Configuration config = Bootstrap.init();

		String url = config.getString(Bootstrap.cfgUrl);
		String user = config.getString(Bootstrap.cfgUser);
		String pwd = config.getString(Bootstrap.cfgPwd);
		
		logger.info(Bootstrap.cfgUrl+": "+url);
		logger.info(Bootstrap.cfgUser+": "+user);
		logger.info(Bootstrap.cfgPwd+": "+pwd);
		
		JenkinsServer jenkins = new JenkinsServer(new URI(url), user, pwd);
		Map<String,Job> jobs = jenkins.getJobs();
		
		for(String key : jobs.keySet())
		{
			JobWithDetails job = jobs.get(key).details();
			logger.info(job.getDisplayName());
			logger.info("\t"+job.getLastBuild().getNumber()+" "+job.getLastBuild().details().isBuilding());
			logger.info("\t"+job.getLastCompletedBuild().getNumber()+" "+job.getLastCompletedBuild().details().getResult().toString());
		}
		
	}
}