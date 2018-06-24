package br.usp.icmc.gustavoaguiar.empresa.fantasia;

import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosService;
import org.springframework.stereotype.Service;

@Service
public class EmpresaFantasiaService extends BaseTerceirizadosService<EmpresaFantasiaEntity, EmpresaFantasiaRepository> {
    public EmpresaFantasiaService(EmpresaFantasiaRepository empresaFantasiaRepository) {
        super(empresaFantasiaRepository);
    }
}
