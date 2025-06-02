CREATE TABLE area
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    tipo               VARCHAR(255) NULL,
    descricao          VARCHAR(255) NULL,
    imovel_id          BIGINT NULL,
    horario_disponivel VARCHAR(255) NULL,
    regras_de_uso      VARCHAR(255) NULL,
    CONSTRAINT pk_area PRIMARY KEY (id)
);

CREATE TABLE avaliacao_cliente
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    nota            INT NOT NULL,
    comentario      VARCHAR(255) NULL,
    data_avaliacao DOUBLE NULL,
    hospede_id      BIGINT NULL,
    proprietario_id BIGINT NULL,
    CONSTRAINT pk_avaliacao_cliente PRIMARY KEY (id)
);

CREATE TABLE avaliacao_imovel
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    nota       INT NOT NULL,
    comentario VARCHAR(255) NULL,
    data_avaliacao DOUBLE NULL,
    hospede_id BIGINT NULL,
    imovel_id  BIGINT NULL,
    CONSTRAINT pk_avaliacao_imovel PRIMARY KEY (id)
);

CREATE TABLE cadastra_evento
(
    evento_id     BIGINT NOT NULL,
    hospede_id    BIGINT NOT NULL,
    data_cadastro datetime NULL,
    CONSTRAINT pk_cadastraevento PRIMARY KEY (evento_id, hospede_id)
);

CREATE TABLE denuncia
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    descricao        VARCHAR(255) NULL,
    motivo           VARCHAR(255) NULL,
    data_envio       datetime NULL,
    status           SMALLINT NULL,
    data_validacao   datetime NULL,
    administrador_id BIGINT NULL,
    denunciante_id   BIGINT NULL,
    denunciado_id    BIGINT NULL,
    CONSTRAINT pk_denuncia PRIMARY KEY (id)
);

CREATE TABLE evento
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    nome        VARCHAR(255) NULL,
    local       VARCHAR(255) NULL,
    descricao   VARCHAR(255) NULL,
    data_inicio datetime NULL,
    data_fim    datetime NULL,
    capacidade  INT NOT NULL,
    imovel_id   BIGINT NULL,
    CONSTRAINT pk_evento PRIMARY KEY (id)
);

CREATE TABLE imovel
(
    id                       BIGINT AUTO_INCREMENT NOT NULL,
    titulo                   VARCHAR(255) NULL,
    descricao                VARCHAR(255) NULL,
    endereco                 VARCHAR(255) NULL,
    cidade                   VARCHAR(255) NULL,
    estado                   VARCHAR(255) NULL,
    cep                      VARCHAR(255) NULL,
    preco_diaria             FLOAT NOT NULL,
    politica_de_cancelamento VARCHAR(255) NULL,
    status                   VARCHAR(255) NULL,
    proprietario_id          BIGINT NULL,
    CONSTRAINT pk_imovel PRIMARY KEY (id)
);

CREATE TABLE quarto
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    tipo               VARCHAR(255) NULL,
    quantidade_camas   INT    NOT NULL,
    banheiro_privativo BIT(1) NOT NULL,
    aream2 DOUBLE NOT NULL,
    descricao          VARCHAR(255) NULL,
    imovel_id          BIGINT NULL,
    CONSTRAINT pk_quarto PRIMARY KEY (id)
);

CREATE TABLE reserva
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    data_inicio datetime NULL,
    data_fim    datetime NULL,
    reserva     datetime NULL,
    valor_total DOUBLE NOT NULL,
    status      VARCHAR(255) NULL,
    hospede_id  BIGINT NULL,
    quarto_id   BIGINT NULL,
    CONSTRAINT pk_reserva PRIMARY KEY (id)
);

CREATE TABLE servico
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    nome            VARCHAR(255) NULL,
    descricao       VARCHAR(255) NULL,
    preco DOUBLE NOT NULL,
    disponibilidade BIT(1) NOT NULL,
    imovel_id       BIGINT NULL,
    CONSTRAINT pk_servico PRIMARY KEY (id)
);

