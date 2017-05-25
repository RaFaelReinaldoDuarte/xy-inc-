package MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class LocalM {
	@Id
	@SequenceGenerator(name = "GEN_CLASSE", sequenceName = "SEQ_CLASSE")
	@GeneratedValue(generator = "GEN_CLASSE")
	private int cd;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private int posicaoX;

	@Column(nullable = false)
	private int posicaoY;

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

}
