package logic;

import java.util.LinkedList;

import data.DataPlan;
import entities.Plan;

public class PlanLogic {
	
	DataPlan planData;
	
	public PlanLogic() {
		planData = new DataPlan();
	}
	
	public LinkedList<Plan> getAll() throws UnmatchException{
		
		LinkedList<Plan> planes = planData.getAll();
		
		if(planes == null) {
			throw new UnmatchException("Error al obtener listado de planes"); 
		}
		
		else {
			return planes;	
		}
		
	}
	
	public Plan getOne(Plan plan) throws UnmatchException{
		
		Plan pl = planData.getOne(plan);
		
		if(pl == null) {
			throw new UnmatchException("Error al obtener datos del plan");
		}
		else {
			return pl;	
		}
		
	}
	
	public Plan getPlanByDescripcion(Plan plan) throws UnmatchException {
		
		Plan pla = planData.getOneByDescripcion(plan);
		
		if(pla == null) {
			throw new UnmatchException("Error al obtener datos del plan");
		}
		
		else {
			return pla;
		}
		
	}
	
	public void insert(Plan plan) throws UnmatchException{
		
		if(plan == null) {
			throw new UnmatchException("Error al insertar plan");
		}
		
		else {
			planData.insert(plan);	
		}
	}

	public void delete(Plan plan) throws UnmatchException{
		
		if(plan == null) {
			throw new UnmatchException("Error al eliminar plan");
		}
		
		else {
			planData.delete(plan);
		}
		
	}
	
	public void update(Plan plan) throws UnmatchException {
		
		if(plan == null) {
			throw new UnmatchException("Error al actualizar plan");
		}
		
		else {
			planData.update(plan);
		}
	}
	
	
}