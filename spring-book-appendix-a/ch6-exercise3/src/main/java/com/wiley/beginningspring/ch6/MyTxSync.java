package com.wiley.beginningspring.ch6;

import org.springframework.transaction.support.TransactionSynchronization;

public class MyTxSync implements TransactionSynchronization {

	@Override
	public void suspend() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeCommit(boolean readOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeCompletion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCommit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(int status) {
		switch (status) {
		case TransactionSynchronization.STATUS_COMMITTED:
			System.out.println("tx commited");
			break;
		case TransactionSynchronization.STATUS_ROLLED_BACK:
			System.out.println("tx rollbacked");
			break;
		default:
			System.out.println("unknown status :" + status);
		}
	}
}
