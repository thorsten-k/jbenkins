package de.kisner.github.jbenkins;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.exlp.exception.ExlpConfigurationException;
import net.sf.exlp.util.config.ConfigLoader;
import net.sf.exlp.util.io.ExlpCentralConfigPointer;
import net.sf.exlp.util.io.LoggerInit;

public class Bootstrap
{
	final static Logger logger = LoggerFactory.getLogger(Bootstrap.class);

	public final static String xmlConfig = "jbenkins/config/jbenkins.xml";
	public static String cfgUrl = "rest.jenkins.url";
	public static String cfgUser = "rest.jenkins.user";
	public static String cfgPwd = "rest.jenkins.pwd";
	
	private static Configuration config;
	
	public static Configuration init()
	{
		return init(xmlConfig);
	}
	
	public static Configuration init(String configFile)
	{
		LoggerInit loggerInit = new LoggerInit("log4j.xml");
		loggerInit.addAltPath("jbenkins/config");
		loggerInit.init();

		try
		{
			String cfn = ExlpCentralConfigPointer.getFile("jbenkins","app").getAbsolutePath();
			ConfigLoader.add(cfn);
			logger.info("Using additional config in: "+cfn );
		}
		catch (ExlpConfigurationException e) {logger.debug("No additional "+ExlpCentralConfigPointer.class.getSimpleName()+" because "+e.getMessage());}
		ConfigLoader.add(configFile);
		
		config = ConfigLoader.init();

		return config;
	}
}