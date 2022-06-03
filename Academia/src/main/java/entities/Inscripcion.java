package entities;

public class Inscripcion {

	int idMateria;
	int idMateriaModificada;
	int idPersona;
	int nota;
	String condicion;
	
	//Atributos para los joins en los querys de la capa de datos.
	String nombre;
	String apellido;
	String descripcionMateria;
	
		
	public int getIdMateriaModificada() {
		return idMateriaModificada;
	}
	public void setIdMateriaModificada(int idMateriaModificada) {
		this.idMateriaModificada = idMateriaModificada;
	}
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
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	
	public Inscripcion(int idMateria, int idPersona, int nota, String condicion) {
		super();
		this.idMateria = idMateria;
		this.idPersona = idPersona;
		this.nota = nota;
		this.condicion = condicion;
	}
	
	public Inscripcion(int idMateria, int idPersona) {
		super();
		this.idMateria = idMateria;
		this.idPersona = idPersona;
	}
	
	public Inscripcion(int idMateria, int idMateriaModificada, int idPersona, int nota, String condicion) {
		super();
		this.idMateria = idMateria;
		this.idMateriaModificada = idMateriaModificada;
		this.idPersona = idPersona;
		this.nota = nota;
		this.condicion = condicion;
	}
	
	public Inscripcion() {
		super();
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
	
}
