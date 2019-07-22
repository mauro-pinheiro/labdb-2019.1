package lab5.xyzrentalcars.repositorio;

import lab5.xyzrentalcars.modelo.entidades.Carro;
import lab5.xyzrentalcars.modelo.enums.ClasseCarro;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CarroRepository {
    private final EntityManager manager;
    private DAOGenerico<Carro> dao;

    public CarroRepository(EntityManager manager){
        this.manager = manager;
        dao = new DAOGenerico<>(manager);
    }

    public Carro buscaPorId(Integer id) {
        return dao.buscaPorId(Carro.class, id);
    }

    public Carro salvaOuAtualiza(Carro carro) {
        return dao.salvaOuAtualiza(carro);
    }

    public void remove(Carro carro) {
        dao.remove(carro);
    }

    public List<Carro> buscaPorClasse(ClasseCarro classeCarro) {
        Query query = manager.createQuery("from Carro where classe = :classe");
        query.setParameter("classe", classeCarro);

        return query.getResultList();
    }
}
