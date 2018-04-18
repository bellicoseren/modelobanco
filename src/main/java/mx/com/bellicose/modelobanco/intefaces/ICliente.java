package mx.com.bellicose.modelobanco.intefaces;

import java.util.ArrayList;

import mx.com.bellicose.modelobanco.dto.ClienteDTO;

public interface ICliente {

	public ArrayList<ClienteDTO> leer() throws Exception;
	public ClienteDTO buscar(int idCliente) throws Exception;
	public boolean actualizar(ClienteDTO clienteDTO) throws Exception;
	public boolean agregar(ClienteDTO clienteDTO) throws Exception;
	public boolean eliminar(int idCliente) throws Exception;
}
