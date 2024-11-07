import json

def vender_Produto(nome_produto, quantidade_produto):
    try:
        # Abre o arquivo de produtos e carrega os dados
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para vender.")
            return

        # Encontra o produto que será vendido
        for produto in produtos:
            if produto['Nome_Produto'] == nome_produto:
                # Verifica se a chave 'Quantidade_Produto' existe, caso contrário inicializa com 0
                if "Quantidade_Produto" not in produto:
                    produto["Quantidade_Produto"] = 0  # Inicializa a quantidade, se necessário

                # Verifica se a quantidade solicitada é maior que a disponível no estoque
                if produto["Quantidade_Produto"] < quantidade_produto:
                    print("Estoque insuficiente para esta venda.")
                    return

                # Atualiza o estoque após a venda
                produto["Quantidade_Produto"] -= quantidade_produto

                # Cria o registro de venda
                venda = {
                    "Nome_Produto": produto["Nome_Produto"],
                    "Quantidade": quantidade_produto,
                    "Valor_Produto": produto["Valor_Produto"],
                    "Total": float(produto["Valor_Produto"]) * quantidade_produto
                }

                # Tenta carregar as vendas registradas
                try:
                    with open("Json/vendas.json", "r") as arquivo_vendas:
                        vendas = json.load(arquivo_vendas)
                except FileNotFoundError:
                    vendas = []  # Se o arquivo não existir, cria uma lista vazia

                # Adiciona a nova venda à lista
                vendas.append(venda)

                # Grava as vendas atualizadas no arquivo
                with open("Json/vendas.json", "w") as arquivo_vendas:
                    json.dump(vendas, arquivo_vendas, indent=4)

                # Grava os produtos atualizados (estoque)
                with open("Json/produtos.json", "w") as arquivo_json:
                    json.dump(produtos, arquivo_json, indent=4)

                print("Venda registrada com sucesso.")
                return

        # Caso o produto não seja encontrado
        print(f"Produto '{nome_produto}' não encontrado.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
    except ValueError:
        print("Entrada inválida. Verifique os valores inseridos.")
    except Exception as e:
        print(f"Ocorreu um erro inesperado: {e}")
