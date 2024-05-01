# language: pt
Funcionalidade: API - Clientes


  Cenário: Buscar cliente pelo CPF
    Dado que um cliente esteja cadastrado com o CPF "123.456.789-00"
    Quando requisitar a busca do cliente pelo CPF "123.456.789-00"
    Então o cliente é encontrado com sucesso



