package br.usp.icmc.gustavoaguiar.buffet;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class BuffetRepository extends AbstractRepository<BuffetEntity> {
    public BuffetRepository(NamedParameterJdbcTemplate jdbc) {
        super(new BuffetMapper(), jdbc);
    }

    private final String CREATE_BUFFET = "INSERT INTO buffet (festa, cardapio) VALUES (:festa, :cardapio) RETURNING *";
    public BuffetEntity create(BuffetEntity buffetEntity) {
        return create(CREATE_BUFFET, buffetEntity);
    }

    private final String GET_BUFFET = "SELECT * FROM buffet, festa WHERE festa = :festa AND data = :festa";
    public BuffetEntity get(Timestamp festa) {
        return query(GET_BUFFET, ImmutableMap.of("festa", festa));
    }

    private final String UPDATE_BUFFET = "UPDATE buffet SET cardapio = :cardapio WHERE festa = :festa";
    public boolean update(BuffetEntity buffetEntity) {
        return update(UPDATE_BUFFET, buffetEntity);
    }

    private final String DELETE_BUFFET = "DELETE FROM buffet WHERE festa = :festa";
    public boolean delete(Timestamp festa) {
        return update(DELETE_BUFFET, ImmutableMap.of("festa", festa)) == 1;
    }

    private final String HIRE_BANDA = "INSERT INTO palco(banda, buffet, montagem) SELECT :banda, :buffet, cnpj as montagem FROM montagem_palco ORDER BY random() LIMIT 1;";
    public boolean hireBanda(Timestamp buffet, String banda) {
        return update(HIRE_BANDA, ImmutableMap.of("buffet", buffet, "banda", banda)) == 1;
    }
}
