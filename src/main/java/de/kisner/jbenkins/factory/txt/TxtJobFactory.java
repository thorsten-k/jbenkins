package de.kisner.jbenkins.factory.txt;

import java.io.Serializable;

import de.kisner.jbenkins.model.json.JbenkinsJob;

public class TxtJobFactory implements Serializable
{
	public static final long serialVersionUID=1;

	public static String build(JbenkinsJob job)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(job.getCode());
		return sb.toString();
	}
}