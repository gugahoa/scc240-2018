package br.usp.icmc.gustavoaguiar.decorador;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DecoradorRepository extends AbstractRepository<DecoradorEntity> {
    public DecoradorRepository(NamedParameterJdbcTemplate jdbc) {
        super(new DecoradorMapper(), jdbc);
    }

    private final String CREATE_DECORADOR = "INSERT INTO decorador (:cnpj, :contato) VALUES (:cnpj, :contato) RETURNING *";
    public DecoradorEntity create(DecoradorEntity decoradorEntity) {
        return create(CREATE_DECORADOR, decoradorEntity);
    }

    private final String GET_DECORADOR = "SELECT * FROM decorador WHERE cnpj = :cnpj";
    public DecoradorEntity get(String cnpj) {
        return query(GET_DECORADOR, ImmutableMap.of("cnpj", cnpj));
    }

    private final String DELETE_DECORADOR = "DELETE FROM decorador WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_DECORADOR, ImmutableMap.of("cnpj", cnpj)) == 1;
    }

    private final String UPDATE_DECORADOR = "UPDATE decorador SET contato = :contato WHERE cnpj = :cnpj";
    public boolean update(DecoradorEntity decoradorEntity) {
        return update(UPDATE_DECORADOR, decoradorEntity);
    }
}
