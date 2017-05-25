package RESOURCE;

import static org.junit.Assert.*;

import org.junit.Test;

import MODEL.Constants;
import MODEL.GenericReturn;
import MODEL.LocalM;

public class LocalResourceTest extends LocalResource {

	/**
	 * TODOS OS TESTES GERADOS A PARTIR DA CRIAÇÃO DE REGISTROS PARA TESTE (7 REGISTROS)
	 * nos testes, não foi feito testes com null ou numberformat por questao do web service ja fazer este filtro.
	 */
	@Test
	public void testListarTodos() throws Exception {
		GenericReturn retornolocal=new GenericReturn();
		retornolocal=listarTodos();
		System.out.println("Quantiade de registros encontrados: "+retornolocal.getListLocal().size());
		assertEquals(7,retornolocal.getListLocal().size());
	}
	
	@Test
	public void testLocalProximo() throws Exception {
		GenericReturn retornolocal=new GenericReturn();
		LocalM localTest = new LocalM();
		localTest.setPosicaoX(20);
		localTest.setPosicaoY(10);
		retornolocal=localProximo(localTest);
		assertEquals(4,retornolocal.getListLocal().size());
	}
	
	@Test
	public void testAdicionarLocal() throws Exception {
		GenericReturn retornolocal=new GenericReturn();
		LocalM localTest = new LocalM();
		localTest.setPosicaoX(4);
		localTest.setPosicaoY(8);
		localTest.setDescricao("Academia");
		retornolocal=adicionarLocal(localTest);
		assertEquals(Constants.LOCAL_INSERIDO_COM_SUCESSO,retornolocal.getMessage());
	}
	
}