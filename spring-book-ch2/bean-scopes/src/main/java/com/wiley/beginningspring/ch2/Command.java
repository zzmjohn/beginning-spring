package com.wiley.beginningspring.ch2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("protoype")
public class Command {

	public void execute(CommandContext commandContext) {
		
	}

}
