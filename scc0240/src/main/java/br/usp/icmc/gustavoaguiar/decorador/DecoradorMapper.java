package br.usp.icmc.gustavoaguiar.decorador;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DecoradorMapper implements EntityMapper<DecoradorEntity> {
    @Override
    public HashMap<String, Object> mapObject(DecoradorEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cnpj", obj.getCnpj());
        map.put("contato", obj.getCnpj());
        return map;
    }

    @Override
    public DecoradorEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        DecoradorEntity decoradorEntity = new DecoradorEntity();
        decoradorEntity.setCnpj(rs.getString("cnpj"));
        decoradorEntity.setCnpj(rs.getString("contato"));
        return decoradorEntity;
    }
}
