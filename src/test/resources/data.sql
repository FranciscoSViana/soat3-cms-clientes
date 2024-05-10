DROP TABLE IF EXISTS cliente_model;
CREATE TABLE cliente_model (
                               id UUID PRIMARY KEY,
                               cpf VARCHAR(255),
                               data_hora_alteracao TIMESTAMP,
                               data_hora_criacao TIMESTAMP,
                               email VARCHAR(255),
                               nome VARCHAR(255),
                               situacao BOOLEAN NOT NULL,
                               telefone VARCHAR(255)
);

INSERT INTO cliente_model (id, nome, cpf, email, telefone, data_hora_criacao, situacao)
VALUES ('5a39b3b5-4675-4c67-8dcb-3e59e38e36c1', 'João Silva', '12312312387', 'joao@example.com', '9999999999', '2024-04-15 10:00:00', true);

INSERT INTO cliente_model (id, nome, cpf, email, telefone, data_hora_criacao, situacao)
VALUES (UUID(), 'Maria Santos', '98765432100', 'maria@example.com', '(88) 8888-8888', '2024-04-15 10:00:00', true);
