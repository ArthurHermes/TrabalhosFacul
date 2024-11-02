import json

def menu_principal():
    print("-*" * 17 + "-")
    print("Bem vindo ao sistema do mercadinho")
    print("-*" * 17 + "-")
    print("1. Cadastrar produto")
    print("2. Visualizar produtos")
    print("3. Editar produtos")
    print("4. Calcular frete")
    print("5. Vender produto")
    print("6. Excluir produtos")
    print("7. Sair")
    print("-*" * 17 + "-")
    
    
    

def cadastro_Produto():
    try:
        with open("produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)
    except FileNotFoundError:
        produtos = []


    nome_produto = input("Nome do produto: ")
    valor_produto = input("Valor produto: ")
    peso_produto = float(input("Peso do produto (em kg): "))
    quantidade_produto = int(input("Quantiade do produto"))

    produto = {
        "Nome_Produto": nome_produto,
        "Valor_Produto": valor_produto,
        "Peso_Produto": peso_produto,
        "Quantidade_Produto": quantidade_produto
    }
    
    produtos.append(produto)
    
    with open("produtos.json", "w") as arquivo_json:
        json.dump(produtos, arquivo_json, indent=4)
        
    print("Produto cadastrado com sucesso.")
        
        
        
def visualizar_Produtos():
    try:
        with open("produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)
            
            for produto in produtos:
                print(f"Nome do Produto: {produto['Nome_Produto']}, Valor: {produto['Valor_Produto']}")
                
    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")





def editar_Produtos():
    try:
        with open("produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para editar.")
            return

        print("Produtos cadastrados:")
        for index, produto in enumerate(produtos):
            print(f"{index + 1}. Nome: {produto['Nome_Produto']}, Valor: {produto['Valor_Produto']}")

        escolha = int(input("Escolha o número do produto que deseja editar: ")) - 1
        
        if escolha < 0 or escolha >= len(produtos):
            print("Escolha inválida!")
            return

        novo_nome = input("Novo Nome do produto (pressione Enter para manter o atual): ")
        novo_valor = input("Novo Valor do produto (pressione Enter para manter o atual): ")

        if novo_nome:
            produtos[escolha]['Nome_Produto'] = novo_nome
        if novo_valor:
            produtos[escolha]['Valor_Produto'] = novo_valor

        with open("Trabalho_final\\produtos.json", "w") as arquivo_json:
            json.dump(produtos, arquivo_json, indent=4)

        print("Produto atualizado com sucesso.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
        
        
        
        
        
def excluir_Produtos():
    try:
        with open("produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para excluir.")
            return

        print("Produtos cadastrados:")
        for index, produto in enumerate(produtos):
            print(f"{index + 1}. Nome: {produto['Nome_Produto']}, Valor: {produto['Valor_Produto']}")

        escolha = int(input("Escolha o número do produto que deseja excluir: ")) - 1
        
        if escolha < 0 or escolha >= len(produtos):
            print("Escolha inválida!")
            return

        confirmar = input(f"Você tem certeza que deseja excluir o produto '{produtos[escolha]['Nome_Produto']}'? (s/n): ").lower()
        
        if confirmar == 's':
            produtos.pop(escolha)
            with open("produtos.json", "w") as arquivo_json:
                json.dump(produtos, arquivo_json, indent=4)
            print("Produto excluído com sucesso.")
        else:
            print("Exclusão cancelada.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")




def calcular_frete(peso, distancia):
    taxa_base = 5.0  # Taxa base fixa em reais
    taxa_por_kg = 1.5  # Taxa por kg
    taxa_por_km = 0.2  # Taxa por km

    frete = taxa_base + (taxa_por_kg * peso) + (taxa_por_km * distancia)
    return frete

def calcular_frete_produto():
    try:
        with open("produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para calcular frete.")
            return

        print("Produtos cadastrados:")
        for index, produto in enumerate(produtos):
            print(f"{index + 1}. Nome: {produto['Nome_Produto']}, Peso: {produto['Peso_Produto']} kg")

        escolha = int(input("Escolha o número do produto para calcular o frete: ")) - 1

        if escolha < 0 or escolha >= len(produtos):
            print("Escolha inválida!")
            return

        distancia = float(input("Informe a distância em km: "))

        peso = produtos[escolha]['Peso_Produto']
        frete = calcular_frete(peso, distancia)
        
        print(f"O custo do frete para o produto '{produtos[escolha]['Nome_Produto']}' é R$ {frete:.2f}")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")

def vender_Produto():
    try:
        with open("produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para vender.")
            return

        print("Produtos cadastrados:")
        for index, produto in enumerate(produtos):
            print(f"{index + 1}. Nome: {produto['Nome_Produto']}, Valor: {produto['Valor_Produto']}, Quantidade: {produto['Quantidade_Produto']}")

        escolha = int(input("Escolha o número do produto que deseja vender: ")) - 1
        
        if escolha < 0 or escolha >= len(produtos):
            print("Escolha inválida!")
            return

        quantidade = int(input("Informe a quantidade para vender: "))

        # Verificar se o produto tem quantidade em estoque suficiente
        if "Quantidade" not in produtos[escolha]:
            produtos[escolha]["Quantidade"] = 0  # Caso o estoque não esteja especificado, inicializar com 0

        if produtos[escolha]["Quantidade"] < quantidade:
            print("Estoque insuficiente para esta venda.")
            return

        # Atualizar o estoque do produto
        produtos[escolha]["Quantidade"] -= quantidade

        # Registrar a venda
        venda = {
            "Nome_Produto": produtos[escolha]["Nome_Produto"],
            "Quantidade": quantidade,
            "Valor_Produto": produtos[escolha]["Valor_Produto"],
            "Total": float(produtos[escolha]["Valor_Produto"]) * quantidade
        }

        try:
            with open("vendas.json", "r") as arquivo_vendas:
                vendas = json.load(arquivo_vendas)
        except FileNotFoundError:
            vendas = []

        vendas.append(venda)

        with open("vendas.json", "w") as arquivo_vendas:
            json.dump(vendas, arquivo_vendas, indent=4)

        # Salvar a atualização no estoque
        with open("produtos.json", "w") as arquivo_json:
            json.dump(produtos, arquivo_json, indent=4)

        print("Venda registrada com sucesso.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
    except ValueError:
        print("Entrada inválida. Verifique os valores inseridos.")

    

def casos():
    escolha = int(input("Escolha: "))
    
    match escolha:
        case 1:
            cadastro_Produto()
        case 2:
            visualizar_Produtos()
        case 3:
            editar_Produtos()
        case 4:
          calcular_frete_produto() 
        case 5:
            vender_Produto()
        case 6:
            excluir_Produtos()
        case 7:
            print("Saindo...")
            exit()
        case _:
            print("Opção inválida! Tente novamente.")