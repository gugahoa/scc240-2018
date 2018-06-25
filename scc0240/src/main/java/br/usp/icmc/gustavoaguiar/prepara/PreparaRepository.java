package br.usp.icmc.gustavoaguiar.prepara;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PreparaRepository extends AbstractRepository<PreparaEntity> {
    public PreparaRepository(NamedParameterJdbcTemplate jdbc) {
        super(new PreparaMapper(), jdbc);
    }

    private final String CREATE_PREPARA = "INSERT INTO prepara (refeicao, equipe) VALUES (:refeicao, :equipe) RETURNING *";
    public PreparaEntity create(PreparaEntity preparaEntity) {
        return create(CREATE_PREPARA, preparaEntity);
    }

    private final String GET_PREPARA = "SELECT * FROM prepara WHERE refeicao = :refeicao AND equipe = :equipe";
    public PreparaEntity get(String refeicao, String equipe) {
        return query(GET_PREPARA, ImmutableMap.of("refeicao", refeicao, "equipe", equipe));
    }

    private final String DELETE_PREPARA = "DELETE FROM prepara WHERE refeicao = :refeicao AND equipe = :equipe";
    public boolean delete(String equipe, String refeicao) {
        return update(DELETE_PREPARA, ImmutableMap.of("equipe", equipe, "refeicao", refeicao)) == 1;
    }
}
