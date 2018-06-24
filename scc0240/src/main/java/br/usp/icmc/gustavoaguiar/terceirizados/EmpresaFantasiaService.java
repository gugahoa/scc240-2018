package br.usp.icmc.gustavoaguiar.terceirizados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaFantasiaService {
    @Autowired
    private EmpresaFantasiaRepository empresaFantasiaRepository;

    @Autowired
    private TerceirizadosRepository terceirizadosRepository;

    public boolean update(TerceirizadosEntity terceirizadosEntity) {
        return terceirizadosRepository.update(terceirizadosEntity);
    }

    @Transactional
    public EmpresaFantasiaEntity create(EmpresaFantasiaEntity empresaFantasiaEntity) {
        terceirizadosRepository.create(empresaFantasiaEntity);
        return empresaFantasiaRepository.create(empresaFantasiaEntity);
    }

    public EmpresaFantasiaEntity get(String cnpj) {
        return empresaFantasiaRepository.get(cnpj);
    }

    @Transactional
    public boolean delete(String cnpj) {
        terceirizadosRepository.delete(cnpj);
        return empresaFantasiaRepository.delete(cnpj);
    }
}
