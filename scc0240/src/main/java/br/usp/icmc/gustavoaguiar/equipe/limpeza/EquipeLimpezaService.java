package br.usp.icmc.gustavoaguiar.equipe.limpeza;

import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class EquipeLimpezaService extends BaseTerceirizadosService<EquipeLimpezaEntity, EquipeLimpezaRepository> {
    private EquipeLimpezaRepository equipeLimpezaRepository;

    public EquipeLimpezaService(EquipeLimpezaRepository genericRepository) {
        super(genericRepository);
        this.equipeLimpezaRepository = genericRepository;
    }

    public boolean clean(Timestamp festa, String cnpj) {
        return equipeLimpezaRepository.clean(festa, cnpj);
    }
}
