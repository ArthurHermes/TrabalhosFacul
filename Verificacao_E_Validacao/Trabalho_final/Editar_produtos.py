import json

class ProdutoNaoEncontradoError(Exception):
    """Exceção personalizada para quando o produto não for encontrado."""
    pass

def editar_Produto(nome_produto: str, novo_nome: str = None, novo_valor: float = None, nova_quantidade: int = None, confirmar: str = 's') -> None:
    try:
        # Abre o arquivo JSON e carrega os produtos
        with open("Json/produtos.json", "r") as arquivo_json:
            produtos = json.load(arquivo_json)

        if not produtos:
            raise ValueError("Erro: Nenhum produto cadastrado para editar.")

        # Procura o produto com o nome fornecido
        produto_encontrado = None
        for produto in produtos:
            if produto['Nome_Produto'] == nome_produto:
                produto_encontrado = produto
                break

        if produto_encontrado is None:
            raise ProdutoNaoEncontradoError(f"Erro: Produto '{nome_produto}' não encontrado.")

        # Permite editar os campos caso sejam fornecidos novos valores
        if novo_nome is not None:
            produto_encontrado['Nome_Produto'] = novo_nome
        if novo_valor is not None:
            produto_encontrado['Valor_Produto'] = novo_valor
        if nova_quantidade is not None:
            produto_encontrado['Quantidade_Produto'] = nova_quantidade

        # Confirmação antes de salvar as alterações
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
    except ProdutoNaoEncontradoError as e:
        print(e)
    except Exception as e:
        print(f"Ocorreu um erro inesperado: {e}")
