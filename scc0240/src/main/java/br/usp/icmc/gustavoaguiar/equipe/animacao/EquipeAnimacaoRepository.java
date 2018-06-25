package br.usp.icmc.gustavoaguiar.equipe.animacao;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosMapper;
import br.usp.icmc.gustavoaguiar.library.RepositoryCrud;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EquipeAnimacaoRepository extends AbstractRepository<EquipeAnimacaoEntity> implements RepositoryCrud<EquipeAnimacaoEntity, String> {
    public EquipeAnimacaoRepository(NamedParameterJdbcTemplate jdbc) {
        super(new BaseTerceirizadosMapper<>(EquipeAnimacaoEntity.class), jdbc);
    }

    private final String CREATE_EQUIPE_ANIMACAO = "INSERT INTO equipe_animacao (cnpj) VALUES (:cnpj) RETURNING *";
    public EquipeAnimacaoEntity create(EquipeAnimacaoEntity equipeAnimacaoEntity) {
        create(CREATE_EQUIPE_ANIMACAO, equipeAnimacaoEntity);
        return equipeAnimacaoEntity;
    }

    private final String GET_EMPRESA_FANASIA = "SELECT * FROM equipe_animacao as ef, terceirizados as t WHERE ef.cnpj = :cnpj AND t.cnpj = :cnpj";
    public EquipeAnimacaoEntity get(String cnpj) {
        EquipeAnimacaoEntity entity = query(GET_EMPRESA_FANASIA, ImmutableMap.of("cnpj", cnpj));
        if (entity == null) {
            throw new ResourceNotFound("Equipe de Animacao not found");
        }

        return entity;
    }

    private final String DELETE_EQUIPE_ANIMACAO = "DELETE FROM equipe_animacao WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_EQUIPE_ANIMACAO, ImmutableMap.of("cnpj", cnpj)) == 1;
    }

    public boolean update(EquipeAnimacaoEntity _obj) { return true; }
}
