package br.usp.icmc.gustavoaguiar.layout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LayoutService {
    @Autowired
    private LayoutRepository layoutRepository;

    public LayoutEntity create(LayoutEntity layoutEntity) {
        return layoutRepository.create(layoutEntity);
    }

    public LayoutEntity get(String tipo) {
        return layoutRepository.get(tipo);
    }

    public boolean delete(String tipo) {
        return layoutRepository.delete(tipo);
    }

    public boolean update(LayoutEntity layoutEntity) {
        return layoutRepository.update(layoutEntity);
    }
}
