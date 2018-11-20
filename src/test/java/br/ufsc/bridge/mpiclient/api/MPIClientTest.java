package br.ufsc.bridge.mpiclient.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;

import br.ufsc.bridge.mpiclient.exceptions.MPIException;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.soap.http.SoapHttpClient;
import br.ufsc.bridge.soap.http.SoapHttpResponse;
import br.ufsc.bridge.soap.http.exception.SoapHttpConnectionException;
import br.ufsc.bridge.soap.http.exception.SoapHttpResponseException;
import br.ufsc.bridge.soap.http.exception.SoapInvalidHeaderException;

public class MPIClientTest {

	//	@Test
	public void inserir() throws MPIException {
		Cidadao cidadao = Cidadao.builder()
				.build();

		new MPIClient(MPIClientOptions.builder()
				.pixUrl("https://servicoshm.saude.gov.br/cadsus/PIXManager")
				.pdqUrl("https://servicoshm.saude.gov.br/cadsus/PDQSupplier")
				.user("")
				.password("")
				.build())
				.inserir(cidadao);

	}

	//	@Test
	public void consultar() throws MPIException, IOException, SoapInvalidHeaderException, SoapHttpResponseException, SoapHttpConnectionException {
		SoapHttpClient httpClient = mock(SoapHttpClient.class);
		when(httpClient.request(any())).thenReturn(new SoapHttpResponse(this.getClass().getResourceAsStream("/responses/ConsultaPorNome.xml"), new Header[] {}));

		List<Cidadao> result = new MPIClient(MPIClientOptions.builder()
				.pixUrl("https://servicoshm.saude.gov.br/cadsus/PIXManager")
				.pdqUrl("https://servicoshm.saude.gov.br/cadsus/PDQSupplier")
				.user("CADSUS.CNS.PDQ.PUBLICO")
				.password("kUXNmiiii#RDdlOELdoe00966")
				.client(httpClient)
				.build())
				.consultar(PDQParameters.builder()
						.nome("SEVERINO FAUSTINO")
						.build());

		assertThat(result).hasSize(1);

		Cidadao cidadao = result.get(0);
		assertThat(cidadao.getNome()).isEqualTo("SEVERINO FAUSTINO");
	}

}
