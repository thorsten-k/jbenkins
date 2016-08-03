package de.kisner.jbenkins;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.openfuxml.content.table.Table;
import org.openfuxml.exception.OfxAuthoringException;
import org.openfuxml.renderer.text.OfxTextRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;

import de.kisner.jbenkins.factory.json.JsonJobsFactory;
import de.kisner.jbenkins.factory.ofx.OfxJobsFactory;
import de.kisner.jbenkins.factory.txt.TxtJobFactory;
import de.kisner.jbenkins.model.json.JbenkinsJob;
import de.kisner.jbenkins.model.json.JbenkinsJobs;

public class TestJenkinsConnection 
{
	final static Logger logger = LoggerFactory.getLogger(TestJenkinsConnection.class);
	
	private JenkinsServer jenkins;
	
	public TestJenkinsConnection(JenkinsServer jenkins)
	{
		this.jenkins=jenkins;
	}
	
	public void direct() throws IOException
	{
		Map<String,Job> jobs = jenkins.getJobs();
		
		for(String key : jobs.keySet())
		{
			Job job = jobs.get(key);
			JobWithDetails details = jobs.get(key).details();
			
			logger.info(job.getName()+" "+details.getDisplayName());
			logger.info("\t"+details.getLastBuild().getNumber()+" "+details.getLastBuild().details().isBuilding());
			logger.info("\t"+details.getLastCompletedBuild().getNumber()+" "+details.getLastCompletedBuild().details().getResult().toString());
			logger.info("\t"+details.isInQueue());
		}
	}
	
	public void factory() throws IOException, OfxAuthoringException
	{	
		JbenkinsJobs jobs = JsonJobsFactory.build(jenkins);
//		TxtJsonFactory.output(jobs);	
		OfxTextRenderer.table(OfxJobsFactory.build(jobs), System.out);
	}
	
	public static void main(String args[]) throws Exception
	{		
		Configuration config = Bootstrap.init();
		JenkinsServer jenkins = Bootstrap.jenkins(config);
		
		TestJenkinsConnection cli = new TestJenkinsConnection(jenkins);
//		cli.direct();
		cli.factory();
	}
}