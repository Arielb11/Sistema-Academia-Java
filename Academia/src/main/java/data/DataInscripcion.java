package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Inscripcion;
import entities.Persona;


public class DataInscripcion{

	public LinkedList <Inscripcion> getAll(){

		Statement stmt = null;
		ResultSet rs = null;
		
		LinkedList<Inscripcion> inscripciones = new LinkedList <>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			
			rs = stmt.executeQuery("SELECT ins.id_persona, ins.id_materia, nombre, apellido, descripcion, condicion, nota "
					+ "FROM persona per "
					+ "INNER JOIN inscripcion ins ON (per.id_persona = ins.id_persona) "
					+ "INNER JOIN materia mat ON (ins.id_materia = mat.id_materia)");
			
			while (rs != null && rs.next()) {
				
				Inscripcion ins = new Inscripcion();
				ins.setIdPersona(rs.getInt("id_persona"));
				ins.setIdMateria(rs.getInt("id_materia"));
				ins.setNombre(rs.getString("nombre"));
				ins.setApellido(rs.getString("apellido"));
				ins.setDescripcionMateria(rs.getString("descripcion"));
				ins.setCondicion(rs.getString("condicion"));
				ins.setNota(rs.getInt("nota"));

				inscripciones.add(ins);
			}
			
			return inscripciones;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public LinkedList<Inscripcion> getAll(Persona per){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LinkedList<Inscripcion> inscripciones = new LinkedList<Inscripcion>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT mat.id_materia, descripcion, "
					+ "id_persona, condicion, nota "
					+ "FROM inscripcion ins "
					+ "INNER JOIN materia mat "
					+ "ON (ins.id_materia = mat.id_materia) WHERE id_persona = ?");
			
			stmt.setInt(1, per.getIdPersona());
			rs = stmt.executeQuery();
			
			if(rs != null ) {
				while(rs.next()) {
					Inscripcion ins = new Inscripcion();
					ins.setIdPersona(rs.getInt("id_persona"));
					ins.setIdMateria(rs.getInt("mat.id_materia"));
					ins.setDescripcionMateria(rs.getString("descripcion"));
					ins.setCondicion(rs.getString("condicion"));
					ins.setNota(rs.getInt("nota"));
					inscripciones.add(ins);
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		return inscripciones;
	}
	
	public Inscripcion getOne(Inscripcion ma) {
		
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		Inscripcion matalu = new Inscripcion();
	
		try {
			
		
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT * FROM inscripcion where id_materia = ? and id_persona = ?");
		
			stmt.setInt(1, ma.getIdMateria());
			stmt.setInt(2, ma.getIdPersona());
		
			rs = stmt.executeQuery();
		
			if (rs.next()) {
				matalu.setIdMateria(rs.getInt("id_materia"));
				matalu.setIdPersona(rs.getInt("id_persona"));
				matalu.setCondicion(rs.getString("condicion"));
				matalu.setNota(rs.getInt("nota"));
			}
		
			return matalu;
		
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public void insert(Inscripcion newMatAlu) {
		
		PreparedStatement stmt = null;
		
		try {
				
			stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT INTO inscripcion(id_materia, id_persona, condicion, nota) "+"values(?,?,?,?)");
			
			stmt.setInt(1, newMatAlu.getIdMateria());
			stmt.setInt(2, newMatAlu.getIdPersona());
			stmt.setString(3, newMatAlu.getCondicion());
			stmt.setInt(4, newMatAlu.getNota());
			
			stmt.executeUpdate();

		} catch(SQLException e) {
		e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public void delete(Inscripcion ma) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM inscripcion WHERE id_materia=? AND id_persona=?");
			
			stmt.setInt(1, ma.getIdMateria());
			stmt.setInt(2, ma.getIdPersona());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
	}

	public void update(Inscripcion updMatAlu) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE inscripcion "
					+ "SET id_materia = ?, condicion = ?, nota = ? " 
					+ "WHERE id_materia = ? AND id_persona = ?");
			stmt.setInt(1, updMatAlu.getIdMateriaModificada());
			stmt.setString(2, updMatAlu.getCondicion());
			stmt.setInt(3, updMatAlu.getNota());
			stmt.setInt(4, updMatAlu.getIdMateria());
			stmt.setInt(5, updMatAlu.getIdPersona());

			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}

}