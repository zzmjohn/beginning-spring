package com.wiley.beginningspring.ch2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CommandManager implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	public void execute() {
		createCommand().execute(new CommandContext());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	private Command createCommand() {
		return applicationContext.getBean(Command.class);
	}
}
