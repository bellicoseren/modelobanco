package mx.com.bellicose.modelobanco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mx.com.bellicose.modelobanco.connection.ConnectionFactory;
import mx.com.bellicose.modelobanco.dto.BancoDTO;
import mx.com.bellicose.modelobanco.intefaces.IBanco;

public class BancoDAO implements IBanco {
	Connection conn;
	public ArrayList<BancoDTO> leer() throws Exception {

		String leer = "select *from banco";
		conn = ConnectionFactory.getInstance().getConection();
		if(conn == null){
			System.out.println("No existe conexion a la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(leer);
		ArrayList<BancoDTO> bancos = new ArrayList<BancoDTO>();
		BancoDTO banco = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			banco = new BancoDTO();
			banco.setIdBanco(rs.getInt("idBanco"));
			banco.setNombe(rs.getString("nombre"));
			
			bancos.add(banco);
		}
		if(rs != null){
			rs.close();
		}
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			ConnectionFactory.getInstance().close();
		}
		
		return bancos;
	}

	public ArrayList<BancoDTO> buscar(int idBanco) throws Exception {
		
		String buscar = "select *from banco where idBanco = ?";
		conn = ConnectionFactory.getInstance().getConection();
		
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(buscar);
		ps.setInt(1, idBanco);
		ArrayList<BancoDTO> bancos = new ArrayList<BancoDTO>();
		BancoDTO dto = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			dto = new BancoDTO();
			dto.setIdBanco(rs.getInt("idBanco"));
			dto.setNombe(rs.getString("nombre"));
			
			bancos.add(dto);
		}
		if(rs != null){
			rs.close();
		}
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			ConnectionFactory.getInstance().close();
		}
		return bancos;
	}

	public boolean actualizar(BancoDTO bancoDTO) throws Exception {

		String actualizar = "update banco set nombre=? where idBanco=?";
		conn = ConnectionFactory.getInstance().getConection();
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(actualizar);
		ps.setString(1, bancoDTO.getNombre());
		ps.setInt(2, bancoDTO.getIdBanco());
		
		boolean actualizado = ps.executeUpdate() > 0;
		
		if(actualizado){
			System.out.println("Registro actualizado");
		}else{
			System.out.println("No se actualizó registro");
		}
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			ConnectionFactory.getInstance().close();
		}
		
		return actualizado;
	}

	public boolean agregar(BancoDTO bancoDTO) throws Exception {

		String agregar = "insert into banco (idBanco, nombre) values(?, ?)";
		conn = ConnectionFactory.getInstance().getConection();
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(agregar);
		ps.setInt(1, bancoDTO.getIdBanco());
		ps.setString(2, bancoDTO.getNombre());
		
		boolean agregado = ps.executeUpdate() > 0;
		if(agregado){
			System.out.println("Se agregó nuevo registro");
		}else{
			System.out.println("No fué posible agregar el registro");
		}
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			ConnectionFactory.getInstance().close();
		}
		return agregado;
	}

	public boolean eliminar(int idBanco) throws Exception {

		String eliminar = "delete from banco where idBanco=?";
		
		conn = ConnectionFactory.getInstance().getConection();
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(eliminar);
		ps.setInt(1, idBanco);
		
		boolean eliminado = ps.executeUpdate() > 0;
		
		if(eliminado){
			System.out.println("Registro eliminado satisfactoriamente");
		}else{
			System.out.println("No fue posible borrar el registro");
		}
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			conn.close();
		}
		
		return eliminado;
	}

}
