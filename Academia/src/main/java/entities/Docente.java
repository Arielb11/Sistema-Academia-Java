package entities;

public class Docente {
	
	int idPersona;
	int idDocente;
	int idMateria;
	String cargo;
	
	//Atributos para los joins en los querys de la capa de datos.
	String nombre;
	String apellido;
	String descripcionMateria;
	
	
	public String getDescripcionMateria() {
		return descripcionMateria;
	}

	public void setDescripcionMateria(String descripcionMateria) {
		this.descripcionMateria = descripcionMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Docente() {
		super();
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
	
	public Docente(int idPersona, int idMateria, String cargo) {
		super();
		this.idPersona = idPersona;
		this.idMateria = idMateria;
		this.cargo = cargo;
	}

	

	public Docente(int idPersona, int idDocente, int idMateria, String cargo) {
		super();
		this.idPersona = idPersona;
		this.idDocente = idDocente;
		this.idMateria = idMateria;
		this.cargo = cargo;
	}

	
	public Docente(int idDocente) {
		super();
		this.idDocente = idDocente;
	}
	
}