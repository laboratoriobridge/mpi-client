package br.ufsc.bridge.mpiclient.api;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import br.ufsc.bridge.soap.http.SoapHttpClient;

@Getter
@Builder
@RequiredArgsConstructor
public class MPIClientOptions {
	@NonNull
	private String pixUrl;
	@NonNull
	private String pdqUrl;
	@NonNull
	private String user;
	@NonNull
	private String password;
	@NonNull
	@Builder.Default
	private SoapHttpClient client = new SoapHttpClient();
}
