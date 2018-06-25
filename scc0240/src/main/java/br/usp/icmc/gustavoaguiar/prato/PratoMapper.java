package br.usp.icmc.gustavoaguiar.prato;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PratoMapper implements EntityMapper<PratoEntity> {
    @Override
    public HashMap<String, Object> mapObject(PratoEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("reficao", obj.getRefeicao());
        map.put("cardapio", obj.getCardapio());
        return map;
    }

    @Override
    public PratoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PratoEntity pratoEntity = new PratoEntity();
        pratoEntity.setCardapio(rs.getString("cardapio"));
        pratoEntity.setRefeicao(rs.getString("refeicao"));
        return pratoEntity;
    }
}
