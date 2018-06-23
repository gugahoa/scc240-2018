package br.usp.icmc.gustavoaguiar.convite;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ConviteMapper implements EntityMapper<ConviteEntity> {
    @Override
    public ConviteEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ConviteEntity conviteEntity = new ConviteEntity();
        conviteEntity.setDados(rs.getString("dados"));
        conviteEntity.setFesta(rs.getTimestamp("festa"));
        conviteEntity.setQrcode(rs.getLong("qrcode"));
        conviteEntity.setRemetente(rs.getString("remetente"));
        conviteEntity.setLayout(rs.getString("tipo_layout"));

        return conviteEntity;
    }

    public HashMap<String, Object> mapObject(ConviteEntity obj) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("remetente", obj.getRemetente());
        map.put("qrcode", obj.getQrcode());
        map.put("tipo_layout", obj.getLayout());
        map.put("dados", obj.getDados());
        map.put("festa", obj.getFesta());

        return map;
    }
}
