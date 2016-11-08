Feature: usuario facilitador do sistema
  Como um facilitador cadastrado no sistema
  Eu quero ser capaz de ter uma visão completa sobre o meu laboratorio e gerenciar residuos
  De modo que eu gerencie melhor a geracao de residuos dele

  Scenario: mostrar o peso total acumulado no momento
    Given o residuos "e1" pesando 10 na data "21/09/2016" está cadastrado
    And o residuo "e2" pesando 20 na data "19/09/2016" está cadastrado
    When eu vou para a pagina principal de facilitador
    Then eu visualizo o 30 como o somatorio dos pesos como peso total do laboratorio
    And o numero 2 como quantidade total de residuos

  Scenario: mostrar uma lista de residuos a partir de uma certa data
    Given os residuos "e1" e "e2" estão cadastrados no sistema
    And o residuo "e3" com a data "22/09/2016" também está cadastrado
    When eu clico para gerar relatorio com "18/08/2016" como data
    Then eu visalizo os residuos "e1", "e2" e "e3" na pagina de relatorio

  Scenario: deletar todos os residuos a partir de certa data
    Given o residuos "e1" na data "21/09/2016" está cadastrado
    And o residuo "e2" na data "19/08/2016" está cadastrado
    When eu vou para pagina principal de facilitador
    And eu seleciono "18/08/2016" como a data e clico para remover os residuos
    Then eu posso ver uma pagina vazia

  Scenario: garantir que nao deleta ao escolher uma data a qual nao possua residuos
    Given o residuos "x" está cadastrado na data "10/10/2010"
    When eu requisito um relatorio dos residuos a partir de "10/10/2011"
    Then nada é retornado