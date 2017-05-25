package FRAMEWORK.CONEXAO;

import org.hibernate.MappingException;
import org.hibernate.cfg.AnnotationConfiguration;

import MODEL.LocalM;

public class Generico {

    private static AnnotationConfiguration cfg;

    public static AnnotationConfiguration getAnnotationConfiguration() {
        try {
            if (cfg == null) {
                cfg = new AnnotationConfiguration();
                cfg.addAnnotatedClass(LocalM.class);
            }
            return cfg;
        } catch (MappingException e) {
            getAnnotationConfiguration();
        }
        return cfg;
    }
}
