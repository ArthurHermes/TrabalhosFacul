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




    def test_cadastro_produto(self):
        cadastro_Produto("Produto A", 10.0, 1.0, 5)
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(len(produtos), 1)
        self.assertEqual(produtos[0]['Nome_Produto'], "Produto A")




    def test_calcular_frete(self):
        frete = calcular_frete(2.0, 10.0)
        self.assertEqual(frete, 10.0)




    def test_visualizar_produto(self):
        cadastro_Produto("Produto A", 10.0, 1.0, 5)
        cadastro_Produto("Produto B", 20.0, 2.0, 3)
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(len(produtos), 2)
        self.assertEqual(produtos[1]['Nome_Produto'], "Produto B")




    def test_editar_produto(self):

        cadastro_Produto("Produto A", 10.0, 1.0, 5)
        editar_Produto("Produto A", novo_nome="Novo Nome", novo_valor=15.0, nova_quantidade=10)
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(produtos[0]['Nome_Produto'], "Novo Nome")
        self.assertEqual(produtos[0]['Valor_Produto'], 15.0)




    def test_excluir_produto(self):

        cadastro_Produto("Produto A", 10.0, 1.0, 5)
        excluir_Produto("Produto A")
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(len(produtos), 0)



    def test_vender_produto(self):
        cadastro_Produto("Produto F", 10.0, 1.0, 5)
        vender_Produto("Produto F", 1)
        with open(self.produtos_file, "r") as f:
            produtos = json.load(f)
        self.assertEqual(produtos[0]['Quantidade_Produto'], 4)


if __name__ == "__main__":
    unittest.main()
