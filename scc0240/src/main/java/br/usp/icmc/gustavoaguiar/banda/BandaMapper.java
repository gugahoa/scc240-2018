package br.usp.icmc.gustavoaguiar.banda;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BandaMapper implements EntityMapper<BandaEntity> {
    @Override
    public HashMap<String, Object> mapObject(BandaEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nome", obj.getNome());
        map.put("integrantes", obj.getIntegrantes());
        return map;
    }

    @Override
    public BandaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        BandaEntity banda = new BandaEntity();
        banda.setIntegrantes((String[]) rs.getArray("integrantes").getArray());
        banda.setNome(rs.getString("nome"));
        return banda;
    }
}
