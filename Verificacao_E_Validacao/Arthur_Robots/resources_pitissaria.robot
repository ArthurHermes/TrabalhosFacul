*** Settings ***
Library    SeleniumLibrary
Library    Screenshot
Library    Process


*** Variables ***

# Variaveis padrão
${BROWSER}    chrome
${URL_GOOGLE}    https://www.google.com.br/

# Informações do nosso site
${URL}    http://127.0.0.1/Pitissaria/paginas/
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
    Sleep    1s
Acessar a area de cadastro de novos ingredientes
    Click Element    xpath=//a[@href="../paginas/cadastro_ingredientes.php"]
    Sleep    1s
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
# Caso de teste 02
Selecionar a opcao de cadastro
    Sleep    1s
    Click Element    xpath=//a[@href='cadastro.php']

Inserir no campo nome o nome "Adao"
    Sleep    1s
    Input Text    name:nome    ${NOME}

Inserir no campo username o username "Adao01"
    Sleep    1s
    Input Text    name:username    ${USERNAME}

Inserir no campo email o email "adao01@gmail.com"
    Sleep    1s
    Input Text    name:email    ${EMAIL}

Inserir no campo senha a senha "Teste@123456"
    Sleep    1s
    Input Password    name:senha    ${PASSWORD}

Inserir no campo confirmar senha a senha "Teste@123"
    Sleep    1s
    Input Password    name:confirmar-senha    ${PASSWORD}

Inserir no campo data de nascimento a data "13/03/2005"
    Sleep    1s
    Input Text    name:data-nascimento    ${DATA_NASCIMENTO}

Inserir no campo celular o celular "419955664344"
    Sleep    1s
    Input Text    name:celular    ${TELEFONE}

Inserir no campo cep o cep 81940210
    Sleep    1s
    Input Text    name:cep    ${CEP}

Inserir no campo numero casa o numero "Casa 30"
    Sleep    3s
    Input Text    name:num-res    ${NUMERO_CASA}

Realizar o cadastro de um novo usuario
    Sleep    1s
    Click Button    id:btn-enviar
    Sleep    1s


Verificar se o campo cpf foi preenchido
    [Arguments]    ${CPF}
    ${valor_campo}    Get Value    ${CPF}
    Log    Valor do campo CPF: ${valor_campo}
    Run Keyword If    '${valor_campo}' == ''    Capture Page Screenshot    campo_cpf_vazio.png
    Run Keyword If    '${valor_campo}' == ''    Log    O campo CPF não foi preenchido!

# 
# 
# 
# 
# Caso de teste 03

# Selecionar a opção de login esta localizado no caso de teste 01(Reutilizei para não ficar recriando a mesma linha de codigo)

# Digitar no campo usuario está localizado no caso de teste 01(Reutilizei para não ficar recriando a mesma linha de codigo)
Digitar no campo senha "gerente123"
    Input Password    name:senha    ${PSSWD_ERRADA}
    Click Button    id:btn-enviar
    Sleep    2s

Capturar tela quando senha estar errada
    [Arguments]    ${PSSWD_ERRADA}
    ${valor_campo}    Get Value    ${CAMPO_SENHA}
    Run Keyword If    '${valor_campo}' == ''    Capture Page Screenshot    campo_senha_incorreta.png
    Run Keyword If    '${valor_campo}' == ''    Log    Senha incorreta

# 
# 
# 
# 
#Caso de teste 04

# Selecionar a opção de login esta localizado no caso de teste 01(Reutilizei para não ficar recriando a mesma linha de codigo)

# Digitar no campo usuario está localizado no caso de teste 01(Reutilizei para não ficar recriando a mesma linha de codigo)

Selecionar a opção de cardapio
    Click Link    xpath=//a[@href="../paginas/pizzas_prontas.php"]


Verificar se foi possivel visualizar as pizzas disponiveis
    [Arguments]    ${TITULO_PIZZAS}
    ${TITULO_PAGINA}    Get Title
    Log    O título da página não corresponde: ${TITULO_PAGINA} vs ${TITULO_PIZZAS}
    Run Keyword If    '${TITULO_PAGINA}' == '${TITULO_PIZZAS}'    Capture Page Screenshot    pagina_disponivel.png

# 
# 
# 
# 
# Caso de teste 05

# Selecionar a opção de login esta localizado no caso de teste 01(Reutilizei para não ficar recriando a mesma linha de codigo)

# Digitar no campo usuario está localizado no caso de teste 01(Reutilizei para não ficar recriando a mesma linha de codigo)

Acessar a area do pizzaiolo
    Click Link    xpath=//a[@href="../php/listagem.php"]

Selecionar a opcao de adicionar novo pizzaiolo
    Click Link    xpath=//a[@href="cadastro.php"]


Inserir no campo a data de nascimento "13/03/2005"
    Input Text    name:data_nascimento    ${DATA_NASCIMENTO}

Inserir no campo num_res o numero "592"
    Input Text    id:num_res    ${NUMERO_CASA}

Realizar o cadastro do pizzaiolo
    Click Button    id:btn-enviar

Verificar o campo cpf foi devidamente preenchido
    [Arguments]    ${CPF}
    ${valor_campo}    Get Value    ${CPF}
    Log    Valor do campo CPF: ${valor_campo}
    Run Keyword If    '${valor_campo}' == ''    Capture Page Screenshot    campo_cpf_vazio_pizzaiolo.png
    Run Keyword If    '${valor_campo}' == ''    Log    O campo CPF não foi preenchido!
