package br.ufsc.bridge.mpiclient.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

import br.ufsc.bridge.metafy.Metafy;
import br.ufsc.bridge.mpiclient.model.dominio.Etnia;
import br.ufsc.bridge.mpiclient.model.dominio.RacaCor;
import br.ufsc.bridge.mpiclient.model.dominio.Sexo;
import br.ufsc.bridge.mpiclient.model.dominio.TipoConfidencialidade;

@Getter
@Setter
@Builder
@Metafy
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cidadao {
	@Singular("cns")
	private List<CNS> cnss = new ArrayList<>();
	@Singular("certidao")
	private List<Certidao> certidoes = new ArrayList<>();
	@Singular("contato")
	private List<Contato> contatos = new ArrayList<>();
	private CNH cnh;
	private String cpf;
	private CTPS ctps;
	private LocalDate dataNascimento;
	private LocalDate dataObito;
	@Singular("endereco")
	private List<Endereco> enderecos = new ArrayList<>();
	private Etnia etnia;
	@Singular("identificadorLocal")
	private List<IdentificadorLocal> identificadoresLocais = new ArrayList<>();
	private Nacionalidade nacionalidade;
	private String nome;
	private String nomeMae;
	private String nomePai;
	private String nomeSocial;
	private String numeroDnv;
	private String numeroNisPisPasep;
	private String numeroRic;
	@Singular("passaporte")
	private List<Passaporte> passaportes = new ArrayList<>();
	private RacaCor racaCor;
	private RG rg;
	private Sexo sexo;
	@Builder.Default
	private TipoConfidencialidade tipoConfidencialidade = TipoConfidencialidade.NORMAL;
	private TituloEleitor tituloEleitor;
	private boolean vip = false;
	private boolean vivo = true;
}
