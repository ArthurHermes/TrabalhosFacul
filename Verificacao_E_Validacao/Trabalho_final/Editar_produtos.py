import json

def editar_Produto(nome_produto, novo_nome=None, novo_valor=None, nova_quantidade=None):
    try:
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para editar.")
            return

        
        print("Produtos cadastrados:")
        for index, produto in enumerate(produtos):
            print(f"{index + 1}. Nome: {produto['Nome_Produto']}, Valor: {produto['Valor_Produto']}, Quantidade: {produto['Quantidade_Produto']}")

        escolha = int(input("Escolha o número do produto que deseja editar: ")) - 1
        
        if escolha < 0 or escolha >= len(produtos):
            print("Escolha inválida!")
            return

        if produtos[escolha]['Nome_Produto'] != nome_produto:
            print("O produto escolhido não corresponde ao nome fornecido.")
            return

        
        if novo_nome is not None:
            produtos[escolha]['Nome_Produto'] = novo_nome
        if novo_valor is not None:
            produtos[escolha]['Valor_Produto'] = novo_valor
        if nova_quantidade is not None:
            produtos[escolha]['Quantidade_Produto'] = nova_quantidade

        
        with open("Json/produtos.json", "w") as arquivo_json:
            json.dump(produtos, arquivo_json, indent=4)

        print("Produto atualizado com sucesso.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
