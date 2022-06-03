package logic;

import java.util.LinkedList;

import data.DataInscripcion;
import entities.Inscripcion;
import entities.Persona;

public class InscripcionLogic {

	DataInscripcion inscriData;
	
	public InscripcionLogic() {
		inscriData = new DataInscripcion();
	}
	
	public LinkedList<Inscripcion> getAll() throws UnmatchException {
		LinkedList<Inscripcion> ins = inscriData.getAll();
		
		if(ins == null) {
			throw new UnmatchException("Error al obtener la lista de inscripciones de alumnos");
		}
		
		else {
			return ins;	
		}
	}
	
	public LinkedList<Inscripcion> getAll(Persona per) throws UnmatchException {
		LinkedList<Inscripcion> inscripciones = inscriData.getAll(per);
		
		if(inscripciones == null) {
			throw new UnmatchException("Error al obtener listado de notas de la persona buscada");
		}
		
		else {
			return inscripciones;
		}
	}
	
	public Inscripcion getOne(Inscripcion matAlumno) throws UnmatchException {
		Inscripcion ins = inscriData.getOne(matAlumno);
		
		if(ins == null) {
			throw new UnmatchException("Error al obtener datos de la inscripci�n");
		}
		
		else {
			return ins;	
		}
		
	}
	
	public void insert(Inscripcion ins) throws UnmatchException {
		if(ins == null) {
			throw new UnmatchException("Error al insertar inscripci�n de alumno");
		}
		
		else {
			inscriData.insert(ins);
		}
	}
	
	public void delete(Inscripcion ins) throws UnmatchException {
		
		if(ins == null) {
			throw new UnmatchException("Error al eliminar inscripci�n");
		}
		
		else {
			inscriData.delete(ins);
		}
		
	}
	
	public void update(Inscripcion ins) throws UnmatchException {
		
		if(ins == null) {
			throw new UnmatchException("Error al actualizar inscripci�n");
		}
		
		else {
			inscriData.update(ins);
		}
		
	}
	

}
