package CONTROL;

import DAO.LocalDAO;
import FRAMEWORK.CALLBACK.ListReturn;
import FRAMEWORK.CALLBACK.ObjectReturn;
import MODEL.LocalM;

public class LocalC {

	private LocalDAO localDao;

	public void adicionarLocal(LocalM objLocal, ObjectReturn<Integer> callback) throws Exception {
		localDao = new LocalDAO();
		localDao.adicionarLocal(objLocal, callback);
	}
	
	public void listarTodos(LocalM objLocal, ListReturn<LocalM> callback){
		localDao = new LocalDAO();
		localDao.listarTodos(objLocal, callback);
	}

	public void buscaLocalProximo(LocalM local, ListReturn<LocalM> callback) {
		localDao = new LocalDAO();
		localDao.buscaLocalProximo(local, callback);
	}

}
