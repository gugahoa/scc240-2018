package br.usp.icmc.gustavoaguiar.layout;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LayoutRepository extends AbstractRepository<LayoutEntity> {
    public LayoutRepository(NamedParameterJdbcTemplate jdbc) {
        super(new LayoutMapper(), jdbc);
    }

    private final String CREATE_LAYOUT = "INSERT INTO layout (tipo, image) VALUES(:tipo, :image) RETURNING *";
    public LayoutEntity create(LayoutEntity layout) {
        return create(CREATE_LAYOUT, layout);
    }

    private final String GET_LAYOUT = "SELECT * FROM layout WHERE tipo = :tipo";
    public LayoutEntity get(String tipo) {
        return query(GET_LAYOUT, ImmutableMap.of("tipo", tipo.toLowerCase()));
    }

    private final String DELETE_LAYOUT = "DELETE FROM layout WHERE tipo = :tipo";
    public boolean delete(String tipo) {
        return update(DELETE_LAYOUT, ImmutableMap.of("tipo", tipo.toLowerCase())) == 1;
    }

    private final String UPDATE_LAYOUT = "UPDATE layout SET image = :image, tipo = :tipo WHERE tipo = :tipo";
    public boolean update(LayoutEntity layoutEntity) {
        return update(UPDATE_LAYOUT, layoutEntity);
    }
}
