package entities;

import java.time.LocalDate;

public class Persona {
	
	int idPersona;	
	int legajo;	
	String tipoPersona;	
	String nombre;	
	String apellido;	
	String direccion;
	String email;	
	String telefono;	
	LocalDate fechaNacimiento;
	String nombreUsuario;
	String clave;
	
	
	

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Persona() {
		super();
	}
	

	public Persona(int idPersona, int legajo, String tipoPersona, String nombre, String apellido, String direccion,
			String email, String telefono, LocalDate fechaNacimiento, String nombreUsuario, String clave) {
		super();
		this.idPersona = idPersona;
		this.legajo = legajo;
		this.tipoPersona = tipoPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
	
	
	public Persona(int legajo, String tipoPersona, String nombre, String apellido, String direccion, String email,
			String telefono, LocalDate fechaNacimiento, String nombreUsuario, String clave) {
		super();
		this.legajo = legajo;
		this.tipoPersona = tipoPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
	
	
	public Persona(int idPersona) {
		super();
		this.idPersona = idPersona;
	}
	
	public Persona(String nombreUsuario, String clave) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
	
	public Persona(Integer legajo) {
		super();
		this.legajo = legajo;
	}
	

}