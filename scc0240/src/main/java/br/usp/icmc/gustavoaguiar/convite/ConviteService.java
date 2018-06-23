package br.usp.icmc.gustavoaguiar.convite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConviteService {
    @Autowired
    private ConviteRepository conviteRepository;

    public ConviteEntity create(ConviteEntity convite) {
        return conviteRepository.create(convite);
    }

    public ConviteEntity get(Long qrcode) {
        return conviteRepository.get(qrcode);
    }

    public boolean delete(Long qrcode) {
        return conviteRepository.delete(qrcode);
    }

    public boolean update(ConviteEntity conviteEntity) {
        return conviteRepository.update(conviteEntity);
    }
}
