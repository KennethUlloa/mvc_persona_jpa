package modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Cuenta")
@NamedQueries({
	@NamedQuery(name = "listarCuentas", query = "SELECT c FROM CuentaBancaria c")
})
public class CuentaBancaria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id_cuenta")
	private Integer id;
	
	@Column(name="numero")
	private String numero;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "banco")
	private Banco banco;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn (name="propietario")
	private Persona propietario;

	public CuentaBancaria() {

	}
	
	public CuentaBancaria(String numero, Banco banco, Persona propietario) {
		this.numero = numero;
		this.banco = banco;
		this.propietario = propietario;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CuentaBancaria)) {
			return false;
		}
		CuentaBancaria other = (CuentaBancaria) obj;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Número cuenta : "+ this.getNumero();
	}

}