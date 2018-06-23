package br.usp.icmc.gustavoaguiar.layout;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LayoutMapper implements EntityMapper<LayoutEntity> {
    @Override
    public LayoutEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        LayoutEntity layout = new LayoutEntity();
        layout.setTipo(rs.getString("tipo"));
        layout.setImage(rs.getBytes("image"));

        return layout;
    }

    public HashMap<String, Object> mapObject(LayoutEntity layout) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("tipo", layout.getTipo().toLowerCase());
        map.put("image", layout.getImage());

        return map;
    }
}
