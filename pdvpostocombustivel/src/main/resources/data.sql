
-- Pessoas
INSERT INTO pessoas (nome_completo, cpf_cnpj, numero_ctps, data_nascimento, tipo_pessoa)
VALUES
    ('Maria da Silva', '12345678901', 12345, '1990-05-10', 'FISICA'),
    ('João Pereira', '98765432100', 54321, '1985-11-20', 'FISICA'),
    ('Empresa XYZ Ltda', '12345678000199', NULL, '2010-01-15', 'JURIDICA')
ON CONFLICT (cpf_cnpj) DO NOTHING;

-- Acesso
INSERT INTO acesso (usuario, senha, tipo_acesso)
VALUES
    ('admin', 'admin123', 'ADMIN'),
    ('user', 'user123', 'USUARIO')
ON CONFLICT (usuario) DO NOTHING;

-- Contato
INSERT INTO contato (telefone, email, endereco, tipo_contato)
VALUES
    ('11987654321', 'maria.silva@example.com', 'Rua das Flores, 123, São Paulo', 'EMAIL_PRINCIPAL'),
    ('21912345678', 'joao.pereira@example.com', 'Avenida Principal, 456, Rio de Janeiro', 'TELEFONE_CELULAR')
ON CONFLICT (email) DO NOTHING;

-- Custo
INSERT INTO custo (imposto, custo_variavel, custo_fixo, margem_lucro, data_processamento, tipo_custo)
VALUES
    (15.5, 2.50, 50000.00, 25.0, '2023-10-01', 'CUSTO_PRODUTO_VENDIDO')
ON CONFLICT (data_processamento) DO NOTHING;

-- Estoque
INSERT INTO estoque (quantidade, local_tanque, local_endereco, lote_fabricacao, data_validade, tipo_estoque)
VALUES
    (10000.00, 'TANQUE-01', 'Pátio Principal', 'LT-2023-001', '2024-10-01', 'COMBUSTIVEL_GASOLINA'),
    (500.00, 'PRATELEIRA-A', 'Depósito 2', 'LB-2023-005', '2025-08-20', 'LUBRIFICANTE_MOTOR')
ON CONFLICT (lote_fabricacao) DO NOTHING;

-- Preço
INSERT INTO preco (valor, data_alteracao, hora_alteracao)
VALUES
    (5.59, '2023-10-26', '2023-10-26'),
    (4.89, '2023-10-26', '2023-10-26');

-- Produto
INSERT INTO produto (nome, referencia, fornecedor, marca, categoria)
VALUES
    ('Gasolina Aditivada', 'GAS-ADT-001', 'Petrobras Distribuidora', 'Grid', 'Combustível'),
    ('Óleo Motor 15W40', 'OLEO-15W40-001', 'Ipiranga', 'F1 Master', 'Lubrificante')
ON CONFLICT (referencia) DO NOTHING;
