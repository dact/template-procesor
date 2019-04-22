package com.velocity.velocityProcesor;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VelocityProcesorApplicationTests {

	@Test
	public void contextLoads() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();

		String strTemplate = "file-test.vm";

		Template t = velocityEngine.getTemplate("src/main/resources/templates/"+strTemplate);

		VelocityContext context = new VelocityContext();
		context.put("nombreyapellido", "Juan Martinez");
		context.put("celular", "aqui va celular");

		StringWriter writer = new StringWriter();
		t.merge( context, writer );

		System.out.println(writer.toString());
	}

}
