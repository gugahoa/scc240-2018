package br.usp.icmc.gustavoaguiar.refeicao;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import org.springframework.http.ResponseEntity;
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
}
