package br.usp.icmc.gustavoaguiar.empresa.mesa;

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
public class EmpresaMesaRepository extends AbstractRepository<EmpresaMesaEntity> implements RepositoryCrud<EmpresaMesaEntity, String> {
    public EmpresaMesaRepository(NamedParameterJdbcTemplate jdbc) {
        super(new BaseTerceirizadosMapper<>(EmpresaMesaEntity.class), jdbc);
    }

    private final String CREATE_EMPRESA_MONTAGEM = "INSERT INTO locacao_mesa (cnpj) VALUES (:cnpj) RETURNING *";
    public EmpresaMesaEntity create(EmpresaMesaEntity empresaFantasiaEntity) {
        create(CREATE_EMPRESA_MONTAGEM, empresaFantasiaEntity);
        return empresaFantasiaEntity;
    }

    private final String GET_EMPRESA_MONTAGEM = "SELECT * FROM locacao_mesa as ef, terceirizados as t WHERE ef.cnpj = :cnpj AND t.cnpj = :cnpj";
    public EmpresaMesaEntity get(String cnpj) {
        EmpresaMesaEntity entity = query(GET_EMPRESA_MONTAGEM, ImmutableMap.of("cnpj", cnpj));
        if (entity == null) {
            throw new ResourceNotFound("Empresa de Montagem not found");
        }

        return entity;
    }

    private final String DELETE_EMPRESA_MONTAGEM = "DELETE FROM locacao_mesa WHERE cnpj = :cnpj";
    public boolean delete(String cnpj) {
        return update(DELETE_EMPRESA_MONTAGEM, ImmutableMap.of("cnpj", cnpj)) == 1;
    }

    public boolean update(EmpresaMesaEntity _obj) { return true; }

    private final String CREATE_MESA = "INSERT INTO mesa (nro_patrimonio) VALUES (nextval('mesa_nro_patrimonio_seq'::regclass)) RETURNING nro_patrimonio";
    public Long create_mesa() {
        return query(CREATE_MESA, ImmutableMap.of(), ((rs, rowNum) -> rs.getLong("nro_patrimonio")));
    }

    private final String CREATE_DISPONIBILIZA = "INSERT INTO disponibiliza (locacao, nro_patrimonio) VALUES (:cnpj, :mesa_id) RETURNING *";
    public boolean create_disponibiliza(String cnpj, Long mesa_id) {
        return query(CREATE_DISPONIBILIZA, ImmutableMap.of("mesa_id", mesa_id, "cnpj", cnpj), (rs, rowNum) -> true);
    }

    private final String ALLOCATE_MESA = "INSERT INTO possui_mesa (mesa, festa) SELECT nro_patrimonio AS mesa, :festa FROM mesa LIMIT :nro_mesas;";
    public int allocate_mesas(Timestamp festa, Long nro_mesas) {
        return update(ALLOCATE_MESA, ImmutableMap.of("festa", festa, "nro_mesas", nro_mesas));
    }

    private final String DELETE_POSSUI_MESA = "DELETE FROM possui_mesa WHERE festa = :festa";
    public boolean delete_possui_mesa(Timestamp festa) {
        return update(DELETE_POSSUI_MESA, ImmutableMap.of("festa", festa)) > 0;
    }
}
