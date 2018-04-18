package mx.com.bellicose.modelobanco.intefaces;

import java.util.ArrayList;

import mx.com.bellicose.modelobanco.dto.BancoDTO;

public interface IBanco {

	public ArrayList<BancoDTO> leer() throws Exception;
	public ArrayList<BancoDTO> buscar(int idBanco) throws Exception;
	public boolean actualizar(BancoDTO bancoDTO) throws Exception;
	public boolean agregar(BancoDTO bancoDTO) throws Exception;
	public boolean eliminar(int idBanco) throws Exception;
}
