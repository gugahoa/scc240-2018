package br.usp.icmc.gustavoaguiar.banda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandaService {
    @Autowired
    private BandaRepository bandaRepository;

    public BandaEntity create(BandaEntity bandaEntity) {
        return bandaRepository.create(bandaEntity);
    }

    public BandaEntity get(String nome) {
        return bandaRepository.get(nome);
    }

    public boolean update(BandaEntity bandaEntity) {
        return bandaRepository.update(bandaEntity);
    }

    public boolean delete(String nome) {
        return bandaRepository.delete(nome);
    }
}
