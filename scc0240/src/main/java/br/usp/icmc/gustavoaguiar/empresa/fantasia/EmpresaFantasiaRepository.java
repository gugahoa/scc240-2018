package br.usp.icmc.gustavoaguiar.empresa.fantasia;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosMapper;
import br.usp.icmc.gustavoaguiar.library.RepositoryCrud;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaFantasiaRepository extends AbstractRepository<EmpresaFantasiaEntity> implements RepositoryCrud<EmpresaFantasiaEntity, String> {
    public EmpresaFantasiaRepository(NamedParameterJdbcTemplate jdbc) {
        super(new BaseTerceirizadosMapper<>(EmpresaFantasiaEntity.class), jdbc);
    }

    private final String CREATE_EMPRESA_FANTASIA = "INSERT INTO empresa_fantasia (cnpj) VALUES (:cnpj) RETURNING *";
    public EmpresaFantasiaEntity create(EmpresaFantasiaEntity empresaFantasiaEntity) {
        create(CREATE_EMPRESA_FANTASIA, empresaFantasiaEntity);
        return empresaFantasiaEntity;
    }

    private final String GET_EMPRESA_FANASIA = "SELECT * FROM empresa_fantasia as ef, terceirizados as t WHERE ef.cnpj = :cnpj AND t.cnpj = :cnpj";
    public EmpresaFantasiaEntity get(String cnpj) {
        EmpresaFantasiaEntity entity = query(GET_EMPRESA_FANASIA, ImmutableMap.of("cnpj", cnpj));
        if (entity == null) {
            throw new ResourceNotFound("Empresa de Fantasia not found");
        }

        return entity;
    }

    private final String DELETE_EMPRESA_FANTASIA = "DELETE FROM empresa_fantasia WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_EMPRESA_FANTASIA, ImmutableMap.of("cnpj", cnpj)) == 1;
    }

    public boolean update(EmpresaFantasiaEntity _obj) { return true; }
}
