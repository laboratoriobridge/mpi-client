package br.ufsc.bridge.mpiclient.messages;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.xml.sax.SAXException;

import br.ufsc.bridge.mpiclient.exceptions.MPIValidationException;
import br.ufsc.bridge.mpiclient.loader.FileLoader;
import br.ufsc.bridge.mpiclient.model.CNH;
import br.ufsc.bridge.mpiclient.model.CNS;
import br.ufsc.bridge.mpiclient.model.CTPS;
import br.ufsc.bridge.mpiclient.model.CertidaoAntiga;
import br.ufsc.bridge.mpiclient.model.CertidaoNova;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.Contato;
import br.ufsc.bridge.mpiclient.model.Endereco;
import br.ufsc.bridge.mpiclient.model.IdentificadorLocal;
import br.ufsc.bridge.mpiclient.model.Naturalizado;
import br.ufsc.bridge.mpiclient.model.Passaporte;
import br.ufsc.bridge.mpiclient.model.RG;
import br.ufsc.bridge.mpiclient.model.TituloEleitor;
import br.ufsc.bridge.mpiclient.model.dominio.Etnia;
import br.ufsc.bridge.mpiclient.model.dominio.Pais;
import br.ufsc.bridge.mpiclient.model.dominio.RacaCor;
import br.ufsc.bridge.mpiclient.model.dominio.Sexo;
import br.ufsc.bridge.mpiclient.model.dominio.TipoCertidaoAntiga;
import br.ufsc.bridge.mpiclient.model.dominio.TipoCertidaoNova;
import br.ufsc.bridge.mpiclient.model.dominio.TipoConfidencialidade;
import br.ufsc.bridge.mpiclient.model.dominio.TipoContato;
import br.ufsc.bridge.mpiclient.model.dominio.TipoEndereco;
import br.ufsc.bridge.mpiclient.model.dominio.TipoLogradouro;
import br.ufsc.bridge.mpiclient.model.dominio.UF;

public class PRPA_IN201301UV02Test {

	@Test
	public void pedroMoreiraLauro() throws MPIValidationException, IOException, SAXException {
		Cidadao cidadao = Cidadao.builder()
				.certidao(new CertidaoAntiga(
						"NOMECARTORIO1",
						LocalDate.of(2005, 05, 05),
						"FOL1",
						"LIVRO1",
						"TERMO1",
						TipoCertidaoAntiga.CERTIDAO_DE_CASAMENTO))
				.certidao(new CertidaoNova(
						"12345678901234567890123456789012",
						LocalDate.of(2006, 06, 06),
						TipoCertidaoNova.CERTIDAO_DE_NASCIMENTO))
				.cnh(new CNH(LocalDate.of(2002, 02, 02), "789654987", UF.GOIAS))
				.cns(new CNS("111111111111111"))
				.cns(new CNS("888888888888888"))
				.contato(new Contato("+55-61-82997451", TipoContato.TELEFONE_RESIDENCIAL))
				.contato(new Contato("foo@gmail.com", TipoContato.EMAIL))
				.contato(new Contato("bar@hotmail.com", TipoContato.EMAIL))
				.cpf("01030433143")
				.ctps(new CTPS(LocalDate.of(2004, 04, 04), "1234", "123"))
				.dataNascimento(LocalDate.of(1985, 02, 05))
				.endereco(Endereco.builder()
						.bairro("Bairro")
						.cep("88888080")
						.codigoMunicipio("123456")
						.complemento("Complemento")
						.logradouro("Logradouro")
						.numero("12")
						.pais(Pais.BRASIL)
						.tipoEndereco(TipoEndereco.CASA)
						.tipoLogradouro(TipoLogradouro.RUA)
						.uf(UF.DISTRITO_FEDERAL)
						.build())
				.etnia(Etnia.TAPUIA_TAPUIA_XAVANTE_TAPUIO)
				.identificadorLocal(new IdentificadorLocal("localID", "systemCode", "oidSystemCode"))
				.nacionalidade(new Naturalizado(LocalDate.of(1997, 01, 01), LocalDate.of(1997, 02, 02), "52146546"))
				.nome("PEDRO MOREIRA LAURO")
				.nomeMae("MARIA DO CARMO MOREIRA LAURO")
				.nomePai("PAULO PINTO RIBEIRO")
				.nomeSocial("ORDEP")
				.numeroDnv("DNVNUMBER1")
				.passaporte(new Passaporte(
						LocalDate.of(2001, 01, 01),
						LocalDate.of(2015, 01, 01),
						"FB31241",
						Pais.BRASIL))
				.numeroNisPisPasep("01030433140")
				.numeroRic("RICNUMBER1")
				.racaCor(RacaCor.BRANCA)
				.rg(new RG(LocalDate.of(2003, 03, 03), "RGNUMBER1", "10", UF.DISTRITO_FEDERAL))
				.sexo(Sexo.MASCULINO)
				.tipoConfidencialidade(TipoConfidencialidade.RESTRITO)
				.tituloEleitor(new TituloEleitor("TITULONUMBER1", "Z1", "SECAO1"))
				.vivo(false)
				.build();

		String messageXml = new PIXRequestMessage().create(cidadao, DateTimeFormatter.ofPattern("yyyyMMddHHmmss").parse("20101123115812", LocalDateTime::from));

		assertThat(messageXml)
				.isNotBlank()
				.isEqualTo(FileLoader.loadAsString("/requests/PedroMoreiraLauro.xml"));
	}

}
