package logic;

import java.util.LinkedList;

import data.DataMateria;
import entities.Materia;
import entities.Plan;

public class MateriaLogic {
	
	DataMateria materiaData;
	
	public MateriaLogic() {
		materiaData = new DataMateria();
	}
	
	public LinkedList<Materia> getAll() throws UnmatchException{
		LinkedList<Materia> materias = materiaData.getAll();
		
		if(materias == null) {
			throw new UnmatchException("Error al obtener listado de materias");
		}
		
		else {
			return materias;
		}
	}
	
	public LinkedList<Materia> getAll(Plan pla) throws UnmatchException{
		LinkedList<Materia> materias = materiaData.getAll(pla);
		
		if(materias == null) {
			throw new UnmatchException("Error al obtener listado de materias del plan buscado");
		}
		
		else {
			return materias;
		}
	}
	
	public Materia getOne(Materia materia) throws UnmatchException {
		
		Materia mat = materiaData.getOne(materia);
		
		if(mat == null) {
			throw new UnmatchException("Error al obtener datos de la materia");
		}
		
		else {
			return mat;	
		}
		
		
	}
	
	public void insert(Materia materia) throws UnmatchException {
		
		if(materia == null) {
			throw new UnmatchException("Error al insertar materia");
		}
		
		else {
			materiaData.insert(materia);
		}
	}

	public void delete(Materia materia) throws UnmatchException {
		
		if(materia == null) {
			throw new UnmatchException("Error al eliminar materia");
		}
		
		else {
			materiaData.delete(materia);
		}
		
	}
	
	public void update(Materia materia) throws UnmatchException {
		
		if(materia == null) {
			throw new UnmatchException("Error al actualizar materia");
		}
		
		else {
			materiaData.update(materia);
		}
	}

	public LinkedList<Materia> getMateriasDisponibles() throws UnmatchException {
		
		LinkedList<Materia> materiasDisponibles = materiaData.getMateriasDisponibles();
		
		if(materiasDisponibles == null) {
			throw new UnmatchException("Error al obtener materias disponibles");
		}
		
		else {
			return materiasDisponibles;
		}
		
	}

	public Materia getOneByDescripcion(Materia materia) throws UnmatchException {
		Materia mat = materiaData.getOneByDescripcion(materia);
		
		if(mat == null) {
			throw new UnmatchException("Error al obtener datos de la materia");
		}
		
		else {
			return mat;	
		}
		
	}
	
	
}
