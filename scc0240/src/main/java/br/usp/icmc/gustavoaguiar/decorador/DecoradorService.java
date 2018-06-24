package br.usp.icmc.gustavoaguiar.decorador;

import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecoradorService {
    @Autowired
    private DecoradorRepository decoradorRepository;

    public DecoradorEntity create(DecoradorEntity decoradorEntity) {
        return decoradorRepository.create(decoradorEntity);
    }

    public DecoradorEntity get(String cnpj) {
        DecoradorEntity decoradorEntity = decoradorRepository.get(cnpj);
        if (decoradorEntity == null) {
            throw new ResourceNotFound("Decorador not found");
        }

        return decoradorEntity;
    }

    public boolean delete(String cnpj) {
        return decoradorRepository.delete(cnpj);
    }

    public boolean update(DecoradorEntity decoradorEntity) {
        return decoradorRepository.update(decoradorEntity);
    }
}
