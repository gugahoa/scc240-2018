package br.usp.icmc.gustavoaguiar.banda;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BandaRepository extends AbstractRepository<BandaEntity> {
    public BandaRepository(NamedParameterJdbcTemplate jdbc) {
        super(new BandaMapper(), jdbc);
    }

    private final String CREATE_BANDA = "INSERT INTO banda (nome, integrantes) VALUES (:nome, :integrantes) RETURNING *";
    public BandaEntity create(BandaEntity bandaEntity) {
        return create(CREATE_BANDA, bandaEntity);
    }

    private final String GET_BANDA = "SELECT * FROM banda WHERE nome = :nome";
    public BandaEntity get(String nome) {
        return query(GET_BANDA, ImmutableMap.of("nome", nome));
    }

    private final String UPDATE_BANDA = "UPDATE banda SET integrantes = :integrantes WHERE nome = :nome";
    public boolean update(BandaEntity bandaEntity) {
        return update(UPDATE_BANDA, bandaEntity);
    }

    private final String DELETE_BANDA = "DELETE FROM banda WHERE nome = :nome";
    public boolean delete(String nome) {
        return update(DELETE_BANDA, ImmutableMap.of("nome", nome)) == 1;
    }
}
