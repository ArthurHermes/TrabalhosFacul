import json

def excluir_Produto(nome_produto):
    try:
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para excluir.")
            return

        
        for produto in produtos:
            if produto['Nome_Produto'] == nome_produto:
                confirmar = input(f"Você tem certeza que deseja excluir o produto '{nome_produto}'? (s/n): ").lower()
                if confirmar == 's':
                    produtos.remove(produto)
                    with open("Json/produtos.json", "w") as arquivo_json:
                        json.dump(produtos, arquivo_json, indent=4)
                    print("Produto excluído com sucesso.")
                else:
                    print("Exclusão cancelada.")
                return

        print(f"Produto '{nome_produto}' não encontrado.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
