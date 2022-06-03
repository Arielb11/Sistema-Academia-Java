package entities;

public class Plan {
	
	int idPlan;
	String descripcion;
	String especialidad;
	
	
	public int getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public Plan() {
		
	}
	
	
	
	public Plan(int idPlan) {
		super();
		this.idPlan = idPlan;
	}
	
	
	
	public Plan(String descripcion, String especialidad) {
		super();
		this.descripcion = descripcion;
		this.especialidad = especialidad;
	}
	
	
	
	public Plan(int idPlan, String descripcion, String especialidad) {
		super();
		this.idPlan = idPlan;
		this.descripcion = descripcion;
		this.especialidad = especialidad;
	}
	
	
	
	public Plan(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
}