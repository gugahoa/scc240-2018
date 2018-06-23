package br.usp.icmc.gustavoaguiar.local;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LocalRepository extends AbstractRepository<LocalEntity> {
    public LocalRepository(NamedParameterJdbcTemplate jdbc) {
        super(new LocalMapper(), jdbc);
    }

    private final String CREATE_LOCAL = "INSERT INTO local (endereco, comprovante, custo, lotacao) VALUES (:endereco, :comprovante, :custo, :lotacao) RETURNING *";
    public LocalEntity create(LocalEntity localEntity) {
        return create(CREATE_LOCAL, localEntity);
    }

    private final String GET_LOCAL = "SELECT * FROM local WHERE endereco = :endereco";
    public LocalEntity get(String endereco) {
        return query(GET_LOCAL, ImmutableMap.of("endereco", endereco.toLowerCase()));
    }

    private final String UPDATE_LOCAL = "UPDATE local SET endereco = :endereco, custo = :custo, comprovante = :comprovante, lotacao = :lotacao WHERE endereco = :endereco;";
    public boolean update(LocalEntity localEntity) {
        return update(UPDATE_LOCAL, localEntity);
    }

    private final String DELETE_LOCAL = "DELETE FROM local WHERE endereco = :endereco";
    public boolean delete(String endereco) {
        return update(DELETE_LOCAL, ImmutableMap.of("endereco", endereco.toLowerCase())) == 1;
    }
}
