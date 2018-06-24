package br.usp.icmc.gustavoaguiar.terceirizados;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaFantasiaRepository extends AbstractRepository<EmpresaFantasiaEntity> {
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
        return query(GET_EMPRESA_FANASIA, ImmutableMap.of("cnpj", cnpj));
    }

    private final String DELETE_EMPRESA_FANTASIA = "DELETE FROM empresa_fantasia WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_EMPRESA_FANTASIA, ImmutableMap.of("cnpj", cnpj)) == 1;
    }
}
