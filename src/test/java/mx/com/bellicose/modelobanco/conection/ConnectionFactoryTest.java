package mx.com.bellicose.modelobanco.conection;

import junit.framework.TestCase;
import mx.com.bellicose.modelobanco.connection.ConnectionFactory;

import org.junit.Test;
public class ConnectionFactoryTest extends TestCase {
	
	@Test
	public void test(){
		ConnectionFactory conexion = ConnectionFactory.getInstance();
		Object obj = conexion.getConection();
		assertNotNull(obj);
	}
}
