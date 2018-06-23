package br.usp.icmc.gustavoaguiar.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.Map;

public abstract class AbstractRepository<T extends AbstractEntity> {
    protected static final Logger LOG = LoggerFactory.getLogger("data_access");

    private EntityMapper<T> MAPPER;
    protected final NamedParameterJdbcTemplate jdbc;

    public AbstractRepository(EntityMapper<T> MAPPER, NamedParameterJdbcTemplate jdbc) {
        this.MAPPER = MAPPER;
        this.jdbc = jdbc;
    }

    protected T create(String sql, T object) {
        return update(sql, MAPPER.mapObject(object), MAPPER);
    }

    protected int update(String sql, Map<String, Object> parameters) {
        return apply(sql, parameters, jdbc::update);
    }

    protected <T> T update(String sql, Map<String, Object> parameters, RowMapper<T> tClass) {
        return apply(sql, parameters, tClass, jdbc::queryForObject);
    }

    protected boolean update(String sql, T object) {
        return update(sql, MAPPER.mapObject(object)) == 1;
    }

    protected T query(String sql) {
        return query(sql, null, MAPPER);
    }

    protected T query(String sql, T object) {
        return query(sql, MAPPER.mapObject(object), MAPPER);
    }

    protected T query(String sql, Map<String, Object> parameters) {
        return query(sql, parameters, MAPPER);
    }

    protected <T> T query(String sql, Map<String, Object> parameters, RowMapper<T> rowMapper) {
        return querySingle(applyList(sql, parameters, rowMapper, jdbc::query));
    }

    private <T> T querySingle(List<T> list) {
        if (list.size() > 1) {
            LOG.error("Incorrect number of results ({}): {}", list.size(), list);
            return null;
        }

        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    private <U> U apply(String statement, Map<String, Object> params, BiFunction<String, Map<String, Object>, U> consume) {
        LOG.debug("STATEMENT: {}", statement);
        if (!CollectionUtils.isEmpty(params)) {
            LOG.debug("{} PARAMETERS: {}", params.size(), params);
        }

        U u = consume.apply(statement, params);
        LOG.debug("{} result", u == null ? '0' : '1');
        return u;
    }

    private <U, V> U apply(String statement, Map<String, Object> params, V mapper, TriFunction<String, Map<String, Object>, V, U> consume) {
        LOG.debug("STATEMENT: {}", statement);
        if (!CollectionUtils.isEmpty(params)) {
            LOG.debug("{} PARAMETERS: {}", params.size(), params);
        }

        U u = consume.apply(statement, params, mapper);
        LOG.debug("{} result", u == null ? '0' : '1');
        return u;
    }

    private <U, V> List<U> applyList(String statement, Map<String, Object> params, V mapper, TriFunction<String, Map<String, Object>, V, List<U>> consume) {
        LOG.debug("STATEMENT: {}", statement);
        if (!CollectionUtils.isEmpty(params)) {
            LOG.debug("{} PARAMETERS: {}", params.size(), params);
        }

        List<U> list = consume.apply(statement, params, mapper);
        if (CollectionUtils.isEmpty(list)) {
            list = Collections.emptyList();
        }

        LOG.debug("{} results", list.size());
        return list;
    }
}
