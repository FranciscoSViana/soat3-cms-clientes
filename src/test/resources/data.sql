INSERT INTO cliente_model (id, nome, cpf, email, telefone, data_hora_criacao, situacao)
VALUES (UUID_TO_BIN('5a39b3b5-4675-4c67-8dcb-3e59e38e36c1'), 'João Silva', '12312312387', 'joao@example.com', '(99) 9999-9999', '2024-04-15 10:00:00', true);

INSERT INTO cliente_model (id, nome, cpf, email, telefone, data_hora_criacao, situacao)
VALUES (UUID_TO_BIN(UUID()), 'Maria Santos', '98765432100', 'maria@example.com', '(88) 8888-8888', '2024-04-15 10:00:00', true);
