package RESOURCE;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import CONTROL.LocalC;
import FRAMEWORK.CALLBACK.BusinessRuleException;
import FRAMEWORK.CALLBACK.ListReturn;
import FRAMEWORK.CALLBACK.ObjectReturn;
import MODEL.Constants;
import MODEL.GenericReturn;
import MODEL.LocalM;

@Path("/local")
public class LocalResource {
	private LocalC localControl;

	@GET
	@Path("/listarTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public GenericReturn listarTodos() throws Exception {
		localControl = new LocalC();
		GenericReturn retorno = new GenericReturn();
		localControl.listarTodos(new LocalM(), new ListReturn<LocalM>() {
			@Override
			public void Callback(List<LocalM> list) {
				retorno.setSucess(true);
				if (list == null || list.isEmpty()) {
					retorno.setMessage(Constants.NENHUM_REGISTRO_ENCONTRADO);
				} else {
					retorno.setListLocal(list);
				}
			}

			@Override
			public void CallbackException(BusinessRuleException e) {
				retorno.setSucess(true);
				retorno.setMessage(e.getMessage());
			}
		});
		return retorno;
	}

	@POST
	@Path("/adicionarLocal")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public GenericReturn adicionarLocal(LocalM local) throws Exception {
		localControl = new LocalC();
		GenericReturn retorno = new GenericReturn();

		if (!isPosicaoEValida(local)) {
			retorno.setSucess(true);
			notificaPosicao(retorno, local);
			return retorno;
		}

		localControl.adicionarLocal(local, new ObjectReturn<Integer>() {
			@Override
			public void Callback(Integer Object) {
				retorno.setSucess(true);
				retorno.setMessage(Constants.LOCAL_INSERIDO_COM_SUCESSO);
			}

			@Override
			public void CallbackException(BusinessRuleException e) {
				retorno.setSucess(true);
				retorno.setMessage(e.getMessage());
			}
		});
		return retorno;
	}

	@POST
	@Path("/localProximo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public GenericReturn localProximo(LocalM local) throws Exception {
		localControl = new LocalC();
		GenericReturn retorno = new GenericReturn();

		if (!isPosicaoEValida(local)) {
			retorno.setSucess(true);
			notificaPosicao(retorno, local);
			return retorno;
		}
		localControl.buscaLocalProximo(local, new ListReturn<LocalM>() {
			@Override
			public void Callback(List<LocalM> list) {
				retorno.setSucess(true);
				if (list == null || list.isEmpty()) {
					retorno.setMessage(Constants.NENHUM_REGISTRO_ENCONTRADO);
				} else {
					retorno.setListLocal(list);
				}
			}
			@Override
			public void CallbackException(BusinessRuleException e) {
				retorno.setSucess(true);
				retorno.setMessage(e.getMessage());
			}
		});
		return retorno;
	}

	private void notificaPosicao(GenericReturn retorno, LocalM local) {
		String msg = "";
		if (posicaoXinvalida(local.getPosicaoX()))
			msg = Constants.X_MAIOR_QUE_ZERO;
		if (posicaoYinvalida(local.getPosicaoY())) {
			msg = msg + Constants.Y_MAIOR_QUE_ZERO;
		}
		retorno.setMessage(msg);
	}

	private boolean posicaoYinvalida(int posicaoY) {
		if (posicaoY < 0)
			return true;
		return false;
	}

	private boolean posicaoXinvalida(int posicaoX) {
		if (posicaoX < 0)
			return true;
		return false;
	}

	private boolean isPosicaoEValida(LocalM local) {
		if (local.getPosicaoX() < 0 || local.getPosicaoY() < 0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		LocalM locals = new LocalM();
		locals.setDescricao("teste");
		locals.setPosicaoX(10);
		locals.setPosicaoY(6);

		Gson gson = new Gson();
		String json = gson.toJson(locals);
		System.out.println(json);
		String jsonInString = "{\"cd\":0,\"descricao\":\"teste\",\"posicaoX\":10,\"posicaoY\":6}";
		LocalM staff = gson.fromJson(jsonInString, LocalM.class);
		System.out.println(staff);
		new LocalC().buscaLocalProximo(null, new ListReturn<LocalM>() {
			@Override
			public void Callback(List<LocalM> list) {
				super.Callback(list);
			}
			@Override
			public void CallbackException(BusinessRuleException e) {
				super.CallbackException(e);
			}
		});
	}

}
