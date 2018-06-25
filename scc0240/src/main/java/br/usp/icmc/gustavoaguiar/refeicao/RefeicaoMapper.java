package br.usp.icmc.gustavoaguiar.refeicao;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class RefeicaoMapper implements EntityMapper<RefeicaoEntity> {
    @Override
    public HashMap<String, Object> mapObject(RefeicaoEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("nome", obj.getNome());
        map.put("tipo", obj.getTipo());
        return map;
    }

    @Override
    public RefeicaoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        RefeicaoEntity refeicaoEntity = new RefeicaoEntity();
        refeicaoEntity.setNome(rs.getString("nome"));
        refeicaoEntity.setTipo(rs.getString("tipo"));
        return refeicaoEntity;
    }
}
