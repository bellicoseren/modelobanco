package mx.com.bellicose.modelobanco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mx.com.bellicose.modelobanco.connection.ConnectionFactory;
import mx.com.bellicose.modelobanco.dto.ClienteDTO;
import mx.com.bellicose.modelobanco.intefaces.ICliente;

public class ClienteDAO implements ICliente{

	Connection conn;
	public ArrayList<ClienteDTO> leer() throws Exception {

		String leer = "select *from cliente";
		conn = ConnectionFactory.getInstance().getConection();
		
		if(conn == null){
			System.out.println("No hay conexion a la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(leer);
		ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		ClienteDTO clienteDTO = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			clienteDTO = new ClienteDTO();
			clienteDTO.setIdCliente(rs.getInt("idCliente"));
			clienteDTO.setNombre(rs.getString("nombre"));
			clienteDTO.setApaterno(rs.getString("apaterno"));
			clienteDTO.setAmaterno(rs.getString("amaterno"));
			clienteDTO.setEdad(rs.getInt("edad"));
			clienteDTO.setIdBanco(rs.getInt("idBanco"));
			
			clientes.add(clienteDTO);
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
		
		return clientes;
	}

	public ClienteDTO buscar(int idCliente) throws Exception {

		String buscar = "select *from cliente where idCliente = ?";
		conn = ConnectionFactory.getInstance().getConection();
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(buscar);
		ps.setInt(1, idCliente);
		ClienteDTO dto = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			dto = new ClienteDTO();
			dto.setIdCliente(rs.getInt("idCliente"));
			dto.setNombre(rs.getString("nombre"));
			dto.setApaterno(rs.getString("apaterno"));
			dto.setAmaterno(rs.getString("amaterno"));
			dto.setEdad(rs.getInt("edad"));
			dto.setIdBanco(rs.getInt("idBanco"));
		}
		return dto;
	}

	public boolean actualizar(ClienteDTO clienteDTO) throws Exception {

		String actualizar = "update cliente set nombre=?, apaterno=?, amaterno=?, edad=?, idBanco=? where idCliente=?";
		conn = ConnectionFactory.getInstance().getConection();
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(actualizar);
		ps.setString(1, clienteDTO.getNombre());
		ps.setString(2, clienteDTO.getApaterno());
		ps.setString(3, clienteDTO.getAmaterno());
		ps.setInt(4, clienteDTO.getEdad());
		ps.setInt(5, clienteDTO.getIdBanco());
		ps.setInt(6, clienteDTO.getIdCliente());
		
		boolean actualizado = ps.executeUpdate() > 0;
		
		if(actualizado){
			System.out.println("Se actualizó el registro");
		}else{
			System.out.println("No se actualizó el registro");
		}
		
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			ConnectionFactory.getInstance().close();
		}
		
		return actualizado;
	}

	public boolean agregar(ClienteDTO clienteDTO) throws Exception {

		String agregar = "insert into cliente(nombre, apaterno, amaterno, edad, idBanco) values(?,?,?,?,?)";
		
		conn = ConnectionFactory.getInstance().getConection();
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(agregar);
		ps.setString(1, clienteDTO.getNombre());
		ps.setString(2, clienteDTO.getApaterno());
		ps.setString(3, clienteDTO.getAmaterno());
		ps.setInt(4, clienteDTO.getEdad());
		ps.setInt(5, clienteDTO.getIdBanco());
		
		boolean agregado = ps.executeUpdate() > 0;
		
		if(agregado){
			System.out.println("Registro agregado satisfactoriamente");
		}else{
			System.out.println("No se pudo agrgar el registro");
		}
		
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			conn.close();
		}
		
		return agregado;
	}

	public boolean eliminar(int idCliente) throws Exception {

		String eliminar = "delete from cliente where idCliente=?";
		
		conn = ConnectionFactory.getInstance().getConection();
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		PreparedStatement ps = conn.prepareStatement(eliminar);
		ps.setInt(1, idCliente);
		
		boolean eliminado = ps.executeUpdate() > 0;
		
		if(eliminado){
			System.out.println("Registro eliminado satisfactoriamente");
		}else{
			System.out.println("No fue posible eliminar el registro");
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
