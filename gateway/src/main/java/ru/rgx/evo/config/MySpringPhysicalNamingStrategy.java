package ru.rgx.evo.config;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class MySpringPhysicalNamingStrategy extends CamelCaseToUnderscoresNamingStrategy
		implements ApplicationContextAware {

	private final StandardEvaluationContext context = new StandardEvaluationContext();
	private final SpelExpressionParser parser = new SpelExpressionParser();

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context.addPropertyAccessor(new BeanFactoryAccessor());
		context.setBeanResolver(new BeanFactoryResolver(applicationContext));
		context.setRootObject(applicationContext);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
		String nameStr = name.getText();
		if (nameStr.contains(ParserContext.TEMPLATE_EXPRESSION.getExpressionPrefix())) {
			Expression expression = this.parser.parseExpression(nameStr, ParserContext.TEMPLATE_EXPRESSION);
			return Identifier.toIdentifier((String) expression.getValue(this.context, String.class));
		} else {
			return super.toPhysicalTableName(name, jdbcEnvironment);
		}
	}
}
