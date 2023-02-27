package modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Persona")
@NamedQueries({
	@NamedQuery(name="encontrarPersonaPorNombreYClave", query= "SELECT p from Persona p WHERE p.nombre= :param_nombre AND p.clave= :param_clave"),
	@NamedQuery(name="listarPersonas", query= "SELECT p from Persona p ORDER BY p.nombre ASC")
})
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPersona")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="clave")
	private String clave;


	public Persona() {

	}

	public Persona(int id, String nombre, String clave) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	@Override
	public String toString() {
		return this.nombre+ ' '+ this.clave;
	}
	@Override
	public int hashCode() {
		int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
	}
	@Override
	public boolean equals(Object object) {
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
	}
}
