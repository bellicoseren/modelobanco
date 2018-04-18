package mx.com.bellicose.modelobanco.daoTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import mx.com.bellicose.modelobanco.dao.BancoDAO;
import mx.com.bellicose.modelobanco.dto.BancoDTO;

public class BancoDAOTest {

	@Ignore
	public void test() {

		BancoDAO banco = new BancoDAO();
		
		try {
			ArrayList<BancoDTO> bancos = banco.leer();
			for (BancoDTO bancoDTO : bancos) {
				System.out.println("id:" + bancoDTO.getIdBanco() + ", nombre: " + bancoDTO.getNombre());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void buscar(){
		
		BancoDAO banco = new BancoDAO();
		try {
			ArrayList<BancoDTO> bancos = banco.buscar(2);
			for (BancoDTO bancoDTO : bancos) {
				System.out.println("Banco buscado: " + bancoDTO.getNombre());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void actualizarTest(){
		BancoDAO dao = new BancoDAO();
		BancoDTO dto = new BancoDTO();
		dto.setIdBanco(1);
		dto.setNombe("Banorte");
		
		try {
			assertTrue(dao.actualizar(dto));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void agregarTest(){
		BancoDAO dao = new BancoDAO();
		BancoDTO dto = new BancoDTO();
		dto.setIdBanco(4);
		dto.setNombe("AMEX");
		
		try {
			dao.agregar(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void eliminarTest(){
		BancoDAO dao = new BancoDAO();

		try {
			dao.eliminar(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
