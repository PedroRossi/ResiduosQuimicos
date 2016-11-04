Feature: usuario facilitador do sistema
  As a facilitador cadastrado no sistema
  I Want To ser capaz de ter uma visão completa sobre o meu laboratorio e gerenciar residuos
  So That I Can gerenciar melhor a geracao de residuos dele

  Scenario: mostrar o peso total acumulado no momento
    Given os residuos "e1", "e2" e "e3" pesando 10, 20 e 15, respectivamente estao armazenados no momento
    And eu estou na pagina de listagem de residuos
    When eu clico para visualizar a pesagem atual do laboratorio
    Then eu visualizo 45 como peso total na pagina

  Scenario: mostrar uma lista de residuos a partir de uma certa data
    Given os residuos "e1", "e2" e "e3" foram armazenados em 20/09/2016
    And eles sao unicos no sistema
    When eu seleciono a data 20/08/2016
    And eu clico para gerar relatorio
    Then eu posso ver uma pagina com "e1", "e2" e "e3"

  Scenario: deletar todos os residuos a partir de certa data
    Given os residuos "e1", "e2" e "e3" foram armazenados em 20/09/2016
    And eles sao unicos no sistema
    When eu seleciono a data 20/08/2016
    And eu clico para remover os residuos
    Then eu posso ver uma pagina com uma mensagem de confirmacao
    And o numero total de residuos deletados
    And a pesagem total

  Scenario: mensagem de erro ao tentar deletar a partir de uma data que nao possui residuos
    Given os residuos "e1", "e2" e "e3" foram armazenados em 20/09/2016
    And eles sao unicos no sistema
    When eu seleciono a data 20/10/2016
    And eu clico para remover os residuos
    Then eu posso ver uma pagina com uma mensagem de erro