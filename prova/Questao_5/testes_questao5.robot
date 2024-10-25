*** Settings ***
Resource    resources_questao5.robot
Documentation    Teste para a prova RA3
Task Setup    Abrir Navegador
Task Teardown    Fechar Navegador



*** Test Cases ***

# A automação deve preencher todos os campos obrigatórios do formulário escolhido
# Após a submissão do formulário, deve-se conferir se a execução foi realizada,
# além de capturar a imagem do formulário preenchido
# Adicione descrições no seu código para facilitar a compreensão
# Certifique-se de que a automação é eficiente e está bem estruturada

Caso de teste 01 - Preencher campos do formulario
    [Documentation]    Este preenche todos os campos do formulario
    [Tags]    site_convergencia_digital
    Inserir email no campo email
    Inserir nome no campo nome
    Inserir cargo no campo cargo
    Inserir empresa no campo empresa
    Printar campos preenchidos
    Enviar Formulario
    Confirmar envio
    

