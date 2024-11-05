from Cadastro_produtos import cadastro_Produto
from Visualizar_produtos import visualizar_Produtos
from Editar_produtos import editar_Produtos
from Calculo_frete import calcular_frete_produto
from Venda_produtos import vender_Produto
from Excluir_produtos import excluir_Produtos

def menu_principal():
    print("\n" + "\033[36m-\033[m" * 35)
    print("\033[35m Bem vindo ao sistema do mercadinho\033[m")
    print("\033[36m-\033[m" * 35 + "\n")
    print("\033[35m1.\033[m Cadastrar produto")
    print("\033[35m2.\033[m Visualizar produtos")
    print("\033[35m3.\033[m Editar produtos")
    print("\033[35m4.\033[m Calcular frete")
    print("\033[35m5.\033[m Vender produto")
    print("\033[35m6.\033[m Excluir produtos")
    print("\033[35m7.\033[m Sair \n")
    print("\033[36m-\033[m" * 35)


def casos():
    escolha = int(input("\033[35mEscolha: \033[m"))
    
    match escolha:
        case 1:
            nome_produto = input("Nome do produto: ")
            valor_produto = float(input("Valor do produto: "))
            peso_produto = float(input("Peso do produto: "))
            quantidade_produto = input("Quantidade do produto: ")
            
            cadastro_Produto(nome_produto, valor_produto, peso_produto, quantidade_produto)
        case 2:            
            visualizar_Produtos()
        case 3:
            visualizar_Produtos()
            nome_produto = input("Nome do produto: ")
            novo_nome = input("Novo nome para o produto: ")
            novo_valor = float(input("Novo Valor para o produto: "))
            nova_quantidade = int("Nova quantidade")
            
            editar_Produtos(nome_produto, novo_nome, novo_valor, nova_quantidade)
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