package steps

import cucumber.api.PendingException
import pages.CreateResiduoPage
import pages.IndexFacilitadorPage
import pages.IndexResiduoPage
import pages.RelatorioFacilitadorPage
import pages.ShowResiduoPage
import residuosquimicos.FacilitadorController
import residuosquimicos.Laboratorio
import residuosquimicos.LaboratorioController
import residuosquimicos.LaboratorioList
import residuosquimicos.Residuo
import residuosquimicos.ResiduoController

/**
 * Created by pedro on 04/11/16.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^o resíduo "([^"]*)" pesando (\d+) na data "([^"]*)" está cadastrado$/) { String arg1, int arg2, String arg3 ->
    to CreateResiduoPage
    at CreateResiduoPage
    page.createResiduo(arg1, arg2, arg3)
    at ShowResiduoPage
}
When(~/^eu vou para a página principal de facilitador$/) { ->
    to IndexFacilitadorPage
    at IndexFacilitadorPage
}
Then(~/^eu visualizo (\d+) como o somatório dos pesos como peso total do laboratório$/) { int arg1 ->
    page.comparePeso(arg1)
}
And(~/^o numero (\d+) como quantidade total de residuos$/) { int arg1 ->
    page.compareQnt(arg1)
}
When(~/^eu clico para gerar relatório com "([^"]*)" como data$/) { String arg1 ->
    to IndexFacilitadorPage
    at IndexFacilitadorPage
    page.gerarRelatorio(arg1)
}
Then(~/^eu visualizo o resíduo "([^"]*)" na página de relatório$/) { String arg1 ->
    at RelatorioFacilitadorPage
    page.hasResiduo(arg1)
}
And(~/^eu vou para pagina principal de facilitador$/) { ->
    to IndexFacilitadorPage
    at IndexFacilitadorPage
}
When(~/^eu seleciono "([^"]*)" como a data e clico para remover os residuos$/) { String arg1 ->
    page.removerResiduos(arg1)
}
And(~/^eu vou para a página de listagem de resíduo$/) { ->
    to IndexResiduoPage
    at IndexResiduoPage
}
Then(~/^não existem resíduos a serem listados$/) { ->
    page.isEmpty()
}

def criarResiduo(nome, peso, data, laboratorio){
    def controlador = new ResiduoController()
    controlador.save(new Residuo([nome: nome, composicao:"None", peso: peso, dataCadastro: (new Date(data)), laboratorio:Laboratorio.findByLaboratorio(laboratorio)]))
    controlador.response.reset()
}

def removerResiduosDesde(data, laboratorio, controlador) {
    def d = new Date(data)
    def lab = Laboratorio.findByLaboratorio(laboratorio)
    controlador.params << [laboratorio:lab, date:d]
    controlador.removeAllSince()
    controlador.response.reset()
}

Given(~/^o resíduo "([^"]*)" pesando (\d+) na data "([^"]*)" está cadastrado no sistema$/) { String arg1, int arg2, String arg3 ->
    criarResiduo(arg1, arg2, arg3, LaboratorioList.LABORATORIO_DE_FARMACOLOGIA_E_CANCEROLOGIA_EXPERIMENTAIS)
}
When(~/^eu requisito uma remoção de resíduos a partir da data "([^"]*)"$/) { String arg1 ->
    def controlador = new FacilitadorController()
    removerResiduosDesde(arg1, LaboratorioList.LABORATORIO_DE_FARMACOLOGIA_E_CANCEROLOGIA_EXPERIMENTAIS, controlador)
}
Then(~/^a lista possui somente (\d+) resíduo$/) { int arg1 ->
    def count = Residuo.count()
    assert count == arg1
}