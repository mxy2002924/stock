package com.zero.stock.dao;

public class DaoRequestException extends RuntimeException{
	private static final long serialVersionUID = -4062814805184644877L;

	public DaoRequestException(String msg) {
		super(msg);
	}
	public DaoRequestException(Throwable e) {
		super(e);
	}
	public DaoRequestException(String msg,Throwable throwable) {
		super(msg,throwable);
	}
	
}
