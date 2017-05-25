package DAO;

import FRAMEWORK.CALLBACK.BusinessRuleException;
import FRAMEWORK.CALLBACK.ListReturn;
import FRAMEWORK.CALLBACK.ObjectReturn;
import MODEL.LocalM;

public class LocalDAO {
	protected CRUD<LocalM> crud;

	public LocalDAO() {
		crud = CRUD.getInstance();
	}

	public void adicionarLocal(LocalM objlocal, ObjectReturn<Integer> callback) {
		try {
			crud.insertOuUpdate(objlocal, callback);
		} catch (Exception erro) {
			callback.CallbackException(new BusinessRuleException(erro.getMessage()));
		}
	}

	public void listarTodos(LocalM objLocal, ListReturn<LocalM> callback) {
		try {
			crud.listarTodos(objLocal, callback);
		} catch (Exception erro) {
			callback.CallbackException(new BusinessRuleException(erro.getMessage()));
		}
	}

	public void buscaLocalProximo(LocalM local,ListReturn<LocalM> callback) {
		try {
			String hql2="FROM LocalM where (((ABS(posicaox-"+local.getPosicaoX()+"))+(ABS(posicaoy-"+local.getPosicaoY()+"))))<=10";
			crud.buscaSQLList(hql2, callback);
		} catch (Exception erro) {
			callback.CallbackException(new BusinessRuleException(erro.getMessage()));
		}
	}
}
