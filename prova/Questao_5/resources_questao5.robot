*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${BROWSER}    chrome
${URL}    https://visitor.r20.constantcontact.com/manage/optin?v=001nFupVrVrNd4UjGfZPy62KHBuj79961VKz4QWIP-7uVcCr1I-NMtOt3RO6gWporZprHQ_BuPjcMuMYXvwSb-6Qh_PdVoVxfJWRDbpNc02StM%3D

${NOME}    Arthur Hermes
${EMAIL}    arthurfhermes@gmail.com
${Cargo}    Programador
${EMPRESA}    VIBE BAR    

*** Keywords ***

Abrir Navegador
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window

Inserir email no campo email
    Input Text    id:inputProp0     ${EMAIL}

Inserir nome no campo nome
    Input Text    id:inputProp1    ${NOME}

Inserir cargo no campo cargo
    Input Text    inputProp2    ${CARGO}

Inserir empresa no campo empresa
    Input Text    id:inputProp3    ${EMPRESA}

Printar campos preenchidos
    Capture Page Screenshot    campos_preenchidos.png

Enviar Formulario
    Click Element    id:update-profile-submit-btn
    Capture Page Screenshot    formulario_enviado.png

Fechar Navegador
    Close Browser
