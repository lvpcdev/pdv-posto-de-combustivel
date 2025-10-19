

-- Tabela de Pessoas
CREATE TABLE IF NOT EXISTS pessoas (
    id BIGSERIAL PRIMARY KEY,
    nome_completo VARCHAR(200) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL UNIQUE,
    numero_ctps BIGINT,
    data_nascimento DATE NOT NULL,
    tipo_pessoa VARCHAR(15) NOT NULL
);

-- Tabela de Acesso
CREATE TABLE IF NOT EXISTS acesso (
    id BIGSERIAL PRIMARY KEY,
    usuario VARCHAR(30) NOT NULL UNIQUE,
    senha VARCHAR(15) NOT NULL,
    tipo_acesso VARCHAR(30) NOT NULL
);

-- Tabela de Contato
CREATE TABLE IF NOT EXISTS contato (
    id BIGSERIAL PRIMARY KEY,
    telefone VARCHAR(14) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    endereco VARCHAR(100) NOT NULL,
    tipo_contato VARCHAR(30) NOT NULL
);

-- Tabela de Custo
CREATE TABLE IF NOT EXISTS custo (
    id BIGSERIAL PRIMARY KEY,
    imposto DOUBLE PRECISION NOT NULL,
    custo_variavel DOUBLE PRECISION NOT NULL,
    custo_fixo DOUBLE PRECISION NOT NULL,
    margem_lucro DOUBLE PRECISION NOT NULL,
    data_processamento DATE NOT NULL UNIQUE,
    tipo_custo VARCHAR(30) NOT NULL
);

-- Tabela de Estoque
CREATE TABLE IF NOT EXISTS estoque (
    id BIGSERIAL PRIMARY KEY,
    quantidade NUMERIC(10, 2) NOT NULL,
    local_tanque VARCHAR(50) NOT NULL,
    local_endereco VARCHAR(100) NOT NULL,
    lote_fabricacao VARCHAR(10) NOT NULL UNIQUE,
    data_validade DATE NOT NULL,
    tipo_estoque VARCHAR(15) NOT NULL
);

-- Tabela de Preço
CREATE TABLE IF NOT EXISTS preco (
    id BIGSERIAL PRIMARY KEY,
    valor NUMERIC(10, 2) NOT NULL,
    data_alteracao DATE NOT NULL,
    hora_alteracao DATE NOT NULL -- O tipo na entidade é LocalDate, mapeado para DATE.
);

-- Tabela de Produto
CREATE TABLE IF NOT EXISTS produto (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    referencia VARCHAR(500) NOT NULL UNIQUE,
    fornecedor VARCHAR(100) NOT NULL,
    marca VARCHAR(30) NOT NULL,
    categoria VARCHAR(30) NOT NULL
);
