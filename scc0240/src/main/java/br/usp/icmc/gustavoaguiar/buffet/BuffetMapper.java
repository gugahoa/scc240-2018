package br.usp.icmc.gustavoaguiar.buffet;

import br.usp.icmc.gustavoaguiar.festa.FestaEntity;
import br.usp.icmc.gustavoaguiar.festa.FestaMapper;
import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BuffetMapper implements EntityMapper<BuffetEntity> {
    private FestaMapper festaMapper = new FestaMapper();

    @Override
    public HashMap<String, Object> mapObject(BuffetEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.putAll(festaMapper.mapObject(obj));
        map.put("festa", obj.getData());
        map.put("cardapio", obj.getCardapio());
        return map;
    }

    @Override
    public BuffetEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        BuffetEntity buffetEntity = new BuffetEntity();
        try {
            FestaEntity festaEntity = festaMapper.mapRow(rs, rowNum);
            buffetEntity.setData(festaEntity.getData());
            buffetEntity.setTipo(festaEntity.getTipo());
            buffetEntity.setDecorador(festaEntity.getDecorador());
            buffetEntity.setLocal(festaEntity.getLocal());
        } catch (SQLException e) {
            // ignore
        }

        buffetEntity.setCardapio(rs.getString("cardapio"));
        buffetEntity.setFesta(rs.getTimestamp("festa"));
        return buffetEntity;
    }
}
