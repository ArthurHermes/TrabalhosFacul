*** Settings ***
Documentation    Realizar login com usuário ativo
Resource    lojinha_resources.robot
Test Setup    Abrir o navegador
Test Teardown    Fechar o Navegador



*** Test Cases ***
Caso de teste 01 - Realizar login
    [Documentation]    Este teste verifica o site da lojinha
    [Tags]    site_principal
    Acessar a pagina home do site
    Digitar no campo usuário o usuário "rafael"
    Digitar no campo senha a senha do usuário ativo "123456"
    Adicionar o botão entrar e Verificar se o nome do usuário aparece na tela de boas vindas
