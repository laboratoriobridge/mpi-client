package br.ufsc.bridge.mpiclient.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import br.ufsc.bridge.mpiclient.exceptions.MPIException;
import br.ufsc.bridge.mpiclient.exceptions.MPIValidationException;
import br.ufsc.bridge.mpiclient.http.TrustAllSoapHttpClientFactory;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.soap.http.exception.SoapHttpConnectionException;
import br.ufsc.bridge.soap.http.exception.SoapHttpResponseException;
import br.ufsc.bridge.soap.http.exception.SoapInvalidHeaderException;

@Slf4j
public class MPIClientTest {

	@Test(expected = MPIValidationException.class)
	public void inserirInvalido() throws MPIException {
		Cidadao cidadao = Cidadao.builder()
				.build();

		try {
			new MPIClient(MPIClientOptions.builder()
					.pixUrl("https://servicoshm.saude.gov.br/cadsus/PIXManager")
					.pdqUrl("https://servicoshm.saude.gov.br/cadsus/PDQSupplier")
					.pdqUrlJwt("https://servicoshm.saude.gov.br/cadsus/v2/PDQSupplierJWT")
					.pixUrlJwt("https://servicoshm.saude.gov.br/cadsus/v2/PIXManagerJWT")
					.pdqUrlJwtGovBr("https://servicoshm.saude.gov.br/cadsus/v2/PDQSupplierJWTGovBR")
					.pixUrlJwtGovBr("https://servicoshm.saude.gov.br/cadsus/v2/PIXManagerJWTGovBR")
					.user("")
					.password("")
					.build())
					.inserir(cidadao);
		} catch (MPIValidationException e) {
			log.error(e.getErrors().toString());
			throw e;
		}

	}

	//	@Test
	public void consultar() throws MPIException, IOException, SoapInvalidHeaderException, SoapHttpResponseException, SoapHttpConnectionException {
		//SoapHttpClient httpClient = mock(SoapHttpClient.class);
		//when(httpClient.request(any())).thenReturn(new SoapHttpResponse(this.getClass().getResourceAsStream("/responses/ConsultaPorNome.xml"), new Header[] {}));

		List<Cidadao> result = new MPIClient(MPIClientOptions.builder()
				.pixUrl("https://servicoshm.saude.gov.br/cadsus/PIXManager")
				.pdqUrl("https://servicoshm.saude.gov.br/cadsus/PDQSupplier")
				.pdqUrlJwt("https://servicoshm.saude.gov.br/cadsus/v2/PDQSupplierJWT")
				.pixUrlJwt("https://servicoshm.saude.gov.br/cadsus/v2/PIXManagerJWT")
				.pdqUrlJwtGovBr("https://servicoshm.saude.gov.br/cadsus/v2/PDQSupplierJWTGovBR")
				.pixUrlJwtGovBr("https://servicoshm.saude.gov.br/cadsus/v2/PIXManagerJWTGovBR")
				.user("CADSUS.CNS.PDQ.PUBLICO")
				.password("kUXNmiiii#RDdlOELdoe00966")
				.client(TrustAllSoapHttpClientFactory.create())
				.build())
				.consultar(PDQParameters.builder()
						.nome("SEVERINO FAUSTINO")
						.build());

		assertThat(result).hasSize(1);

		Cidadao cidadao = result.get(0);
		assertThat(cidadao.getNome()).isEqualTo("SEVERINO FAUSTINO");
	}

}
