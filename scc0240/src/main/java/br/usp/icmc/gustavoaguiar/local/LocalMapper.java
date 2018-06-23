package br.usp.icmc.gustavoaguiar.local;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LocalMapper implements EntityMapper<LocalEntity> {
    @Override
    public HashMap<String, Object> mapObject(LocalEntity obj) {
        HashMap map = new HashMap();
        map.put("comprovante", obj.getComprovante());
        map.put("endereco", obj.getEndereco().toLowerCase());
        map.put("custo", obj.getCusto());
        map.put("lotacao", obj.getLotacao());
        return map;
    }

    @Override
    public LocalEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocalEntity localEntity = new LocalEntity();
        localEntity.setComprovante(rs.getBoolean("comprovante"));
        localEntity.setCusto(rs.getInt("custo"));
        localEntity.setEndereco(rs.getString("endereco"));
        localEntity.setLotacao(rs.getInt("lotacao"));
        return localEntity;
    }
}
