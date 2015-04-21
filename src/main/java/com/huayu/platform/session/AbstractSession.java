package com.huayu.platform.session;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSession implements Session, Serializable {
	private static final long serialVersionUID = 4901401585131620726L;

	private static final String MY_SESSION_ID = "MYDegSESSIONID";

	private static final Logger logger = LoggerFactory
			.getLogger(AbstractSession.class);

}
