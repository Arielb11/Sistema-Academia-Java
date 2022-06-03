package logic;

import java.util.LinkedList;

import data.DataDocente;
import entities.Docente;

public class DocenteLogic {

	DataDocente docCursoData;
	
	public DocenteLogic() {
		docCursoData = new DataDocente();
	}
	
	public LinkedList<Docente> getAll() throws UnmatchException {
		LinkedList<Docente> docCursos = docCursoData.getAll();
		
		if(docCursos == null) {
			throw new UnmatchException("Error al obtener listado de docentes");
		}
		
		else {
			return docCursos;	
		}
	}
	
	public Docente getOne(Docente docCurso) throws UnmatchException {
		Docente dcu = docCursoData.getOne(docCurso);
		
		if(dcu == null) {
			throw new UnmatchException("Error al obtener el docente");
		}
		
		else {
			return dcu;	
		}
		
	}
	
	public void insert(Docente docCurso) throws UnmatchException {
		
		if(docCurso == null) {
			throw new UnmatchException("Error al insertar el docente");
		}
		
		else {
			docCursoData.insert(docCurso);
		}
	}

	public void delete(Docente docCurso) throws UnmatchException {
		
		if(docCurso == null) {
			throw new UnmatchException("Error al eliminar docente");
		}
		
		else {
			docCursoData.delete(docCurso);
		}
	}
	
	public void update(Docente docCurso) throws UnmatchException {
		
		if(docCurso == null) {
			throw new UnmatchException("Error al actualizar docente");
		}
		
		else {
			docCursoData.update(docCurso);
		}
	}
}