create table if not exists local
(
	endereco text not null
		constraint local_pkey
			primary key,
	comprovante boolean default false,
	custo integer not null,
	lotacao integer not null
)
;

create table if not exists decorador
(
	cnpj text not null
		constraint decorador_pkey
			primary key,
	contato text not null
)
;

create table if not exists festa
(
	data date not null
		constraint festa_pkey
			primary key,
	tipo varchar(1) not null,
	local text not null
		constraint festa_local_endereco_fk
			references local
				on update cascade,
	decorador text
		constraint festa_decorador_cnpj_fk
			references decorador
				on update cascade on delete set null
)
;

create table if not exists layout
(
	tipo text not null
		constraint layout_pkey
			primary key,
	image bytea
)
;

create table if not exists convite
(
	qrcode bigserial not null
		constraint convite_pkey
			primary key,
	festa date not null
		constraint convite_festa_data_fk
			references festa
				on update cascade on delete cascade,
	remetente text,
	dados text,
	tipo_layout text not null
		constraint convite_layout_tipo_fk
			references layout
				on update cascade on delete cascade
)
;

create table if not exists cardapio
(
	nome text not null
		constraint cardapio_pkey
			primary key
)
;

create table if not exists buffet
(
	festa date not null
		constraint buffet_pkey
			primary key
		constraint buffet_festa_data_fk
			references festa
				on update cascade on delete cascade,
	cardapio text not null
		constraint buffet_cardapio_nome_fk
			references cardapio
				on update cascade
)
;

create table if not exists mesa
(
	nro_patrimonio bigserial not null
		constraint mesa_pkey
			primary key
)
;

create table if not exists terceirizados
(
	cnpj text not null
		constraint terceirizados_pkey
			primary key,
	contato text,
	tipo varchar(2) not null
)
;

create table if not exists locacao_mesa
(
	cnpj text not null
		constraint locacao_mesa_pkey
			primary key
		constraint locacao_mesa_terceirizados_cnpj_fk
			references terceirizados
				on update cascade on delete cascade
)
;

create table if not exists disponibiliza
(
	locacao text not null
		constraint disponibiliza_locacao_mesa_cnpj_fk
			references locacao_mesa
				on update cascade on delete cascade,
	nro_patrimonio bigserial not null
		constraint disponibiliza_mesa_nro_patrimonio_fk
			references mesa
				on update cascade,
	constraint disponibiliza_locacao_nro_patrimonio_pk
		primary key (locacao, nro_patrimonio)
)
;

create table if not exists possui_mesa
(
	festa date not null
		constraint possui_mesa_festa_data_fk
			references festa
				on update cascade on delete cascade,
	mesa bigserial not null
		constraint possui_mesa_mesa_nro_patrimonio_fk
			references mesa
				on update cascade,
	constraint possui_mesa_festa_mesa_pk
		primary key (festa, mesa)
)
;

create table if not exists banda
(
	nome text not null
		constraint banda_pkey
			primary key,
	integrantes text[]
)
;

create table if not exists montagem_palco
(
	cnpj text not null
		constraint montagem_palco_pkey
			primary key
		constraint montagem_palco_terceirizados_cnpj_fk
			references terceirizados
				on update cascade on delete cascade
)
;

create table if not exists palco
(
	banda text not null
		constraint palco_banda_nome_fk
			references banda
				on update cascade,
	buffet date not null
		constraint palco_buffet_festa_fk
			references buffet
				on update cascade on delete cascade,
	montagem text not null
		constraint palco_montagem_palco_cnpj_fk
			references montagem_palco
				on update cascade,
	constraint palco_banda_buffet_pk
		primary key (banda, buffet)
)
;

create table if not exists equipe_limpeza
(
	cnpj text not null
		constraint equipe_limpeza_pkey
			primary key
		constraint equipe_limpeza_terceirizados_cnpj_fk
			references terceirizados
				on update cascade on delete cascade
)
;

