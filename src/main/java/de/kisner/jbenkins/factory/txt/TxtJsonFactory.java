package de.kisner.jbenkins.factory.txt;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TxtJsonFactory implements Serializable
{
	public static final long serialVersionUID=1;

	public static void output(Object o)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			StringWriter sw = new StringWriter();
			mapper.writeValue(sw, o);
			System.out.println(sw.toString());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}