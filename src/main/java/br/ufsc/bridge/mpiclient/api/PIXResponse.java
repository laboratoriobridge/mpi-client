package br.ufsc.bridge.mpiclient.api;

import lombok.Getter;

import org.apache.commons.lang3.StringUtils;

@Getter
public class PIXResponse {

	private String errorMessage;

	public void appendErrorMessage(String errorMessage) {
		this.errorMessage = StringUtils.trimToEmpty(this.errorMessage) + StringUtils.trimToEmpty(errorMessage);
	}

}
