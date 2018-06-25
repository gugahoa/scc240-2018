package br.usp.icmc.gustavoaguiar.prepara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreparaService {
    @Autowired
    private PreparaRepository preparaRepository;

    public PreparaEntity create(PreparaEntity preparaEntity) {
        return preparaRepository.create(preparaEntity);
    }

    public PreparaEntity get(String refeicao, String equipe) {
        return preparaRepository.get(refeicao, equipe);
    }

    public boolean delete(String equipe, String refeicao) {
        return preparaRepository.delete(equipe, refeicao);
    }
}
