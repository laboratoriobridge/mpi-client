package br.ufsc.bridge.mpiclient.http;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import lombok.extern.slf4j.Slf4j;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

import br.ufsc.bridge.mpiclient.exceptions.MPIRuntimeException;
import br.ufsc.bridge.soap.http.SoapHttpClient;

@Slf4j
public class TrustAllSoapHttpClientFactory {

	public static SoapHttpClient create() {
		try {
			return new SoapHttpClient(HttpClients.custom()
					.setDefaultRequestConfig(RequestConfig.custom()
							.setSocketTimeout(60000)
							.setConnectTimeout(30000)
							.setExpectContinueEnabled(false)
							.setRedirectsEnabled(true)
							.build())
					.setConnectionManager(connectionManager())
					.build());
		} catch (Exception e) {
			throw new MPIRuntimeException("Erro ao criar HttpClient.", e);
		}
	}

	private static PoolingHttpClientConnectionManager connectionManager() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		SSLContext sslContext = SSLContextBuilder
				.create()
				.loadTrustMaterial(new TrustSelfSignedStrategy())
				.build();
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("https", socketFactory).build();
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
		cm.setValidateAfterInactivity(10000);
		cm.setDefaultSocketConfig(SocketConfig.custom().setTcpNoDelay(true).build());
		return cm;
	}

}