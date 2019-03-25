package br.leg.rr.al.legislativo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.leg.rr.al.core.jpa.BaseEntityStatus;
import br.leg.rr.al.legislativo.domain.ComissaoType;

/**
 * The persistent class for the pessoa_fisica database table.
 * 
 */
@Entity
@Table(name = "comissao")
public class Comissao extends BaseEntityStatus<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6313473441466971855L;

	private String nome;

	@Column(nullable = false, name = "comissao_tipo")
	private ComissaoType tipo;

	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "comissao")
	private Set<MembroComissao> membros;

	@NotNull(message = "Legislatura: campo obrigatório.")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "legislatura_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "legislatura_fk"))
	private Legislatura legislatura;

	/* private Set<Telefone> telefones; */

	private String email;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tipo
	 */
	public ComissaoType getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(ComissaoType tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the membros
	 */
	public Set<MembroComissao> getMembros() {
		return membros;
	}

	/**
	 * @param membros the membros to set
	 */
	public void setMembros(Set<MembroComissao> membros) {
		this.membros = membros;
	}

	/**
	 * @return the legislatura
	 */
	public Legislatura getLegislatura() {
		return legislatura;
	}

	/**
	 * @param legislatura the legislatura to set
	 */
	public void setLegislatura(Legislatura legislatura) {
		this.legislatura = legislatura;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
