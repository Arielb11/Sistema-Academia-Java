package data;

import java.sql.*;
import java.util.LinkedList;
import entities.Materia;
import entities.Plan;

public class DataMateria {

	public LinkedList<Materia> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Materia> materias = new LinkedList<Materia>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT id_materia, descripcion, hs_semanales, hs_totales, desc_plan, cupo " +
					"FROM materia mat " +
					"INNER JOIN plan pla ON (mat.id_plan = pla.id_plan) ");
			
			if(rs != null) {
				while(rs.next()) {
					Materia mat = new Materia();
					mat.setIdMateria(rs.getInt("id_materia"));
					mat.setDescripcion(rs.getString("descripcion"));
					mat.setDescPlan(rs.getString("desc_plan"));
					mat.setHsSemanales(rs.getInt("hs_semanales"));
					mat.setHsTotales(rs.getInt("hs_totales"));
					mat.setCupo(rs.getInt("cupo"));
					materias.add(mat);
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return materias;
	}
	
	public LinkedList<Materia> getAll(Plan pla) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LinkedList<Materia> materias = new LinkedList<Materia>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT id_materia, descripcion, "
					+ "hs_semanales, hs_totales, id_plan, cupo "
					+ "FROM materia WHERE id_plan = ?");
			
			stmt.setInt(1, pla.getIdPlan());
			rs = stmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					Materia mat = new Materia();
					mat.setIdMateria(rs.getInt("id_materia"));
					mat.setDescripcion(rs.getString("descripcion"));
					mat.setHsSemanales(rs.getInt("hs_semanales"));
					mat.setHsTotales(rs.getInt("hs_totales"));
					mat.setIdPlan(rs.getInt("id_plan"));
					mat.setCupo(rs.getInt("cupo"));
					materias.add(mat);
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return materias;
	}
	
	public Materia getOneByDescripcion(Materia materia) {
		Materia mat = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT "
					+ "id_materia, descripcion, hs_semanales, hs_totales, id_plan, cupo "
					+ "FROM materia WHERE descripcion = ?");
			stmt.setString(1, materia.getDescripcion());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				mat = new Materia();
				mat.setIdMateria(rs.getInt("id_materia"));
				mat.setDescripcion(rs.getString("descripcion"));
				mat.setHsSemanales(rs.getInt("hs_semanales"));
				mat.setHsTotales(rs.getInt("hs_totales"));
				mat.setIdPlan(rs.getInt("id_plan"));
				mat.setCupo(rs.getInt("cupo"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return mat;
	}
	
	public Materia getOne(Materia materia) {
		Materia mat = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT "
					+ "id_materia, descripcion, hs_semanales, hs_totales, id_plan, cupo "
					+ "FROM materia WHERE id_materia = ?");
			stmt.setInt(1, materia.getIdMateria());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				mat = new Materia();
				mat.setIdMateria(rs.getInt("id_materia"));
				mat.setDescripcion(rs.getString("descripcion"));
				mat.setHsSemanales(rs.getInt("hs_semanales"));
				mat.setHsTotales(rs.getInt("hs_totales"));
				mat.setIdPlan(rs.getInt("id_plan"));
				mat.setCupo(rs.getInt("cupo"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return mat;
	}
	
	public void insert(Materia materia) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT "
					+ "INTO materia (descripcion, hs_semanales, hs_totales, id_plan, cupo) "
					+ "VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, materia.getDescripcion());
			stmt.setInt(2, materia.getHsSemanales());
			stmt.setInt(3, materia.getHsTotales());
			stmt.setInt(4, materia.getIdPlan());
			stmt.setInt(5, materia.getCupo());
			stmt.executeUpdate();
			
			keyResultSet = stmt.getGeneratedKeys();
			
			if(keyResultSet != null && keyResultSet.next()) {
				materia.setIdMateria(keyResultSet.getInt(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(keyResultSet, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public void delete(Materia materia) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE "
					+ "FROM materia WHERE id_materia = ?");
			stmt.setInt(1, materia.getIdMateria());
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
	}
	
	public void update(Materia materia) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE materia "
					+ "SET descripcion = ?, hs_semanales = ?, hs_totales = ?, "
					+ "id_plan = ?, cupo = ? WHERE id_materia = ?");
			stmt.setString(1, materia.getDescripcion());
			stmt.setInt(2, materia.getHsSemanales());
			stmt.setInt(3, materia.getHsTotales());
			stmt.setInt(4, materia.getIdPlan());
			stmt.setInt(5, materia.getCupo());
			stmt.setInt(6, materia.getIdMateria());
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}

	public LinkedList<Materia> getMateriasDisponibles() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Materia> materiasDisponibles = new LinkedList<Materia>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT descripcion "
					+ "FROM materia mat "
					+ "LEFT JOIN docente doc ON (mat.id_materia = doc.id_materia) "
					+ "WHERE id_persona IS NULL");
			
			if(rs != null) {
				while(rs.next()) {
					Materia mat = new Materia();
					mat.setDescripcion(rs.getString("descripcion"));
					materiasDisponibles.add(mat);
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return materiasDisponibles;
	}
}