CREATE TABLE solicita_servico
(
    data_solicitacao datetime NULL,
    reserva_id       BIGINT NOT NULL,
    servico_id       BIGINT NOT NULL,
    CONSTRAINT pk_solicitaservico PRIMARY KEY (reserva_id, servico_id)
);

CREATE TABLE usuario
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    dtype           VARCHAR(31) NULL,
    nome            VARCHAR(255) NULL,
    email           VARCHAR(255) NULL,
    senha           VARCHAR(255) NULL,
    telefone        VARCHAR(255) NULL,
    tipo            SMALLINT NULL,
    rg              VARCHAR(255) NULL,
    data_nascimento datetime NULL,
    matricula       VARCHAR(255) NULL,
    cnpj            VARCHAR(255) NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);

ALTER TABLE area
    ADD CONSTRAINT FK_AREA_ON_IMOVEL FOREIGN KEY (imovel_id) REFERENCES imovel (id);

ALTER TABLE avaliacao_cliente
    ADD CONSTRAINT FK_AVALIACAO_CLIENTE_ON_HOSPEDE FOREIGN KEY (hospede_id) REFERENCES usuario (id);

ALTER TABLE avaliacao_cliente
    ADD CONSTRAINT FK_AVALIACAO_CLIENTE_ON_PROPRIETARIO FOREIGN KEY (proprietario_id) REFERENCES usuario (id);

ALTER TABLE avaliacao_imovel
    ADD CONSTRAINT FK_AVALIACAO_IMOVEL_ON_HOSPEDE FOREIGN KEY (hospede_id) REFERENCES usuario (id);

ALTER TABLE avaliacao_imovel
    ADD CONSTRAINT FK_AVALIACAO_IMOVEL_ON_IMOVEL FOREIGN KEY (imovel_id) REFERENCES imovel (id);

ALTER TABLE cadastra_evento
    ADD CONSTRAINT FK_CADASTRAEVENTO_ON_EVENTO FOREIGN KEY (evento_id) REFERENCES evento (id);

ALTER TABLE cadastra_evento
    ADD CONSTRAINT FK_CADASTRAEVENTO_ON_HOSPEDE FOREIGN KEY (hospede_id) REFERENCES usuario (id);

ALTER TABLE denuncia
    ADD CONSTRAINT FK_DENUNCIA_ON_ADMINISTRADOR FOREIGN KEY (administrador_id) REFERENCES usuario (id);

ALTER TABLE denuncia
    ADD CONSTRAINT FK_DENUNCIA_ON_DENUNCIADO FOREIGN KEY (denunciado_id) REFERENCES usuario (id);

ALTER TABLE denuncia
    ADD CONSTRAINT FK_DENUNCIA_ON_DENUNCIANTE FOREIGN KEY (denunciante_id) REFERENCES usuario (id);

ALTER TABLE evento
    ADD CONSTRAINT FK_EVENTO_ON_IMOVEL FOREIGN KEY (imovel_id) REFERENCES imovel (id);

ALTER TABLE imovel
    ADD CONSTRAINT FK_IMOVEL_ON_PROPRIETARIO FOREIGN KEY (proprietario_id) REFERENCES usuario (id);

ALTER TABLE quarto
    ADD CONSTRAINT FK_QUARTO_ON_IMOVEL FOREIGN KEY (imovel_id) REFERENCES imovel (id);

ALTER TABLE reserva
    ADD CONSTRAINT FK_RESERVA_ON_HOSPEDE FOREIGN KEY (hospede_id) REFERENCES usuario (id);

ALTER TABLE reserva
    ADD CONSTRAINT FK_RESERVA_ON_QUARTO FOREIGN KEY (quarto_id) REFERENCES quarto (id);

ALTER TABLE servico
    ADD CONSTRAINT FK_SERVICO_ON_IMOVEL FOREIGN KEY (imovel_id) REFERENCES imovel (id);

ALTER TABLE solicita_servico
    ADD CONSTRAINT FK_SOLICITASERVICO_ON_RESERVA FOREIGN KEY (reserva_id) REFERENCES reserva (id);

ALTER TABLE solicita_servico
    ADD CONSTRAINT FK_SOLICITASERVICO_ON_SERVICO FOREIGN KEY (servico_id) REFERENCES servico (id);