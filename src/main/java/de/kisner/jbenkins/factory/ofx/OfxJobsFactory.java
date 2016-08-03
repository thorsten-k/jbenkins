package de.kisner.jbenkins.factory.ofx;

import java.io.IOException;
import java.io.Serializable;

import org.openfuxml.content.table.Body;
import org.openfuxml.content.table.Content;
import org.openfuxml.content.table.Head;
import org.openfuxml.content.table.Row;
import org.openfuxml.content.table.Table;
import org.openfuxml.factory.xml.table.OfxCellFactory;

import de.kisner.jbenkins.model.json.JbenkinsJob;
import de.kisner.jbenkins.model.json.JbenkinsJobs;

public class OfxJobsFactory implements Serializable
{
	public static final long serialVersionUID=1;

	public static String[] columnNames = {"Job"};
	
	public static Table build(JbenkinsJobs jobs) throws IOException
	{
		Table table = new Table();
		
		Content content = new Content();
		content.setHead(buildHead());
		content.getBody().add(buildBody(jobs));
		table.setContent(content);		
		return table;
	}
	
	private static Head buildHead()
	{
		Row row = new Row();
		row.getCell().add(OfxCellFactory.createParagraphCell("Job"));
		row.getCell().add(OfxCellFactory.createParagraphCell("Status"));
		row.getCell().add(OfxCellFactory.createParagraphCell("Building"));
		row.getCell().add(OfxCellFactory.createParagraphCell("Queue"));
		
		Head head = new Head();
		head.getRow().add(row);
		return head;
	}
	
	private static Body buildBody(JbenkinsJobs jobs)
	{
		Body body = new Body();
		for(JbenkinsJob job : jobs.getJobs())
		{
			body.getRow().add(buildRow(job));
		}
		return body;
	}
	
	private static Row buildRow(JbenkinsJob job)
	{		
		Row row = new Row();
		row.getCell().add(OfxCellFactory.paragraph(job.getCode()));
		row.getCell().add(OfxCellFactory.paragraph(job.getStatus()));
		row.getCell().add(OfxCellFactory.paragraph(""+job.isBuilding()));
		row.getCell().add(OfxCellFactory.paragraph(""+job.isQueueing()));
		
		return row;
	}
}