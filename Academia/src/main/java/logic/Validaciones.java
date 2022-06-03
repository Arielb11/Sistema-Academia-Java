package logic;

import entities.Materia;

public class Validaciones {
	
	public static void AumentaCupo(int idMateria) throws UnmatchException {
		MateriaLogic mLogic = new MateriaLogic();
		Materia mat = mLogic.getOne(new Materia(idMateria));
		
		if(mat == null) {
			throw new UnmatchException("Error al aumentar el cupo de la materia");
		}
		
		else {
			mat.setCupo(mat.getCupo() + 1);
			mLogic.update(mat);	
		}	
	}
	
	public static void DisminuyeCupo(int idMateria) throws UnmatchException {
		MateriaLogic mLogic = new MateriaLogic();
		Materia mat = mLogic.getOne(new Materia(idMateria));
		
		if(mat == null) {
			throw new UnmatchException("Error al disminuir el cupo de la materia");
		}
		
		else {
			mat.setCupo(mat.getCupo() - 1);
			mLogic.update(mat);	
		}
		
	}
	
	public static boolean verificaCupo(int idMateria) throws UnmatchException {
		
		boolean bandera = true;
		Materia mat = new MateriaLogic().getOne(new Materia(idMateria));
		
		if(mat.getCupo() == 0) {
			bandera = false;
			throw new UnmatchException("La materia posee todos los cupos llenos");
		}
		
		return bandera;
		
	}
	
	public static boolean verificaNota(int nota) throws UnmatchException {
		boolean bandera = true;
		
		if (nota < 0) {
			bandera = false;
		}
		if (nota > 10) {
			bandera = false;
		}
		 return bandera; 
	}

}