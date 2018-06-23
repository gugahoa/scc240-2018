package br.usp.icmc.gustavoaguiar.convite;

import br.usp.icmc.gustavoaguiar.library.AbstractRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConviteRepository extends AbstractRepository<ConviteEntity> {
    public ConviteRepository(NamedParameterJdbcTemplate jdbc) {
        super(new ConviteMapper(), jdbc);
    }

    private final String CREATE_CONVITE = "INSERT INTO convite (festa, remetente, dados, tipo_layout) VALUES (:festa, :remetente, :dados, :tipo_layout) RETURNING *";
    public ConviteEntity create(ConviteEntity convite) {
        return create(CREATE_CONVITE, convite);
    }

    private final String GET_CONVITE = "SELECT * FROM convite WHERE qrcode = :qrcode";
    public ConviteEntity get(Long qrcode) {
        return query(GET_CONVITE, ImmutableMap.of("qrcode", qrcode));
    }

    private final String DELETE_CONVITE = "DELETE FROM convite WHERE qrcode = :qrcode";
    public boolean delete(Long qrcode) {
        return update(DELETE_CONVITE, ImmutableMap.of("qrcode", qrcode)) == 1;
    }

    private final String UPDATE_CONVITE = "UPDATE convite SET festa = :festa, remetente = :remetente, dados = :dados, tipo_layout = :tipo_layout WHERE qrcode = :qrcode";
    public boolean update(ConviteEntity conviteEntity) {
        return update(UPDATE_CONVITE, conviteEntity);
    }
}
