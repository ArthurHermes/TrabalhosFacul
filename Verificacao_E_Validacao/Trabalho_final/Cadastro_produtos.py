import json

def cadastro_Produto(nome_produto, valor_produto, peso_produto, quantidade_produto):
    try:
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)
    except FileNotFoundError:
        produtos = []
        
        
    nome_produto = nome_produto
    valor_produto = valor_produto
    peso_produto = peso_produto
    quantidade_produto = quantidade_produto

    produto = {
        "Nome_Produto": nome_produto,
        "Valor_Produto": valor_produto,
        "Peso_Produto": peso_produto,
        "Quantidade_Produto": quantidade_produto
    }
    
    produtos.append(produto)
    
    with open("Json/produtos.json", "w") as arquivo_json:
        json.dump(produtos, arquivo_json, indent=4)
        
    print("Produto cadastrado com sucesso.")