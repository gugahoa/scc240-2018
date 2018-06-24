package br.usp.icmc.gustavoaguiar.festa;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class FestaRepository extends AbstractRepository<FestaEntity> {
    public FestaRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        super(new FestaMapper(), jdbcTemplate);
    }

    private final String CREATE_FESTA = "INSERT INTO festa(data, local, decorador, tipo) VALUES (:data, :local, :decorador, :tipo) RETURNING *";
    public FestaEntity create(FestaEntity festaEntity) {
        return create(CREATE_FESTA, festaEntity);
    }

    private final String GET_FESTA = "SELECT * FROM festa WHERE data = :data";
    public FestaEntity get(Timestamp data) {
        return query(GET_FESTA, ImmutableMap.of("data", data));
    }

    private final String UPDATE_FESTA = "UPDATE festa SET local = :local, decorador = :decorador WHERE data = :data ";
    public boolean update(FestaEntity festaEntity) {
        return update(UPDATE_FESTA, festaEntity);
    }

    private final String DELETE_FESTA = "DELETE FROM festa WHERE data = :data";
    public boolean delete(Timestamp data) {
        return update(DELETE_FESTA, ImmutableMap.of("data", data)) == 1;
    }
}
