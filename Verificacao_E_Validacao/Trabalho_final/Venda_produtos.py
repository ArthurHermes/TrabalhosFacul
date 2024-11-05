import json

def vender_Produto(nome_produto, quantidade_produto):
    try:
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para vender.")
            return

        for produto in produtos:
            if produto['Nome_Produto'] == nome_produto:
                if "Quantidade_Produto" not in produto:
                    produto["Quantidade"] = 0  # Initialize if not specified

                if produto["Quantidade_Produto"] < quantidade_produto:
                    print("Estoque insuficiente para esta venda.")
                    return

                
                produto["Quantidade_Produto"] -= quantidade_produto

                
                venda = {
                    "Nome_Produto": produto["Nome_Produto"],
                    "Quantidade": quantidade_produto,
                    "Valor_Produto": produto["Valor_Produto"],
                    "Total": float(produto["Valor_Produto"]) * quantidade_produto
                }

                try:
                    with open("Json/vendas.json", "r") as arquivo_vendas:
                        vendas = json.load(arquivo_vendas)
                except FileNotFoundError:
                    vendas = []

                vendas.append(venda)

                with open("Json/vendas.json", "w") as arquivo_vendas:
                    json.dump(vendas, arquivo_vendas, indent=4)

                
                with open("Json/produtos.json", "w") as arquivo_json:
                    json.dump(produtos, arquivo_json, indent=4)

                print("Venda registrada com sucesso.")
                return

        print(f"Produto '{nome_produto}' não encontrado.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
    except ValueError:
        print("Entrada inválida. Verifique os valores inseridos.")
