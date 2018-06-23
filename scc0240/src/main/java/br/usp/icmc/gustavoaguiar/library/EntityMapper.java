package br.usp.icmc.gustavoaguiar.library;

import org.springframework.jdbc.core.RowMapper;

import java.util.Map;

public interface EntityMapper<T> extends RowMapper<T> {
    Map<String, Object> mapObject(T obj);
}
