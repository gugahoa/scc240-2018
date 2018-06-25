package br.usp.icmc.gustavoaguiar.refeicao;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RefeicaoRepository extends AbstractRepository<RefeicaoEntity> {
    public RefeicaoRepository(NamedParameterJdbcTemplate jdbc) {
        super(new RefeicaoMapper(), jdbc);
    }

    private final String CREATE_REFEICAO = "INSERT INTO refeicao (nome, tipo) VALUES (:nome, :tipo) RETURNING *";
    public RefeicaoEntity create(RefeicaoEntity refeicaoEntity) {
        return create(CREATE_REFEICAO, refeicaoEntity);
    }

    private final String GET_REFEICAO = "SELECT * FROM refeicao WHERE nome = :nome";
    public RefeicaoEntity get(String nome) {
        return query(GET_REFEICAO, ImmutableMap.of("nome", nome));
    }

    private final String DELETE_REFEICAO = "DELETE FROM refeicao WHERE nome = :nome";
    public boolean delete(String nome) {
        return update(DELETE_REFEICAO, ImmutableMap.of("nome", nome)) == 1;
    }
}
