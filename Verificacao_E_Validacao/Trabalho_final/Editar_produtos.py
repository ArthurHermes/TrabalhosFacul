import json

def editar_Produto(nome_produto, novo_nome=None, novo_valor=None, nova_quantidade=None):
    try:
        # Abre o arquivo JSON e carrega os produtos
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para editar.")
            return

        # Procura o produto com o nome fornecido
        produto_encontrado = None
        for produto in produtos:
            if produto['Nome_Produto'] == nome_produto:
                produto_encontrado = produto
                break

        if produto_encontrado is None:
            print(f"Produto '{nome_produto}' não encontrado.")
            return

        # Permite editar os campos caso sejam fornecidos novos valores
        if novo_nome is not None:
            produto_encontrado['Nome_Produto'] = novo_nome
        if novo_valor is not None:
            produto_encontrado['Valor_Produto'] = novo_valor
        if nova_quantidade is not None:
            produto_encontrado['Quantidade_Produto'] = nova_quantidade

        # Confirmação antes de salvar as alterações
        confirmar = input(f"Você tem certeza que deseja salvar as alterações para o produto '{produto_encontrado['Nome_Produto']}'? (s/n): ").lower()
        
        if confirmar == 's':
            # Salva as alterações no arquivo JSON
            with open("Json/produtos.json", "w") as arquivo_json:
                json.dump(produtos, arquivo_json, indent=4)
            print("Produto atualizado com sucesso.")
        else:
            print("Alterações canceladas.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
    except Exception as e:
        print(f"Ocorreu um erro inesperado: {e}")
