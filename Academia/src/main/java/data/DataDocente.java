package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Docente;

public class DataDocente {
	
	public LinkedList<Docente> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Docente> docCursos = new LinkedList<Docente>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT id_docente, nombre, apellido, cargo, descripcion "
					+ "FROM docente doc "
					+ "INNER JOIN persona per ON (doc.id_persona = per.id_persona) "
					+ "INNER JOIN materia mat ON (doc.id_materia = mat.id_materia)");
			
			if(rs != null) {
				while(rs.next()) {
					Docente dc = new Docente();
					dc.setIdDocente(rs.getInt("id_docente"));
					dc.setNombre(rs.getString("nombre"));
					dc.setApellido(rs.getString("apellido"));
					dc.setCargo(rs.getString("cargo"));
					dc.setDescripcionMateria(rs.getString("descripcion"));
					docCursos.add(dc);
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return docCursos;
	}
	
	public Docente getOne(Docente docCurso) {
		Docente dcu = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT "
					+ "id_docente, cargo, id_materia, id_persona"
					+ " FROM docente WHERE id_docente = ?");
			stmt.setInt(1, docCurso.getIdDocente());
			rs = stmt.executeQuery();
			
			if(rs != null && rs.next()) {
				dcu = new Docente();
				dcu.setIdDocente(rs.getInt("id_docente"));
				dcu.setCargo(rs.getString("cargo"));
				dcu.setIdMateria(rs.getInt("id_materia"));
				dcu.setIdPersona(rs.getInt("id_persona"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return dcu;
	}
	
	public void insert(Docente docCurso) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT "
					+ "INTO docente (cargo, id_materia, id_persona) "
					+ "VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, docCurso.getCargo());
			stmt.setInt(2, docCurso.getIdMateria());
			stmt.setInt(3, docCurso.getIdPersona());
			stmt.executeUpdate();
			
			keyResultSet = stmt.getGeneratedKeys();
			
			if(keyResultSet != null && keyResultSet.next()) {
				docCurso.setIdDocente(keyResultSet.getInt(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(keyResultSet, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public void delete(Docente docCurso) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE "
					+ "FROM docente WHERE id_docente = ?");
			stmt.setInt(1, docCurso.getIdDocente());
			stmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
	}
	
	public void update(Docente docCurso) {
		PreparedStatement stmt = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE docente "
					+ "SET cargo = ?, id_materia = ?, id_persona = ? "
					+ "WHERE id_docente = ?");
			stmt.setString(1, docCurso.getCargo());
			stmt.setInt(2, docCurso.getIdMateria());
			stmt.setInt(3, docCurso.getIdPersona());
			stmt.setInt(4, docCurso.getIdDocente());
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