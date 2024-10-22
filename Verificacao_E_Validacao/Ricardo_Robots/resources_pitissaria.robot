*** Settings ***
Library    SeleniumLibrary
Library    Screenshot
Library    Process
Library    XML


*** Variables ***

# Variaveis padrão
${BROWSER}    chrome
${URL_GOOGLE}    https://www.google.com.br/

# Informações do nosso site
${URL}    http://localhost/Pitissaria/paginas/index.php
${TITULO}    Pitissaria

# Caso de teste 01/03 Informações de login corretas
${USER}    gerente1
${PSSWD}    123

# Caso de teste 01 - Cadastro de ingrediente sem valor
${NOME_INGREDIENTE}    Uva
${DATA_VALIDADE}    31/01/2005
${DATA_ENTRADA}    10/10/2024
${QUANTIDADE_KG}    5
${PRECO}    nome:preco


# Caso de teste 02 - Realizar cadastro de usuario sem cpf
${NOME}    Adao
${USERNAME}    Adao01
${EMAIL}    adao01@gmail.com
${PASSWORD}    Teste@123456
${DATA_NASCIMENTO}    13/03/2005
${TELEFONE}    41995664344
${CEP}    81940210
${NUMERO_CASA}     592,Casa 30
${CPF}    name:cpf


# Caso de teste 03 - Informações de login com a senha errada
${PSSWD_ERRADA}    gerente123
${CAMPO_SENHA}    name:senha


#Caso de teste 04 - Informações da pagina

${TITULO_PIZZAS}    Document



# Caso de teste 05 - Informações pizzaiolo

# Caso de teste 07 - Informacoes pizzas

${CALABRESA}    calabresa

# Todas as informações estão no Caso de teste 02

*** Keywords ***
Abrir o navegador
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window

Fechar navegador
    Close Browser


# Caso de teste 01
Selecionar a opcao de login
    Sleep    1s
    Click Element    xpath=//a[@href='login.php']
    
Digitar no campo usuario "gerente1"
    Input Text    name:email-username    ${USER}
    Sleep    1s 

Digitar no campo senha "123"
    Input Password    name:senha    ${PSSWD}
    Click Button    id:btn-enviar
    Sleep    2s

Acessar a area de ingredientes
    Click Element    xpath=//a[@href="../php/lista_ingredientes.php"]
    Sleep     3s

Acessar a area de cadastro de novos ingredientes
    Click Element    xpath=//a[@href="../paginas/cadastro_ingredientes.php"]
    Sleep    3s
Confirmar no modal que deseja cadastrar um novo ingrediente
    Click Element    xpath=//button[@class='swal2-confirm swal2-styled swal2-default-outline']
    Sleep    1s
Inserir no campo nome o nome "Uva"
    Input Text    id:nome    ${NOME_INGREDIENTE}
    Sleep    1s
Inserir no campo data de validade "31/01/2025"
    Input Text    id:data_validade    ${DATA_VALIDADE}
    Sleep    1s
Inserir no campo data de entrada "10/10/2024"
    Input Text    id:data_entrada    ${DATA_ENTRADA}
    Sleep    1s
Inserir no campo de quantidade em KG "5"
    Input Text    id:quantidade    ${QUANTIDADE_KG}
    Sleep    1s

Realizar o cadastro de um novo ingrediente
    Click Button    id:btn-enviar
    Sleep    2s

Capturar tela quando preco vazio 
    [Arguments]    ${PRECO}
    ${valor_campo}    Get Value    ${PRECO}
    Log    Valor do campo VALOR: ${valor_campo}
    Run Keyword If    '${valor_campo}' == ''    Capture Page Screenshot    preco_vazio.png
    Run Keyword If    '${valor_campo}' == ''    Log    O campo VALOR não foi preenchido!

# 
# 
# 
# 
# Caso de teste 07 - Realizar pedido de uma pizza pronta

Acessar area de pizzas prontas
    Click Element    xpath=//a[@href="../paginas/pizzas_prontas.php"]
    Sleep     1s

Comprar uma pizza calabresa
    Click Element    xpath://*[@id='Calabresa']
    Sleep    3s