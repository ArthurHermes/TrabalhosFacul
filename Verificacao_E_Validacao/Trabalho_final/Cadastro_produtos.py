import json

def cadastro_Produto(nome_produto, valor_produto, peso_produto, quantidade_produto):
    try:
        # Tentando carregar o arquivo de produtos
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)
    except FileNotFoundError:
        # Caso o arquivo não exista, cria uma lista vazia
        produtos = []
    
    # Verificando se o produto já está cadastrado
    for produto in produtos:
        if produto["Nome_Produto"] == nome_produto:
            raise ValueError(f"Erro: Produto '{nome_produto}' já está cadastrado.")

    # Criando o dicionário do novo produto
    produto = {
        "Nome_Produto": nome_produto,
        "Valor_Produto": valor_produto,
        "Peso_Produto": peso_produto,
        "Quantidade_Produto": quantidade_produto
    }
    
    # Adicionando o novo produto à lista de produtos
    produtos.append(produto)
    
    # Salvando a lista de produtos de volta no arquivo JSON
    with open("Json/produtos.json", "w") as arquivo_json:
        json.dump(produtos, arquivo_json, indent=4)
    
    print(f"Produto '{nome_produto}' cadastrado com sucesso.")

