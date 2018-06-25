package br.usp.icmc.gustavoaguiar.cardapio;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CardapioMapper implements EntityMapper<CardapioEntity> {
    @Override
    public HashMap<String, Object> mapObject(CardapioEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nome", obj.getNome());
        return map;
    }

    @Override
    public CardapioEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        CardapioEntity cardapioEntity = new CardapioEntity();
        cardapioEntity.setNome(rs.getString("nome"));
        return cardapioEntity;
    }
}
