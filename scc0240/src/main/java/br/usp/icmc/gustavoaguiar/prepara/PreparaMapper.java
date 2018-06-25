package br.usp.icmc.gustavoaguiar.prepara;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PreparaMapper implements EntityMapper<PreparaEntity> {
    @Override
    public HashMap<String, Object> mapObject(PreparaEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("refeicao", obj.getRefeicao());
        map.put("equipe", obj.getEquipe());
        return map;
    }

    @Override
    public PreparaEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PreparaEntity preparaEntity = new PreparaEntity();
        preparaEntity.setEquipe(rs.getString("equipe"));
        preparaEntity.setRefeicao(rs.getString("refeicao"));
        return preparaEntity;
    }
}
