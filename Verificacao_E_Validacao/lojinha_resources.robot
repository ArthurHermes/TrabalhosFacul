*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${BROWSER}    chrome
${URL_GOOGLE}    https://www.google.com.br/
${URL}    http://165.227.93.41/lojinha-web/ 
${TITULO}    Lojinha
${USUARIO}    rafael
${SENHA}    123456

*** Keywords ***
Abrir o Navegador
    Open Browser    ${URL}    browser=${BROWSER}
    Maximize Browser Window
    
Fechar o Navegador
    Close Browser

Acessar a pagina home do site
    Go To    url=${URL}

Digitar no campo usuário o usuário "rafael"
    Input Text    id:usuario    ${USUARIO}

Digitar no campo senha a senha do usuário ativo "123456"
    Input Password    id:senha    ${SENHA}

Adicionar o botão entrar e Verificar se o nome do usuário aparece na tela de boas vindas
    Click Button    id:entrar
    Capture Page Screenshot