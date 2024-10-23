*** Settings ***
Documentation    Realizar testes do dessafio
Resource    resouces.robot


*** Test Cases ***


Caso de teste 1 - Verificar qual numero é maior
    [Documentation]    Este verifica qual numero é maior utilizando IF/site_exclusão_de_ingrediente
    [Tags]    teste_numero_maior_IF/ELSE
    Verificar qual numero é maior

Caso de teste 2 - Exibir todos os numeros
    [Documentation]    Este tenta exibir todos os numero utilizando FOR e WHILE
    [Tags]    teste_FOR_WHILE
    Laço com For
    Laço com While

Caso de teste 3 - Retorno de busca
    [Documentation]    Este verifica o retorno de um link de busca
    [Tags]    teste_retorno_de_busca
    Testar o acionamento de link no retorno de busca