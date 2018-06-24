package br.usp.icmc.gustavoaguiar.terceirizados;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class TerceirizadosMapper implements EntityMapper<TerceirizadosEntity> {
    @Override
    public HashMap<String, Object> mapObject(TerceirizadosEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cnpj", obj.getCnpj());
        map.put("contato", obj.getContato());
        map.put("tipo", obj.getTipo());
        return map;
    }

    @Override
    public TerceirizadosEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        TerceirizadosEntity terceirizadosEntity = new TerceirizadosEntity();
        terceirizadosEntity.setCnpj(rs.getString("cnpj"));
        terceirizadosEntity.setContato(rs.getString("contato"));
        terceirizadosEntity.setTipo(rs.getString("tipo"));
        return terceirizadosEntity;
    }
}
