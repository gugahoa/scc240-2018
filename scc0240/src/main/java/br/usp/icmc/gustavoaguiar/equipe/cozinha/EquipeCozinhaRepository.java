package br.usp.icmc.gustavoaguiar.equipe.cozinha;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosMapper;
import br.usp.icmc.gustavoaguiar.library.RepositoryCrud;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EquipeCozinhaRepository extends AbstractRepository<EquipeCozinhaEntity> implements RepositoryCrud<EquipeCozinhaEntity, String> {
    public EquipeCozinhaRepository(NamedParameterJdbcTemplate jdbc) {
        super(new BaseTerceirizadosMapper<>(EquipeCozinhaEntity.class), jdbc);
    }

    private final String CREATE_EQUIPE_COZINHA = "INSERT INTO equipe_cozinha (cnpj) VALUES (:cnpj) RETURNING *";
    public EquipeCozinhaEntity create(EquipeCozinhaEntity equipeCozinhaEntity) {
        create(CREATE_EQUIPE_COZINHA, equipeCozinhaEntity);
        return equipeCozinhaEntity;
    }

    private final String GET_EQUIPE_COZINHA = "SELECT * FROM equipe_cozinha as ef, terceirizados as t WHERE ef.cnpj = :cnpj AND t.cnpj = :cnpj";
    public EquipeCozinhaEntity get(String cnpj) {
        EquipeCozinhaEntity entity = query(GET_EQUIPE_COZINHA, ImmutableMap.of("cnpj", cnpj));
        if (entity == null) {
            throw new ResourceNotFound("Empresa de Fantasia not found");
        }

        return entity;
    }

    private final String DELETE_EQUIPE_COZINHA = "DELETE FROM equipe_cozinha WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_EQUIPE_COZINHA, ImmutableMap.of("cnpj", cnpj)) == 1;
    }

    public boolean update(EquipeCozinhaEntity _obj) { return true; }
}
