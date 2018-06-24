package br.usp.icmc.gustavoaguiar.equipe.limpeza;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosMapper;
import br.usp.icmc.gustavoaguiar.library.RepositoryCrud;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.Timestamp;

@Repository
public class EquipeLimpezaRepository extends AbstractRepository<EquipeLimpezaEntity> implements RepositoryCrud<EquipeLimpezaEntity, String> {
    public EquipeLimpezaRepository(NamedParameterJdbcTemplate jdbc) {
        super(new BaseTerceirizadosMapper<>(EquipeLimpezaEntity.class), jdbc);
    }

    private final String CREATE_EQUIPE_LIMPEZA = "INSERT INTO equipe_limpeza (cnpj) VALUES (:cnpj) RETURNING *";
    public EquipeLimpezaEntity create(EquipeLimpezaEntity equipeLimpezaEntity) {
        create(CREATE_EQUIPE_LIMPEZA, equipeLimpezaEntity);
        return equipeLimpezaEntity;
    }

    private final String GET_EQUIPE_LIMPEZA = "SELECT * FROM equipe_limpeza as ef, terceirizados as t WHERE ef.cnpj = :cnpj AND t.cnpj = :cnpj";
    public EquipeLimpezaEntity get(String cnpj) {
        EquipeLimpezaEntity entity = query(GET_EQUIPE_LIMPEZA, ImmutableMap.of("cnpj", cnpj));
        if (entity == null) {
            throw new ResourceNotFound("Empresa de Fantasia not found");
        }

        return entity;
    }

    private final String DELETE_EQUIPE_LIMPEZA = "DELETE FROM equipe_limpeza WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_EQUIPE_LIMPEZA, ImmutableMap.of("cnpj", cnpj)) == 1;
    }

    public boolean update(EquipeLimpezaEntity _obj) { return true; }

    private final String CREATE_LIMPA = "INSERT INTO limpa (equipe, festa) VALUES (:cnpj, :festa) RETURNING equipe";
    public boolean clean(Timestamp festa, String cnpj) {
        return query(CREATE_LIMPA, ImmutableMap.of("cnpj", cnpj, "festa", festa), (rs, rowNum) -> (true));
    }
}
