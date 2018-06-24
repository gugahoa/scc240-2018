package br.usp.icmc.gustavoaguiar.terceirizados;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TerceirizadosRepository extends AbstractRepository<TerceirizadosEntity> {
    public TerceirizadosRepository(NamedParameterJdbcTemplate jdbc) {
        super(new TerceirizadosMapper(), jdbc);
    }

    private final String CREATE_TERCEIRZIADO = "INSERT INTO terceirizados (cnpj, contato, tipo) VALUES (:cnpj, :contato, :tipo) RETURNING *";
    public TerceirizadosEntity create(TerceirizadosEntity terceirizadosEntity) {
        return create(CREATE_TERCEIRZIADO, terceirizadosEntity);
    }

    private final String GET_TERCEIRIZADO = "SELECT * FROM terceirizados WHERE cnpj = :cnpj";
    public TerceirizadosEntity get(String cnpj) {
        return query(GET_TERCEIRIZADO, ImmutableMap.of("cnpj", cnpj));
    }

    private final String UPDATE_TERCEIRZADO = "UPDATE terceirizados SET contato = :contato, tipo = :tipo WHERE cnpj = :cnpj";
    public boolean update(TerceirizadosEntity terceirizadosEntity) {
        return update(UPDATE_TERCEIRZADO, terceirizadosEntity);
    }

    private final String DELETE_TERCEIRZADO ="DELETE FROM terceirizados WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_TERCEIRZADO, ImmutableMap.of("cnpj", cnpj)) == 1;
    }
}
