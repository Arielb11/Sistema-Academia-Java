package data;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;

import entities.Persona;

public class DataPersona{
	
	public LinkedList <Persona> getAll(){

		Statement stmt = null;
		ResultSet rs = null;
		
		LinkedList<Persona> pers = new LinkedList <>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT * FROM persona");
			
			while (rs != null && rs.next()) {
				
				Persona p = new Persona();
				
				p.setIdPersona(rs.getInt("id_persona"));
				p.setLegajo(rs.getInt("legajo"));
				p.setTipoPersona(rs.getString("tipo_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDireccion(rs.getString("direccion"));
				p.setEmail(rs.getString("email"));
				p.setTelefono(rs.getString("telefono"));
				p.setFechaNacimiento(rs.getObject("fecha_nac", LocalDate.class));
				p.setNombreUsuario(rs.getString("nombre_usuario"));
				p.setClave(rs.getString("clave"));

				pers.add(p);
			}
			
			return pers;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public LinkedList <Persona> getAllDocentes() {
		Statement stmt = null;
		ResultSet rs = null;
		
		LinkedList<Persona> pers = new LinkedList <>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT nombre, apellido, legajo "
					+ "FROM persona per "
					+ "WHERE per.tipo_persona = 'Docente'");
			
			while (rs != null && rs.next()) {
				Persona p = new Persona();
				p.setApellido(rs.getString("apellido"));
				p.setNombre(rs.getString("nombre"));
				p.setLegajo(rs.getInt("legajo"));
				
				pers.add(p);
			}
			
			return pers;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public LinkedList <Persona> getAllAlumnos() {
		Statement stmt = null;
		ResultSet rs = null;
		
		LinkedList<Persona> pers = new LinkedList <>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT nombre, apellido, legajo "
					+ "FROM persona per "
					+ "WHERE per.tipo_persona = 'Alumno'");
			
			while (rs != null && rs.next()) {
				Persona p = new Persona();
				p.setApellido(rs.getString("apellido"));
				p.setNombre(rs.getString("nombre"));
				p.setLegajo(rs.getInt("legajo"));
				
				pers.add(p);
			}
			
			return pers;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public Persona getOne(Persona p) {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		Persona per = new Persona();
	
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("SELECT * FROM persona WHERE id_persona = ?");
		
			stmt.setInt(1, p.getIdPersona());
		
			rs = stmt.executeQuery();
		
			if (rs.next()) {
				per.setIdPersona(rs.getInt("id_persona"));
				per.setLegajo(rs.getInt("legajo"));
				per.setTipoPersona(rs.getString("tipo_persona"));
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setDireccion(rs.getString("direccion"));
				per.setEmail(rs.getString("email"));
				per.setTelefono(rs.getString("telefono"));
				per.setFechaNacimiento(rs.getObject("fecha_nac", LocalDate.class));
				per.setNombreUsuario(rs.getString("nombre_usuario"));
				per.setClave(rs.getString("clave"));
			}
		
			return per;
		
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public void insert(Persona newPer) {
		
		
		ResultSet keyRS = null;
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("insert into persona(nombre,apellido,direccion,email,telefono,fecha_nac,legajo,tipo_persona,nombre_usuario,clave) "+"values(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, newPer.getNombre());
			stmt.setString(2, newPer.getApellido());
			stmt.setString(3, newPer.getDireccion());
			stmt.setString(4, newPer.getEmail());
			stmt.setString(5, newPer.getTelefono());
			stmt.setObject(6, newPer.getFechaNacimiento());
			stmt.setInt(7, newPer.getLegajo());
			stmt.setString(8, newPer.getTipoPersona());
			stmt.setString(9, newPer.getNombreUsuario());
			stmt.setString(10, newPer.getClave());
			
			
			stmt.executeUpdate();
			
			keyRS = stmt.getGeneratedKeys();
			
			if(keyRS!=null && keyRS.next()) {
				newPer.setIdPersona(keyRS.getInt(1));
			}

			
		} catch(SQLException e) {
		e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(keyRS, stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public void delete(Persona updPer) {
		
		PreparedStatement stmt = null;
		
		try {

			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM persona WHERE id_persona=? ");
			
			stmt.setInt(1, updPer.getIdPersona());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public void update(Persona updPer) {
		
		PreparedStatement stmt = null;
		
		try {
			
			
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE persona " + "SET nombre = ?, apellido = ?, direccion = ?, email = ?, telefono = ?, fecha_nac = ?, legajo = ?, tipo_persona = ?, nombre_usuario = ?, clave = ?" + "WHERE id_persona = ?");
			stmt.setString(1, updPer.getNombre());
			stmt.setString(2, updPer.getApellido());
			stmt.setString(3,updPer.getDireccion());
			stmt.setString(4, updPer.getEmail());
			stmt.setString(5, updPer.getTelefono());
			stmt.setObject(6, updPer.getFechaNacimiento());
			stmt.setInt(7, updPer.getLegajo());
			stmt.setString(8, updPer.getTipoPersona());
			stmt.setString(9, updPer.getNombreUsuario());
			stmt.setString(10, updPer.getClave());
			stmt.setInt(11, updPer.getIdPersona());
			

			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnector.CloseConnections(stmt);
			DbConnector.getInstancia().releaseConn();
		}
	}
	
	public Persona getByUser(Persona per) {
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("SELECT id_persona, nombre, apellido, direccion, "
					+ "email, telefono, fecha_nac, legajo, tipo_persona, nombre_usuario, "
					+ "clave FROM persona WHERE nombre_usuario=? AND clave=?");
			stmt.setString(1, per.getNombreUsuario());
			stmt.setString(2, per.getClave());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setIdPersona(rs.getInt("id_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDireccion(rs.getString("direccion"));
				p.setEmail(rs.getString("email"));
				p.setTelefono(rs.getString("telefono"));
				p.setFechaNacimiento(rs.getObject("fecha_nac", LocalDate.class));
				p.setLegajo(rs.getInt("legajo"));
				p.setTipoPersona(rs.getString("tipo_persona"));
				p.setNombreUsuario(rs.getString("nombre_usuario"));
				p.setClave(rs.getString("clave"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return p;
	}

	public Persona getByLegajo(Persona per) {
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("SELECT id_persona, nombre, apellido, direccion, "
					+ "email, telefono, fecha_nac, legajo, tipo_persona, nombre_usuario, "
					+ "clave FROM persona WHERE legajo=?");
			stmt.setInt(1, per.getLegajo());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setIdPersona(rs.getInt("id_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDireccion(rs.getString("direccion"));
				p.setEmail(rs.getString("email"));
				p.setTelefono(rs.getString("telefono"));
				p.setFechaNacimiento(rs.getObject("fecha_nac", LocalDate.class));
				p.setLegajo(rs.getInt("legajo"));
				p.setTipoPersona(rs.getString("tipo_persona"));
				p.setNombreUsuario(rs.getString("nombre_usuario"));
				p.setClave(rs.getString("clave"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnector.CloseConnections(rs, stmt);
			DbConnector.getInstancia().releaseConn();
		}
		
		return p;
	}

}