package logic;

import java.util.LinkedList;

import data.DataPersona;
import entities.Persona;

public class PersonaLogic {
	
	DataPersona perData;
	
	public PersonaLogic() {
		this.perData = new DataPersona();
	}
	
	public LinkedList<Persona> getAll() throws UnmatchException{
		
		LinkedList<Persona> personas = perData.getAll();
		
		if(personas == null) {
			throw new UnmatchException("Error al obtener listado de personas");
		}
		
		else {
			return personas;	
		}
		
	}
	
	public LinkedList<Persona> getAllDocentes() throws UnmatchException {
		
		LinkedList<Persona> personas = perData.getAllDocentes();
		
		if(personas == null) {
			throw new UnmatchException("Error al obtener listado de docentes");
		}
		
		else {
			return personas;	
		}
	}
	
	public LinkedList<Persona> getAllAlumnos() throws UnmatchException {
		
		LinkedList<Persona> personas = perData.getAllAlumnos();
		
		if(personas == null) {
			throw new UnmatchException("Error al obtener listado de alumnos");
		}
		
		else {
			return personas;	
		}
	}
	
	public Persona getOne(Persona pers) throws UnmatchException{
		
		Persona per = perData.getOne(pers);
		
		if(per == null) {
			throw new UnmatchException("Error al obtener datos de la persona");
		}
		
		else {
			return per;	
		}
	}
	
	public void insert(Persona pers) throws UnmatchException{
		
		if(pers == null) {
			throw new UnmatchException("Error al insertar persona");
		}
		
		else {
			perData.insert(pers);	
		}
		
			
	}
	
	public void delete(Persona pers) throws UnmatchException{
		
		if(pers == null) {
			throw new UnmatchException("Error al eliminar persona");
		}
		
		else {
			perData.delete(pers);	
		}
	}
	
	public void update(Persona pers) throws UnmatchException{
		
		if(pers == null) {
			throw new UnmatchException("Error al actualizar persona");
		}
		
		else {
			perData.update(pers);
		}
		
	}

	public Persona getByUser(Persona per) throws UnmatchException{
		
		Persona p = perData.getByUser(per);
		
		if(p == null) {
			throw new UnmatchException("El usuario o contraseña es incorrecto. Por "
					+ "favor vuelva a intentar");
		}
		
		else {
			return p;
		}
	}
		
	public Persona getByLegajo(Persona per) throws UnmatchException{
		Persona p = perData.getByLegajo(per);
		
		if(p == null) {
			throw new UnmatchException("Error al obtener a la persona");
		}
		
		else {
			return p;
		}
	}
	

		
}