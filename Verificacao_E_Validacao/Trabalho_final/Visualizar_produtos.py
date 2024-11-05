import json

def visualizar_Produto():
    try:
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)
            
            print("Produtos cadastrados:")
            for index, produto in enumerate(produtos):
                print(f"{index + 1}. Nome: {produto['Nome_Produto']}, Valor: {produto['Valor_Produto']}, Quantidade: {produto['Quantidade_Produto']}")
                
    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")