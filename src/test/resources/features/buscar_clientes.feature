# language: pt
Funcionalidade: API - Clientes


  Cenário: Busca de cliente por CPF válido
    Dado que existem clientes cadastrados no sistema
    Quando eu busco um cliente pelo CPF "12345678901"
    Então o cliente com o CPF "12345678901" deve ser retornado com sucesso



