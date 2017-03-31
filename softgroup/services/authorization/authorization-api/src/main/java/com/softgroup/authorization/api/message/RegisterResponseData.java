package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * @author odin
 * @since 20.02.17.
 */
public class RegisterResponseData implements ResponseData {
	private static final long serialVersionUID = -5146888202653750948L;

	private String registrationRequestUUID;

	private long registrationTimeoutSec;

	private String authCode;

	public String getRegistrationRequestUUID() {
		return registrationRequestUUID;
	}

	public void setRegistrationRequestUUID(String registrationRequestUUID) {
		this.registrationRequestUUID = registrationRequestUUID;
	}

	public long getRegistrationTimeoutSec() {
		return registrationTimeoutSec;
	}

	public void setRegistrationTimeoutSec(long registrationTimeoutSec) {
		this.registrationTimeoutSec = registrationTimeoutSec;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
}
