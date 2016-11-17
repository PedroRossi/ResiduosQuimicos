Feature: usuario facilitador do sistema
  Como um facilitador cadastrado no sistema
  Eu quero ser capaz de ter uma visão completa sobre o meu laboratorio e gerenciar residuos
  De modo que eu gerencie melhor a geracao de residuos dele

  #CONTROLLER
  Scenario: garantir que o sistema deleta resíduos a partir de certa data
    Given o resíduo "e1" pesando 10 na data "21/09/2016" está cadastrado no sistema
    And o resíduo "e2" pesando 20 na data "19/09/2016" está cadastrado no sistema
    When eu requisito uma remoção de resíduos a partir da data "20/09/2016"
    Then a lista possui somente 1 resíduo

  #GUI
  Scenario: mostrar o peso total acumulado no momento
    Given o resíduo "e1" pesando 10 na data "21/09/2016" está cadastrado
    And o resíduo "e2" pesando 20 na data "19/09/2016" está cadastrado
    When eu vou para a página principal de facilitador
    Then eu visualizo 30 como o somatório dos pesos como peso total do laboratório
    And o numero 2 como quantidade total de residuos

  #GUI
  Scenario: mostrar uma lista de residuos a partir de uma certa data
    Given o resíduo "e1" pesando 10 na data "21/09/2016" está cadastrado
    And o resíduo "e2" pesando 20 na data "19/09/2016" está cadastrado
    And o resíduo "e3" pesando 30 na data "18/09/2016" está cadastrado
    When eu clico para gerar relatório com "20/08/2016" como data
    Then eu visualizo o resíduo "e1" na página de relatório

  #GUI
  Scenario: deletar todos os residuos a partir de certa data
    Given o resíduo "e1" pesando 10 na data "21/09/2016" está cadastrado
    And o resíduo "e2" pesando 20 na data "19/09/2016" está cadastrado
    And eu vou para pagina principal de facilitador
    When eu seleciono "18/08/2016" como a data e clico para remover os residuos
    And eu vou para a página de listagem de resíduo
    Then não existem resíduos a serem listados