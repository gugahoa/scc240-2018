package br.usp.icmc.gustavoaguiar.buffet;

import br.usp.icmc.gustavoaguiar.festa.FestaRepository;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class BuffetService {
    @Autowired
    private BuffetRepository buffetRepository;

    @Autowired
    private FestaRepository festaRepository;

    @Transactional
    public BuffetEntity create(BuffetEntity buffetEntity) {
        buffetEntity.setTipo("B");
        buffetEntity.setFesta(buffetEntity.getData());
        festaRepository.create(buffetEntity);
        return buffetRepository.create(buffetEntity);
    }

    public BuffetEntity get(Timestamp festa) {
        BuffetEntity buffetEntity = buffetRepository.get(festa);
        if (buffetEntity == null) {
            throw new ResourceNotFound("Buffet not found");
        }

        return buffetEntity;
    }

    @Transactional
    public boolean update(BuffetEntity buffetEntity) {
        return festaRepository.update(buffetEntity) && buffetRepository.update(buffetEntity);
    }

    @Transactional
    public boolean delete(Timestamp festa) {
        return buffetRepository.delete(festa) && festaRepository.delete(festa);
    }
}
