package de.kisner.github.jbenkins;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.github.jefa.Bootstrap;
import de.kisner.github.jefa.downloader.JbEfaHttpClient;
import de.kisner.github.jefa.proxy.HttpProxy;

public class TestJbEfaDownloader 
{
	final static Logger logger = LoggerFactory.getLogger(TestJbEfaDownloader.class);
	
	public static void main(String args[]) throws Exception
	{		
		Configuration config = Bootstrap.init();

	}
}