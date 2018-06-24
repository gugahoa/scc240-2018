package br.usp.icmc.gustavoaguiar.library;

import br.usp.icmc.gustavoaguiar.library.RepositoryCrud;
import br.usp.icmc.gustavoaguiar.terceirizados.TerceirizadosEntity;
import br.usp.icmc.gustavoaguiar.terceirizados.TerceirizadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BaseTerceirizadosService<K extends TerceirizadosEntity, T extends RepositoryCrud<K, String>> {
    private T genericRepository;

    public BaseTerceirizadosService(T genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Autowired
    private TerceirizadosRepository terceirizadosRepository;

    public K get(String cnpj) {
        return genericRepository.get(cnpj);
    }

    @Transactional
    public K create(K obj) {
        terceirizadosRepository.create(obj);
        return genericRepository.create(obj);
    }

    public boolean delete(String cnpj) {
        return terceirizadosRepository.delete(cnpj);
    }

    public boolean update(K obj) {
        return terceirizadosRepository.update(obj) && genericRepository.update(obj);
    }
}
