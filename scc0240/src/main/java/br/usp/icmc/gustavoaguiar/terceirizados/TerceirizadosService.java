package br.usp.icmc.gustavoaguiar.terceirizados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerceirizadosService {
    @Autowired
    private TerceirizadosRepository terceirizadosRepository;

    public TerceirizadosEntity create(TerceirizadosEntity terceirizadosEntity) {
        return terceirizadosRepository.create(terceirizadosEntity);
    }

    public TerceirizadosEntity get(String cnpj) {
        return terceirizadosRepository.get(cnpj);
    }

    public boolean update(TerceirizadosEntity terceirizadosEntity) {
        return terceirizadosRepository.update(terceirizadosEntity);
    }

    public boolean delete(String cnpj) {
        return terceirizadosRepository.delete(cnpj);
    }
}
