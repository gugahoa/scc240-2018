package br.usp.icmc.gustavoaguiar.terceirizados;

import br.usp.icmc.gustavoaguiar.library.EntityMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BaseTerceirizadosMapper<T extends TerceirizadosEntity> implements EntityMapper<T> {
    private Class<T> tClass;
    private TerceirizadosMapper terceirizadosMapper = new TerceirizadosMapper();

    public BaseTerceirizadosMapper(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public HashMap<String, Object> mapObject(T obj) {
        return terceirizadosMapper.mapObject(obj);
    }

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        T entity = null;
        try {
            entity = tClass.newInstance();
        } catch (Exception e) {
            // ignore
        }

        try {
            TerceirizadosEntity terceirizadosEntity = terceirizadosMapper.mapRow(rs, rowNum);
            entity.setCnpj(terceirizadosEntity.getCnpj());
            entity.setContato(terceirizadosEntity.getContato());
            entity.setTipo(terceirizadosEntity.getTipo());
        } catch (SQLException e) {
            // ignora
        }

        entity.setCnpj(rs.getString("cnpj"));
        return entity;
    }
}
