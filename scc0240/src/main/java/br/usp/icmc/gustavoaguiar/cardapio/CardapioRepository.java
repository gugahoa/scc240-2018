package br.usp.icmc.gustavoaguiar.cardapio;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CardapioRepository extends AbstractRepository<CardapioEntity> {
    public CardapioRepository(NamedParameterJdbcTemplate jdbc) {
        super(new CardapioMapper(), jdbc);
    }

    private final String CREATE_CARDAPIO = "INSERT INTO cardapio (nome) VALUES (:nome) RETURNING *";
    public CardapioEntity create(CardapioEntity cardapioEntity) {
        return create(CREATE_CARDAPIO, cardapioEntity);
    }

    private final String GET_CARDAPIO = "SELECT * FORM cardapio WHERE nome = :nome";
    public CardapioEntity get(String nome) {
        return query(GET_CARDAPIO, ImmutableMap.of("nome", nome));
    }

    private final String UPDATE_CARDAPIO = "UPDATE cardapio SET nome = :nome WHERE nome = :nome";
    public boolean update(CardapioEntity cardapioEntity) {
        return update(UPDATE_CARDAPIO, cardapioEntity);
    }

    private final String DELETE_CARDAPIO = "DELETE FROM cardapio WHERE nome = :nome";
    public boolean delete(String nome) {
        return update("", ImmutableMap.of("nome", nome)) == 1;
    }
}
