package MODEL;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenericReturn implements Serializable {

	private List<LocalM> listLocal;
	private LocalM objectLocal;
	private String message;
	private boolean sucess;

	public List<LocalM> getListLocal() {
		return listLocal;
	}

	public void setListLocal(List<LocalM> listLocal) {
		this.listLocal = listLocal;
	}

	public LocalM getObjectLocal() {
		return objectLocal;
	}

	public void setObjectLocal(LocalM objectLocal) {
		this.objectLocal = objectLocal;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

}
