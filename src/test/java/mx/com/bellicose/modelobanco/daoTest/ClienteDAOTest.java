package mx.com.bellicose.modelobanco.daoTest;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import mx.com.bellicose.modelobanco.dao.ClienteDAO;
import mx.com.bellicose.modelobanco.dto.ClienteDTO;

public class ClienteDAOTest {

	@Ignore
	public void leerTest() {

		ClienteDAO cliente = new ClienteDAO();
		ArrayList<ClienteDTO> clientes = null;
		try {
			clientes = cliente.leer();
			assertNotNull(clientes);
			for (ClienteDTO clienteDTO : clientes) {
				System.out.println("id: " + clienteDTO.getIdCliente()
				+ ", nombre: " + clienteDTO.getNombre()
				+ ", apaterno: " + clienteDTO.getApaterno()
				+ ", amaterno: " + clienteDTO.getAmaterno()
				+ ", edad: " + clienteDTO.getEdad()
				+ ", idBanco: " + clienteDTO.getIdBanco());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	public void buscarTest(){
		ClienteDAO cliente = new ClienteDAO();
		try {
			ClienteDTO dto = cliente.buscar(1);
			System.out.println("idCliente: " + dto.getIdCliente()
					+ ", nombre: " + dto.getNombre()
					+ ", apaterno: " + dto.getApaterno()
					+ ", amaterno: " + dto.getAmaterno()
					+ ", edad: " + dto.getEdad()
					+ ", idBanco: " + dto.getIdBanco()
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	public void actualizarTest(){
		ClienteDAO dao = new ClienteDAO();
		ClienteDTO dto = new ClienteDTO();
		dto.setIdCliente(9);
		dto.setNombre("Edwyn");
		dto.setApaterno("Hernandez");
		dto.setAmaterno("Ramirez");
		dto.setEdad(35);
		dto.setIdBanco(2);
		
		try {
			dao.actualizar(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void agregarTest(){
		ClienteDAO dao = new ClienteDAO();
		ClienteDTO dto = new ClienteDTO();
		dto.setNombre("Isaac");
		dto.setApaterno("Hernandez");
		dto.setAmaterno("Lopez");
		dto.setEdad(3);
		dto.setIdBanco(3);
		
		try {
			dao.agregar(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void eliminarTest(){
		ClienteDAO dao = new ClienteDAO();
		
		try {
			dao.eliminar(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
