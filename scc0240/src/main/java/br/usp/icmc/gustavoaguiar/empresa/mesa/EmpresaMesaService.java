package br.usp.icmc.gustavoaguiar.empresa.mesa;

import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosService;
import org.springframework.stereotype.Service;

@Service
public class EmpresaMesaService extends BaseTerceirizadosService<EmpresaMesaEntity, EmpresaMesaRepository> {
    public EmpresaMesaService(EmpresaMesaRepository empresaFantasiaRepository) {
        super(empresaFantasiaRepository);
    }
}
