//package DAO;
//
//import CALLBACK.BusinessRuleException;
//import CALLBACK.ListReturn;
//import CALLBACK.ObjectReturn;
//import MODEL.ClasseM;
//import REPOSITORY.INTERFACE.IClasse;
//import VIEW.StringResource;
//import javax.swing.JOptionPane;
//
///**
// * @author Rafael
// */
//public class ClasseDAO implements IClasse {
//
//    protected CRUD<ClasseM> crud;
//
//    public ClasseDAO() {
//        crud = CRUD.getInstance();
//    }
//
//    @Override
//    public void insertClasse(ClasseM objclasse, ObjectReturn<Integer> callback) {
//        try {
//            crud.insertOuUpdate(objclasse, callback);
//        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, StringResource.ERRO_AO_INSERIR + " : insertClasse " + erro.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteClasse(ClasseM marcaDelete, ObjectReturn<Boolean> callback) {
//        try {
//            crud.delete(marcaDelete, callback);
//        } catch (Exception ex) {
//            callback.CallbackException(new BusinessRuleException(StringResource.ERRO_AO_DELETAR + " : deleteClasse " + ex.getMessage()));
//        }
//    }
//
//    @Override
//    public void preencheJcomboClasse(ListReturn<ClasseM> callback) {
//        try {
//            crud.buscaSQLList("from ClasseM order by descricao", callback);
//        } catch (Exception erro) {
//            JOptionPane.showMessageDialog(null, StringResource.ERRO_AO_BUSCAR_DADOS + " : preencheJcomboClasse " + erro.getMessage());
//        }
//    }
//}
