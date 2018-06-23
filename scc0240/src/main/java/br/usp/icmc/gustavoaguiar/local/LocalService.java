package br.usp.icmc.gustavoaguiar.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalService {
    @Autowired
    private LocalRepository localRepository;

    public boolean delete(String endereco) {
        return localRepository.delete(endereco);
    }

    public LocalEntity create(LocalEntity localEntity) {
        return localRepository.create(localEntity);
    }

    public LocalEntity get(String endereco) {
        return localRepository.get(endereco);
    }

    public boolean update(LocalEntity localEntity) {
        return localRepository.update(localEntity);
    }
}
