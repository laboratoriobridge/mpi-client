package br.ufsc.bridge.mpiclient.thymeleaf;

import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class TemplateSerializer {

	public String serialize(String templateName, Map<String, Object> variables) {
		TemplateEngine templateEngine = new TemplateEngine();
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setTemplateMode(TemplateMode.XML);
		templateResolver.setCharacterEncoding("UTF-8");
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(new Java8TimeDialect());
		Context context = new Context();
		context.setVariables(variables);
		return templateEngine.process(templateName, context).replaceAll("(?m)^[ \t]*\r?\n", "");
	}

}
