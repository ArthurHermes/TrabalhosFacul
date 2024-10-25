*** Settings ***
Library    SeleniumLibrary

*** Variables ***

${URL}    https://www.netshoes.com.br
${BROWSER}    chrome

*** Test Cases ***

Caso de teste com Erros
    Abrir Navegador ${URL} ${BROWSER}
    Realizar Pesquisa Robot Framework
    Verificar Resultados 10


*** Keywords ***



Abrir Navegador ${URL} ${BROWSER}
    # A variavel ${URL} esta sendo chamada de maneira errada
    Open Browser    ${URL}    ${BROWSER} 
    
Realizar Pesquisa ${termo}
    # O locator não esta definido da maneira correta
    # A variavel termo não existe
    Input Text    Pesquisa    ${termo}
    # O locator não esta definido da maneira correta
    Click Button    Search 

Verificar Resultados ${quantidade}
    ${resultados}    Get Text    Resultados
    Should Be Equal As Numbers    ${resultados}    ${quantidade}


# A variavel ${URL} esta sendo chamada de maneira errada, ela esta sendo chamada com minusculas, mas deve ser chamadas com maiusculas como esta definido lá em cima
# O locator Pesquisa e Search não foram definidos de maneira correta    name:nome do local