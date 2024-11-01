import json

def menu_principal():
    print("-*" * 17 + "-")
    print("Bem vindo ao sistema do mercadinho")
    print("-*" * 17 + "-")
    print("1. Cadastrar produto")
    print("2. Visualizar produtos")
    print("3. Editar produtos")
    print("4. Excluir produtos")
    print("5. Sair")
    print("-*" * 17 + "-")
    
    
    

def cadastro_Produto():
    try:
        with open("Verificacao_E_Validacao\\Trabalho_final\\produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)
    except FileNotFoundError:
        produtos = []


    nome_produto = input("Nome do produto: ")
    valor_produto = input("Valor produto: ")

    produto = {
        "Nome_Produto": nome_produto,
        "Valor_Produto": valor_produto
    }
    
    produtos.append(produto)
    
    # Salva a lista atualizada no arquivo JSON
    with open("Verificacao_E_Validacao\\Trabalho_final\\produtos.json", "w") as arquivo_json:
        json.dump(produtos, arquivo_json, indent=4)
        
    print("Produto cadastrado com sucesso.")
        
        
        
def visualizar_Produtos():
    try:
        with open("Verificacao_E_Validacao\\Trabalho_final\\produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)
            
            for produto in produtos:
                print(f"Nome do Produto: {produto['Nome_Produto']}, Valor: {produto['Valor_Produto']}")
                
    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")





def editar_Produtos():
    try:
        with open("Verificacao_E_Validacao\\Trabalho_final\\produtos.json", "r") as arquivo_json:
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

        with open("Verificacao_E_Validacao\\Trabalho_final\\produtos.json", "w") as arquivo_json:
            json.dump(produtos, arquivo_json, indent=4)

        print("Produto atualizado com sucesso.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
        
        
        
        
        
def excluir_Produtos():
    try:
        with open("Verificacao_E_Validacao\\Trabalho_final\\produtos.json", "r") as arquivo_json:
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
            produtos.pop(escolha)  # Remove o produto da lista
            # Salva a lista atualizada no arquivo JSON
            with open("Verificacao_E_Validacao\\Trabalho_final\\produtos.json", "w") as arquivo_json:
                json.dump(produtos, arquivo_json, indent=4)
            print("Produto excluído com sucesso.")
        else:
            print("Exclusão cancelada.")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")

    

    

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
            
        case 5:
            print("Saindo do sistema.")
            exit()
        case _:
            print("Opção inválida! Tente novamente.")




if __name__ == "__main__":
    while True:
        menu_principal()   
        casos()
