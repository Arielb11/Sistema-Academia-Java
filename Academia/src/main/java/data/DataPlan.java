package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Plan;

public class DataPlan {
	
	public LinkedList<Plan> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Plan> planes = new LinkedList<Plan>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT id_plan, desc_plan, especialidad FROM plan");
			
			if(rs != null) {
				while(rs.next()) {
					Plan pl = new Plan();
					pl.setIdPlan(rs.getInt("id_plan"));
					pl.setDescripcion(rs.getString("desc_plan"));
					pl.setEspecialidad(rs.getString("especialidad"));
					planes.add(pl);
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return planes;
	}
	
	public Plan getOne(Plan plan) {
		Plan pl = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT"
					+ " id_plan, desc_plan, especialidad FROM plan WHERE id_plan = ?");
			stmt.setInt(1, plan.getIdPlan());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				pl = new Plan();
				pl.setIdPlan(rs.getInt("id_plan"));
				pl.setDescripcion(rs.getString("desc_plan"));
				pl.setEspecialidad(rs.getString("especialidad"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return pl;
	}
	
	public void insert(Plan plan) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT "
					+ "INTO plan (desc_plan, especialidad) "
					+ "VALUE (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, plan.getDescripcion());
			stmt.setString(2, plan.getEspecialidad());
			stmt.executeUpdate();
			
			keyResultSet = stmt.getGeneratedKeys();
			
			if(keyResultSet != null && keyResultSet.next()) {
				plan.setIdPlan(keyResultSet.getInt(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(keyResultSet, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public void delete(Plan plan) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE "
					+ "FROM plan WHERE id_plan = ?");
			stmt.setInt(1, plan.getIdPlan());
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
	}
	
	public void update(Plan plan) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE plan "
					+ "SET desc_plan = ?, especialidad = ? WHERE id_plan = ?");
			stmt.setString(1, plan.getDescripcion());
			stmt.setString(2, plan.getEspecialidad());
			stmt.setInt(3, plan.getIdPlan());
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public Plan getOneByDescripcion(Plan plan) {
		Plan pla = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT "
					+ "id_plan, desc_plan, especialidad FROM plan WHERE desc_plan = ? ");
			
			stmt.setString(1, plan.getDescripcion());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				pla = new Plan();
				pla.setIdPlan(rs.getInt("id_plan"));
				pla.setDescripcion(rs.getString("desc_plan"));
				pla.setEspecialidad(rs.getString("especialidad"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return pla;
	}

}