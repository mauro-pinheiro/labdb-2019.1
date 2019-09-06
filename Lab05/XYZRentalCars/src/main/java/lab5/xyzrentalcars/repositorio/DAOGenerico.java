package lab5.xyzrentalcars.repositorio;

import lab5.xyzrentalcars.modelo.entidades.EntidadeBase;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
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

    List<T> buscaTodos(Class<T> clazz){
        Query query = manager.createQuery("from " + clazz.getSimpleName());

        return query.getResultList();
    }
}
