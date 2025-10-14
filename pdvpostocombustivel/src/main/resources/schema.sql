-- Criação da tabela pessoas
CREATE TABLE IF NOT EXISTS pessoas (
                                       id BIGSERIAL PRIMARY KEY,
                                       nome_completo VARCHAR(200) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL UNIQUE,
    numero_ctps BIGINT,
    data_nascimento DATE
    );

CREATE TABLE IF NOT EXISTS Acessos (
                                       id BIGSERIAL PRIMARY KEY,
                                       senha VARCHAR(15) NOT NULL,
    usuario VARCHAR(30) NOT NULL UNIQUE
    );