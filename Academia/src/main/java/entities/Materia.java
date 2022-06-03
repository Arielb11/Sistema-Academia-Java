package entities;

public class Materia {
	
	int idMateria;
	int hsSemanales;
	int hsTotales;
	int idPlan;
	int cupo;
	String descripcion;
	
	
	//Atributos para los joins en los querys de la capa de datos.
	String descPlan;
	
	public String getDescPlan() {
		return descPlan;
	}

	public void setDescPlan(String descPlan) {
		this.descPlan = descPlan;
	}

	public int getCupo() {
		return cupo;
	}
	
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public int getIdMateria() {
		return idMateria;
	}
	
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	
	
	public int getHsSemanales() {
		return hsSemanales;
	}
	public void setHsSemanales(int hsSemanales) {
		this.hsSemanales = hsSemanales;
	}
	public int getHsTotales() {
		return hsTotales;
	}
	public void setHsTotales(int hsTotales) {
		this.hsTotales = hsTotales;
	}
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
	
	

	public Materia(int idMateria) {
		super();
		this.idMateria = idMateria;
	}
	
	
	public Materia(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Materia(int idMateria, int hsSemanales, int hsTotales, int cupo, String descripcion, String descPlan) {
		super();
		this.idMateria = idMateria;
		this.hsSemanales = hsSemanales;
		this.hsTotales = hsTotales;
		this.cupo = cupo;
		this.descripcion = descripcion;
		this.descPlan = descPlan;
	}

	public Materia(int idMateria, int hsSemanales, int hsTotales, int idPlan, int cupo, String descripcion) {
		super();
		this.idMateria = idMateria;
		this.hsSemanales = hsSemanales;
		this.hsTotales = hsTotales;
		this.idPlan = idPlan;
		this.cupo = cupo;
		this.descripcion = descripcion;
	}
	


	public Materia(int hsSemanales, int hsTotales, int idPlan, int cupo, String descripcion) {
		super();
		this.hsSemanales = hsSemanales;
		this.hsTotales = hsTotales;
		this.idPlan = idPlan;
		this.cupo = cupo;
		this.descripcion = descripcion;
	}
	
	public Materia() {
		super();
	}
}
