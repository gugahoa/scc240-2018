package br.usp.icmc.gustavoaguiar.festa;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class FestaMapper implements EntityMapper<FestaEntity> {
    @Override
    public HashMap<String, Object> mapObject(FestaEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", obj.getData());
        map.put("decorador", obj.getDecorador());
        map.put("local", obj.getLocal());
        map.put("tipo", obj.getTipo());
        return map;
    }

    @Override
    public FestaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        FestaEntity festaEntity = new FestaEntity();
        festaEntity.setData(rs.getTimestamp("data"));
        festaEntity.setLocal(rs.getString("local"));
        festaEntity.setDecorador(rs.getString("decorador"));
        festaEntity.setTipo(rs.getString("tipo"));
        return festaEntity;
    }
}
