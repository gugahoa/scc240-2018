package br.usp.icmc.gustavoaguiar.prato;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PratoRepository extends AbstractRepository<PratoEntity> {
    public PratoRepository(NamedParameterJdbcTemplate jdbc) {
        super(new PratoMapper(), jdbc);
    }

    private final String CREATE_PRATO = "INSERT INTO pratos (cardapio, refeicao) VALUES (:cardapio, :refeicao) RETURNING *";
    public PratoEntity create(PratoEntity pratoEntity) {
        return create(CREATE_PRATO, pratoEntity);
    }

    private final String GET_PRATO = "SELECT * FROM pratos WHERE cardapio = :cardapio AND refeicao = :refeicao";
    public PratoEntity get(String cardapio, String refeicao) {
        return query(GET_PRATO, ImmutableMap.of("cardapio", cardapio, "refeicao", refeicao));
    }

    private final String DELETE_PRATO = "DELETE FROM pratos WHERE cardapio = :cardapio AND refeicao = :refeicao";
    public boolean delete(String cardapio, String refeicao) {
        return update(DELETE_PRATO, ImmutableMap.of("cardapio", cardapio, "refeicao", refeicao)) == 1;
    }
}
