package lab5.xyzrentalcars.repositorio;

import lab5.xyzrentalcars.modelo.EntidadeBase;

import javax.persistence.EntityManager;
import java.util.Objects;

public class DAOGenerico <T extends EntidadeBase>{
    private final EntityManager manager;

    DAOGenerico(EntityManager manager){
        this.manager = manager;
    }

    T buscaPorId(Class<T> clazz, Integer id){
        return manager.find(clazz,id);
    }

    T salvaOuAtualiza(T t){
        if(Objects.isNull((t.getId()))){
            manager.persist(t);
        } else {
            manager.merge(t);
        }
        return t;
    }

    void remove(T t){
        manager.remove(t);
        manager.flush();
    }
}
