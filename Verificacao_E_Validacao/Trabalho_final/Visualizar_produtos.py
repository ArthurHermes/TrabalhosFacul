import json

def visualizar_Produto():
    try:
        # Tenta abrir o arquivo JSON contendo os produtos
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)
            
            # Verifica se existem produtos cadastrados
            if produtos:
                print("Produtos cadastrados:")
                for index, produto in enumerate(produtos):
                    # Exibe os produtos com índice, nome, valor e quantidade
                    print(f"{index + 1}. Nome: {produto['Nome_Produto']}, Valor: R$ {produto['Valor_Produto']:.2f}, Quantidade: {produto['Quantidade_Produto']}")
            else:
                print("Nenhum produto cadastrado.")
                
    except FileNotFoundError:
        # Caso o arquivo de produtos não seja encontrado
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        # Caso haja um erro ao tentar carregar o arquivo JSON (arquivo corrompido)
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
    except Exception as e:
        # Captura qualquer outro erro não esperado
        print(f"Erro inesperado: {e}")
