package br.usp.icmc.gustavoaguiar.empresa.mesa;

import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class EmpresaMesaService extends BaseTerceirizadosService<EmpresaMesaEntity, EmpresaMesaRepository> {
    private EmpresaMesaRepository empresaMesaRepository;
    public EmpresaMesaService(EmpresaMesaRepository empresaFantasiaRepository) {
        super(empresaFantasiaRepository);
        this.empresaMesaRepository = empresaFantasiaRepository;
    }

    @Transactional
    public boolean create_mesa(String cnpj) {
        Long mesa = empresaMesaRepository.create_mesa();
        return empresaMesaRepository.create_disponibiliza(cnpj, mesa);
    }

    public int allocate_mesas(Timestamp festa, Long mesas) {
        return empresaMesaRepository.allocate_mesas(festa, mesas);
    }

    public boolean delete_possui_mesa(Timestamp festa) {
        return empresaMesaRepository.delete_possui_mesa(festa);
    }
}
