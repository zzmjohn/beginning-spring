package com.wiley.beginningspring.ch4;

import org.springframework.dao.DataAccessException;

public class DeleteFailedException extends DataAccessException {
	public DeleteFailedException(String msg) {
		super(msg);
	}
}
