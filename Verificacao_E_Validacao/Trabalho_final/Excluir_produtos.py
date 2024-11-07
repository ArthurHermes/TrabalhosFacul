import json

def excluir_Produto(nome_produto):
    try:
        # Tentativa de abrir o arquivo JSON contendo os produtos
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        # Verifica se a lista de produtos não está vazia
        if not produtos:
            print("Nenhum produto cadastrado para excluir.")
            return

        # Tenta localizar o produto com o nome fornecido
        for produto in produtos:
            if produto['Nome_Produto'] == nome_produto:
                # Confirmação de exclusão
                while True:
                    confirmar = input(f"Você tem certeza que deseja excluir o produto '{nome_produto}'? (s/n): ").lower()
                    if confirmar == 's':
                        produtos.remove(produto)
                        with open("Json/produtos.json", "w") as arquivo_json:
                            json.dump(produtos, arquivo_json, indent=4)
                        print(f"Produto '{nome_produto}' excluído com sucesso.")
                        return
                    elif confirmar == 'n':
                        print("Exclusão cancelada.")
                        return
                    else:
                        print("Opção inválida. Por favor, digite 's' para sim ou 'n' para não.")

        # Caso o produto não seja encontrado
        print(f"Produto '{nome_produto}' não encontrado.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
    except Exception as e:
        print(f"Erro inesperado: {e}")
