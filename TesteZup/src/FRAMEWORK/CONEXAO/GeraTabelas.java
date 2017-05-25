package FRAMEWORK.CONEXAO;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import CONTROL.LocalC;
import FRAMEWORK.CALLBACK.BusinessRuleException;
import FRAMEWORK.CALLBACK.ObjectReturn;
import MODEL.LocalM;

public class GeraTabelas {

    public static void main(String[] args) throws Exception {
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.addAnnotatedClass(LocalM.class);

        SchemaExport se = new SchemaExport(cfg);
        se.create(true, true);

        LocalC localControl= new LocalC();

        LocalM objlocal1 = new LocalM();
        objlocal1.setDescricao("Lanchonete");
        objlocal1.setPosicaoX(27);
        objlocal1.setPosicaoY(12);
    
        localControl.adicionarLocal(objlocal1, new ObjectReturn<Integer>() {
        	@Override
        	public void Callback(Integer Object) {
        		System.out.println("INSERIDO : "+objlocal1.getDescricao());
        	}
        	@Override
        	public void CallbackException(BusinessRuleException e) {
        		super.CallbackException(e);
        	}
		});

        LocalM objlocal2 = new LocalM();
        objlocal2.setDescricao("Posto");
        objlocal2.setPosicaoX(31);
        objlocal2.setPosicaoY(18);

        localControl.adicionarLocal(objlocal2, new ObjectReturn<Integer>() {
        	@Override
        	public void Callback(Integer Object) {
        		System.out.println("INSERIDO : "+objlocal2.getDescricao());
        	}
        	@Override
        	public void CallbackException(BusinessRuleException e) {
        		super.CallbackException(e);
        	}
		});
        
        LocalM objlocal3 = new LocalM();
        objlocal3.setDescricao("Joalheria");
        objlocal3.setPosicaoX(15);
        objlocal3.setPosicaoY(12);

        localControl.adicionarLocal(objlocal3, new ObjectReturn<Integer>() {
        	@Override
        	public void Callback(Integer Object) {
        		System.out.println("INSERIDO : "+objlocal3.getDescricao());
        	}
        	@Override
        	public void CallbackException(BusinessRuleException e) {
        		super.CallbackException(e);
        	}
		});
        
        LocalM objlocal4 = new LocalM();
        objlocal4.setDescricao("Floricultura");
        objlocal4.setPosicaoX(19);
        objlocal4.setPosicaoY(21);

        localControl.adicionarLocal(objlocal4, new ObjectReturn<Integer>() {
        	@Override
        	public void Callback(Integer Object) {
        		System.out.println("INSERIDO : "+objlocal4.getDescricao());
        	}
        	@Override
        	public void CallbackException(BusinessRuleException e) {
        		super.CallbackException(e);
        	}
		});
        
        LocalM objlocal5 = new LocalM();
        objlocal5.setDescricao("Pub");
        objlocal5.setPosicaoX(12);
        objlocal5.setPosicaoY(8);

        localControl.adicionarLocal(objlocal5, new ObjectReturn<Integer>() {
        	@Override
        	public void Callback(Integer Object) {
        		System.out.println("INSERIDO : "+objlocal5.getDescricao());
        	}
        	@Override
        	public void CallbackException(BusinessRuleException e) {
        		super.CallbackException(e);
        	}
		});
        
        LocalM objlocal6 = new LocalM();
        objlocal6.setDescricao("Supermercado");
        objlocal6.setPosicaoX(23);
        objlocal6.setPosicaoY(6);

        localControl.adicionarLocal(objlocal6, new ObjectReturn<Integer>() {
        	@Override
        	public void Callback(Integer Object) {
        		System.out.println("INSERIDO : "+objlocal6.getDescricao());
        	}
        	@Override
        	public void CallbackException(BusinessRuleException e) {
        		super.CallbackException(e);
        	}
		});
        
        LocalM objlocal7 = new LocalM();
        objlocal7.setDescricao("Churrascaria");
        objlocal7.setPosicaoX(28);
        objlocal7.setPosicaoY(2);

        localControl.adicionarLocal(objlocal7, new ObjectReturn<Integer>() {
        	@Override
        	public void Callback(Integer Object) {
        		System.out.println("INSERIDO : "+objlocal7.getDescricao());
        	}
        	@Override
        	public void CallbackException(BusinessRuleException e) {
        		super.CallbackException(e);
        	}
		});
        
        System.out.println("******** INSERIDO ********");
        System.out.println(objlocal1.getDescricao() + " Posicao X: "+objlocal1.getPosicaoX()+" Posicao Y: "+objlocal1.getPosicaoY());
        System.out.println(objlocal2.getDescricao() + " Posicao X: "+objlocal2.getPosicaoX()+" Posicao Y: "+objlocal2.getPosicaoY());
        System.out.println(objlocal3.getDescricao() + " Posicao X: "+objlocal3.getPosicaoX()+" Posicao Y: "+objlocal3.getPosicaoY());
        System.out.println(objlocal4.getDescricao() + " Posicao X: "+objlocal4.getPosicaoX()+" Posicao Y: "+objlocal4.getPosicaoY());
        System.out.println(objlocal5.getDescricao() + " Posicao X: "+objlocal5.getPosicaoX()+" Posicao Y: "+objlocal5.getPosicaoY());
        System.out.println(objlocal6.getDescricao() + " Posicao X: "+objlocal6.getPosicaoX()+" Posicao Y: "+objlocal6.getPosicaoY());
        System.out.println(objlocal7.getDescricao() + " Posicao X: "+objlocal7.getPosicaoX()+" Posicao Y: "+objlocal7.getPosicaoY());
        System.out.println("******** CRIADO COM SUCESSO ********");
        
//        'Lanchonete' (x=27, y=12)
//        'Posto' (x=31, y=18)
//        'Joalheria' (x=15, y=12)
//        'Floricultura' (x=19, y=21)
//        'Pub' (x=12, y=8)
//        'Supermercado' (x=23, y=6)
//        'Churrascaria' (x=28, y=2)
    }
}
