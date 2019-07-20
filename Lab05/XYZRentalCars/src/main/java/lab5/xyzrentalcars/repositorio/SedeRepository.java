package lab5.xyzrentalcars.repositorio;

import lab5.xyzrentalcars.modelo.entidades.Sede;

import javax.persistence.EntityManager;

public class SedeRepository {
    private final EntityManager manager;
    private DAOGenerico<Sede> dao;

    public SedeRepository(EntityManager manager){
        this.manager = manager;
        dao = new DAOGenerico<>(manager);
    }

    public Sede buscaPorId(Integer id) {
        return dao.buscaPorId(Sede.class, id);
    }

    public Sede salvaOuAtualiza(Sede sede) {
        return dao.salvaOuAtualiza(sede);
    }

    public void remove(Sede sede) {
        dao.remove(sede);
    }
}
