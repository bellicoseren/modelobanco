package mx.com.bellicose.modelobanco.dto;

public class BancoDTO {

	private int idBanco;
	private String nombre;
	
	public int getIdBanco(){
		return idBanco;
	}
	public void setIdBanco(int idBanco){
		this.idBanco=idBanco;
	}
	
	public String getNombre(){
		return nombre;
	}
	public void setNombe(String nombre){
		this.nombre=nombre;
	}
	
	@Override
	public String toString() {
		return "id: " + idBanco + " " + ", nombre" + nombre;
	}
}
