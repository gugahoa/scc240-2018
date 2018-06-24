package br.usp.icmc.gustavoaguiar.equipe.montagem;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosMapper;
import br.usp.icmc.gustavoaguiar.library.RepositoryCrud;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EquipeMontagemRepository extends AbstractRepository<EquipeMontagemEntity> implements RepositoryCrud<EquipeMontagemEntity, String> {
    public EquipeMontagemRepository(NamedParameterJdbcTemplate jdbc) {
        super(new BaseTerceirizadosMapper<>(EquipeMontagemEntity.class), jdbc);
    }

    private final String CREATE_EQUIPE_MONTAGEM = "INSERT INTO equipe_montagem (cnpj) VALUES (:cnpj) RETURNING *";
    public EquipeMontagemEntity create(EquipeMontagemEntity equipeMontagemEntity) {
        create(CREATE_EQUIPE_MONTAGEM, equipeMontagemEntity);
        return equipeMontagemEntity;
    }

    private final String GET_EMPRESA_FANASIA = "SELECT * FROM equipe_montagem as ef, terceirizados as t WHERE ef.cnpj = :cnpj AND t.cnpj = :cnpj";
    public EquipeMontagemEntity get(String cnpj) {
        EquipeMontagemEntity entity = query(GET_EMPRESA_FANASIA, ImmutableMap.of("cnpj", cnpj));
        if (entity == null) {
            throw new ResourceNotFound("Empresa de Fantasia not found");
        }

        return entity;
    }

    private final String DELETE_EQUIPE_MONTAGEM = "DELETE FROM equipe_montagem WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_EQUIPE_MONTAGEM, ImmutableMap.of("cnpj", cnpj)) == 1;
    }

    public boolean update(EquipeMontagemEntity _obj) {
        return true;
    }
}

