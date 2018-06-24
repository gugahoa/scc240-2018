package br.usp.icmc.gustavoaguiar.festa;

import br.usp.icmc.gustavoaguiar.buffet.BuffetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FestaService {
    @Autowired
    private FestaRepository festaRepository;

    public FestaEntity create(FestaEntity festaEntity) {
        return festaRepository.create(festaEntity);
    }

    public FestaEntity get(Timestamp data) {
        return festaRepository.get(data);
    }

    public boolean update(FestaEntity festaEntity) {
        return festaRepository.update(festaEntity);
    }

    public boolean delete(Timestamp data) {
        return festaRepository.delete(data);
    }
}
