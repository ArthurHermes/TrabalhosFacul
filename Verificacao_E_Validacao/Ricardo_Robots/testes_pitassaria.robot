*** Settings ***
Documentation    Cadastro de ingrediente
Resource    resources_pitissaria.robot
Test Setup    Abrir o navegador
Test Teardown    Fechar navegador

*** Test Cases ***
Caso de teste 01 - Realizar cadastro de ingrediente sem preco
    [Documentation]    Este teste verifica o cadastro de um ingrediente sem valor
    [Tags]    site_cadastro_ingrediente
    Selecionar a opcao de login
    Digitar no campo usuario "gerente1"
    Digitar no campo senha "123"
    Acessar a area de ingredientes
    Acessar a area de cadastro de novos ingredientes
    Confirmar no modal que deseja cadastrar um novo ingrediente
    Inserir no campo nome o nome "Uva"
    Inserir no campo data de validade "31/01/2025"
    Inserir no campo data de entrada "10/10/2024"
    Inserir no campo de quantidade em KG "5"
    Realizar o cadastro de um novo ingrediente
    Capturar tela quando preco vazio    preco

Caso de teste 02 - Realizar cadastro de usuario sem cpf
    [Documentation]    Este verifica se é possivel realizar o cadastro sem um cpf
    [Tags]    site_cadastro_usuario

    Selecionar a opcao de cadastro
    Inserir no campo nome o nome "Adao"
    Inserir no campo username o username "Adao01"
    Inserir no campo email o email "adao01@gmail.com"
    Inserir no campo senha a senha "Teste@123456"
    Inserir no campo confirmar senha a senha "Teste@123"
    Inserir no campo data de nascimento a data "13/03/2005"
    Inserir no campo celular o celular "419955664344"
    Inserir no campo cep o cep 81940210
    Inserir no campo numero casa o numero "Casa 30"
    Realizar o cadastro de um novo usuario
    Verificar se o campo cpf foi preenchido    cpf


Caso de teste 03 - Inserir senha errada do usuario
    [Documentation]    Este verifica se existe algum tipo de validação com relação a senha
    [Tags]    site_login_com_senha_errada
    Selecionar a opcao de login
    Digitar no campo usuario "gerente1"
    Digitar no campo senha "gerente123"
    Capturar tela quando senha estar errada    senha



Caso de teste 04 - Encontrar Pizzas Disponiveis
    [Documentation]    Este verifica se é possivel encontar os sites de pizzas Disponiveis
    [Tags]    site_encontrar_pizza_disponiveis
    Selecionar a opcao de login
    Digitar no campo usuario "gerente1"
    Digitar no campo senha "123"
    Selecionar a opção de cardapio
    Verificar se foi possivel visualizar as pizzas disponiveis    Document

Caso de teste 05 - Cadastrar um Pizzaiolo com campos faltantes
    [Documentation]    Este testa se é possivel cadastrar um pizzaiolo com um campo em branco
    [Tags]    site_cadastro_pizzaiolo_campo_faltante
    Selecionar a opcao de login
    Digitar no campo usuario "gerente1"
    Digitar no campo senha "123"
    Acessar a area do pizzaiolo
    Selecionar a opcao de adicionar novo pizzaiolo
    Inserir no campo nome o nome "Adao"
    Inserir no campo username o username "Adao01"
    Inserir no campo email o email "adao01@gmail.com"
    Inserir no campo senha a senha "Teste@123456"
    Inserir no campo a data de nascimento "13/03/2005"
    Inserir no campo celular o celular "419955664344"
    Inserir no campo cep o cep 81940210
    Inserir no campo num_res o numero "592"
    Realizar o cadastro do pizzaiolo
    Verificar o campo cpf foi devidamente preenchido    cpf


Caso de teste 06 - Realizar a exclusao de Ingrediente na tabela ingredientes
    [Documentation]    Este verifica se é possivel remover um ingrediente
    [Tags]    site_exclusão_de_ingrediente
    Selecionar a opcao de login
    Digitar no campo usuario "gerente1"
    Digitar no campo senha "123"
    Acessar a area de ingredientes
    Excluir o primeiro ingrediente da tabela
    Confirmar exclusão no modal

Caso de teste 07 - Realizar pedido de uma pizza pronta
    [Documentation]    Aqui voce compra uma pizza pronta
    [Tags]    site_comprar_pizza_pronta
    Selecionar a opcao de login
    Digitar no campo usuario "gerente1"
    Digitar no campo senha "123"
    Acessar area de pizzas prontas
    Comprar uma pizza calabresa
    