create table if not exists limpa
(
	equipe text not null
		constraint limpa_equipe_limpeza_cnpj_fk
			references equipe_limpeza
				on update cascade,
	festa date not null
		constraint limpa_festa_data_fk
			references festa
				on update cascade on delete cascade,
	constraint limpa_equipe_festa_pk
		primary key (equipe, festa)
)
;

create table if not exists equipe_cozinha
(
	cnpj text not null
		constraint equipe_cozinha_pkey
			primary key
		constraint equipe_cozinha_terceirizados_cnpj_fk
			references terceirizados
				on update cascade on delete cascade
)
;

create table if not exists refeicao
(
	nome text not null
		constraint refeicao_pkey
			primary key,
	tipo text not null
		constraint tipo_possivel
			check (tipo = ANY (ARRAY['BEBIDA'::text, 'PRINCIPAL'::text, 'SOBREMESA'::text, 'ENTRADA'::text]))
)
;

create table if not exists pratos
(
	cardapio text not null
		constraint pratos_cardapio_nome_fk
			references cardapio
				on update cascade,
	refeicao text not null
		constraint pratos_refeicao_nome_fk
			references refeicao
				on update cascade,
	constraint pratos_cardapio_refeicao_pk
		primary key (cardapio, refeicao)
)
;

create table if not exists prepara
(
	refeicao text not null
		constraint prepara_refeicao_nome_fk
			references refeicao
				on update cascade on delete cascade,
	equipe text not null
		constraint prepara_equipe_cozinha_cnpj_fk
			references equipe_cozinha
				on update cascade on delete cascade,
	constraint prepara_refeicao_equipe_pk
		primary key (refeicao, equipe)
)
;

create table if not exists empresa_fantasia
(
	cnpj text not null
		constraint empresa_fantasia_pkey
			primary key
		constraint empresa_fantasia_terceirizados_cnpj_fk
			references terceirizados
				on update cascade on delete cascade
)
;

create table if not exists equipe_animacao
(
	cnpj text not null
		constraint equipe_animacao_pkey
			primary key
		constraint equipe_animacao_terceirizados_cnpj_fk
			references terceirizados
				on update cascade on delete cascade
)
;

create table if not exists aniversario
(
	festa date not null
		constraint aniversario_pkey
			primary key
		constraint aniversario_festa_data_fk
			references festa
				on update cascade on delete cascade,
	animacao text
		constraint aniversario_equipe_animacao_cnpj_fk
			references equipe_animacao
				on update cascade
)
;

create table if not exists aluguel
(
	aniversario date not null
		constraint aluguel_aniversario_festa_fk
			references aniversario
				on update cascade on delete cascade,
	convidado bigserial not null
		constraint aluguel_convite_qrcode_fk
			references convite,
	constraint aluguel_aniversario_convidado_pk
		primary key (aniversario, convidado)
)
;

create table if not exists fantasia
(
	personagem text not null,
	aluguel_f date not null,
	aluguel_c bigserial not null,
	tamanho varchar(3)
		constraint fantasia_tamanho_check
			check ((tamanho)::text = ANY ((ARRAY['S'::character varying, 'M'::character varying, 'L'::character varying, 'XL'::character varying, 'XXL'::character varying])::text[])),
	responsavel text not null
		constraint fantasia_empresa_fantasia_cnpj_fk
			references empresa_fantasia,
	constraint fantasia_personagem_aluguel_f_aluguel_c_pk
		primary key (personagem, aluguel_f, aluguel_c),
	constraint fantasia_aluguel_aniversario_convidado_fk
		foreign key (aluguel_f, aluguel_c) references aluguel
)
;

create table if not exists doces
(
	tipo text not null
		constraint doces_pkey
			primary key,
	equipe text not null
		constraint doces_equipe_cozinha_cnpj_fk
			references equipe_cozinha
				on update cascade on delete cascade
)
;

create table if not exists possui_doces
(
	aniversario date not null
		constraint possui_doces_aniversario_festa_fk
			references aniversario,
	doce text not null
		constraint possui_doces_doces_tipo_fk
			references doces,
	quantidade integer default 0,
	constraint possui_doces_aniversario_doce_pk
		primary key (aniversario, doce)
)
;
