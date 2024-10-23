*** Settings ***
Library    SeleniumLibrary

Library    Collections

*** Variables ***

${NUMERO1}    1
${NUMERO2}    2
${NUMERO3}    3
${NUMERO4}    4
${CONTADOR}    0


@{LISTA}    ${NUMERO1}    ${NUMERO2}    ${NUMERO3}    ${NUMERO4}


${URL}    https://google.com



*** Keywords ***

Verificar qual numero é maior
    IF    ${NUMERO1} > ${NUMERO2}
        Log    O numero ${NUMERO1} é maior que o numero ${NUMERO2}
    ELSE
        Log    O numero ${NUMERO2} é maior que o numero ${NUMERO1}
    END

Laço com For
    FOR    ${NUMERO}    IN    @{LISTA}
        Log    ${NUMERO}
        
    END

Laço com While
    ${TAMANHO_LISTA}    Get Length    ${LISTA}
    WHILE    ${CONTADOR} < ${TAMANHO_LISTA}
        ${NUMERO}    Get From List    ${LISTA}    ${CONTADOR}
        Log    O item no índice ${CONTADOR} é ${NUMERO}
        ${CONTADOR}    Evaluate    ${CONTADOR} + 1
    END

Testar o acionamento de link no retorno de busca
    Open Browser    ${URL}    chrome
    Maximize Browser Window
    Input Text    name:q    Robot Framework
    Press Keys    name:q    ENTER
    Wait Until Element Is Visible    xpath://h3[contains(text(), 'Robot Framework')]
    Click Element    xpath://h3[contains(text(), 'Robot Framework')]
    Close Browser