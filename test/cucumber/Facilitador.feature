Feature: usuario facilitador do sistema
  Como um facilitador cadastrado no sistema
  Eu quero ser capaz de ter uma visão completa sobre o meu laboratorio e gerenciar residuos
  De modo que eu gerencie melhor a geracao de residuos dele

  Scenario: mostrar o peso total acumulado no momento
    Given o residuos "e1" pesando 10 está cadastrado
    And o residuo "e2" pesando 20 está cadastrado
    When eu vou para a pagina principal de facilitador
    Then eu visualizo o 30 como o somatorio dos pesos como peso total do laboratorio
    And o numero 2 como quantidade total de residuos

  Scenario: mostrar uma lista de residuos a partir de uma certa data
    Given os residuos "e1", "e2" e "e3" com a data "20/09/2016" estão cadastrados no sistema
    When eu seleciono a data "20/08/2016" para gerar relatorio
    And clico para gerar relatorio
    Then eu visalizo os residuos "e1", "e2" e "e3" em uma pagina

  Scenario: deletar todos os residuos a partir de certa data
    Given o residuos "e1" na data "20/09/2016" está cadastrado
    And o residuo "e2" na data "19/08/2016" está cadastrado
    When eu seleciono "20/08/2016" como a data
    And eu clico para remover os residuos
    Then eu posso ver uma pagina com o numero total de residuos deletados

  Scenario: mensagem de erro ao tentar deletar a partir de uma data que nao possui residuos
    Given o residuos "e1" com a data "22/09/2016" se encontra armazenado
    When eu clico para remover os residuos com "20/10/2016" como a data
    Then eu posso ver uma pagina com uma mensagem de erro