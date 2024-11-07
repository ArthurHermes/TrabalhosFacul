import json

def calcular_frete(peso, distancia):
    taxa_base = 5.0
    taxa_por_kg = 1.5
    taxa_por_km = 0.2

    frete = taxa_base + (taxa_por_kg * peso) + (taxa_por_km * distancia)
    return frete

def calcular_frete_produto():
    try:
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            print("Nenhum produto cadastrado para calcular frete.")
            return

        print("Produtos cadastrados:")
        for index, produto in enumerate(produtos):
            print(f"{index + 1}. Nome: {produto['Nome_Produto']}, Peso: {produto['Peso_Produto']} kg")

        while True:
            try:
                escolha = int(input("Escolha o número do produto para calcular o frete: ")) - 1
                if escolha >= 0 and escolha < len(produtos):
                    break
                else:
                    print("Escolha inválida! Tente novamente.")
            except ValueError:
                print("Entrada inválida. Por favor, insira um número inteiro.")

        while True:
            try:
                distancia = float(input("Informe a distância em km: "))
                if distancia > 0:
                    break
                else:
                    print("Distância deve ser maior que 0 km. Tente novamente.")
            except ValueError:
                print("Entrada inválida. Por favor, insira um número válido para a distância.")

        peso = produtos[escolha]['Peso_Produto']
        frete = calcular_frete(peso, distancia)
        
        print(f"O custo do frete para o produto '{produtos[escolha]['Nome_Produto']}' é R$ {frete:.2f}")

    except FileNotFoundError:
        print("Nenhum produto cadastrado ainda.")
    except json.JSONDecodeError:
        print("Erro ao ler o arquivo JSON. O formato pode estar corrompido.")
    except Exception as e:
        print(f"Erro inesperado: {e}")
