import unittest
import json
import os
from Cadastro_produtos import cadastro_Produto
from Calculo_frete import calcular_frete
from Editar_produtos import editar_Produto
from Excluir_produtos import excluir_Produto
from Venda_produtos import vender_Produto
from Visualizar_produtos import visualizar_Produto


class TestSistemaMercadinho(unittest.TestCase):
    
    def setUp(self):
        self.produtos_file = "Json/produtos.json"
        self.vendas_file = "Json/vendas.json"
        with open(self.produtos_file, "w") as f:
            json.dump([], f)
        with open(self.vendas_file, "w") as f:
            json.dump([], f)

    def tearDown(self):
        if os.path.exists(self.produtos_file):
            os.remove(self.produtos_file)
        if os.path.exists(self.vendas_file):
            os.remove(self.vendas_file)
            
            

    # 1. Cadastro Produto
    
    # Cadastro de produto com exito
    def teste_cadastro_produto_exito(self):
        cadastro_Produto("Feijão", 10.0, 1.0, 30)
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(len(produtos), 1)
        self.assertEqual(produtos[0]['Nome_Produto'], "Feijão")

    # Cadastro de produto com erro
    def teste_cadastro_produto_erro(self):
        cadastro_Produto("Arroz", 15.0, 1.0, 20)
        try:
            cadastro_Produto("Arroz", 15.0, 1.0, 20)
            self.fail("Expected error for duplicate product")
        except Exception as e:
            self.assertEqual(str(e), "Erro: Produto 'Arroz' já está cadastrado")



    # 2. Editar Produto
    # Editar produto com exito
    def teste_editar_produto_exito(self):
        cadastro_Produto("Feijão", 10.0, 1.0, 30)
        editar_Produto("Feijão", novo_nome="Feijão Premium", novo_valor=25.0, nova_quantidade=30)
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(produtos[0]['Nome_Produto'], "Feijão Premium")
        self.assertEqual(produtos[0]['Valor_Produto'], 25.0)
        self.assertEqual(produtos[0]['Quantidade_Produto'], 30)


    # Editar produto com erro
    def teste_editar_produto_erro(self):
        try:
            editar_Produto("Arroz", novo_nome="Arroz Orgânico", novo_valor=20.0, nova_quantidade=15)
            self.fail("Expected error for non-existing product")
        except Exception as e:
            self.assertEqual(str(e), "Erro: Produto 'Arroz' não encontrado")



    # 3. Excluir Produto
    # Excluir com produto com exito
    def teste_excluir_produto_existente(self):
        cadastro_Produto("Macarrão", 5.0, 1.0, 100)
        excluir_Produto("Macarrão")
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(len(produtos), 0)


    # Excluir produto com erro
    def teste_excluir_produto_erro(self):
        try:
            excluir_Produto("Café")
            with open(self.produtos_file, "r") as f:
                produtos = json.load(f)
            self.assertEqual(len(produtos), 0)
        except Exception as e:
            self.assertEqual(str(e), "Erro: Produto 'Café' não encontrado")



    # 4. Calcular Frete
    # Calular par aveereificar se o calculo esta certo
    def teste_calcular_frete(self):
        frete = calcular_frete(10.0, 10.0)
        self.assertEqual(frete, 22.0)



    # 5. Vender Produto
    # Verificar se está diminuindo o valor da quantidade de itens do estoque
    def test_vender_produto(self):
        cadastro_Produto("Produto F", 10.0, 1.0, 5)
        vender_Produto("Produto F", 1)
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(produtos[0]['Quantidade_Produto'], 4)


