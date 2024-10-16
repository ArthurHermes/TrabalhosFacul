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
    Inserir no campo numero casa o numero "592, casa 30"
    Realizar o cadastro de um novo usuario