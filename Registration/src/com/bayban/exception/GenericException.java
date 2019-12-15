package com.bayban.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class GenericException extends Exception {
	private static final long serialVersionUID = 8396017716295207284L;

	private String code;
	private Object[] params;

	public GenericException(Throwable tr, String code, Object... params) {
		super(tr);
		this.code = code;
		this.params = params;

	}

	public GenericException(String code, Object... params) {
		this(null, code, params);
	}

	public GenericException(Throwable tr, String code) {
		this(new Throwable("THROW CONS-XJASDK", tr), code, new Object[] {});
	}

	public GenericException(String code) {
		this(null, code, new Object[] {});
	}

	public String getStackTraceString() {
		String stacktrace = "";

		if (getCause() != null) {
			StringWriter sw = new StringWriter();
			getCause().printStackTrace(new PrintWriter(sw));
			stacktrace = sw.toString();
		}
		return stacktrace;
	}

	public String getCode() {
		return code;
	}

	public Object[] getParams() {
		return params;
	}

}
