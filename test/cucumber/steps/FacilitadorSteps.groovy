package steps

import cucumber.api.PendingException
import pages.facilitador.IndexFacilitador
import pages.facilitador.RelatorioFacilitador
import pages.laboratorio.CreateLaboratorio
import pages.laboratorio.ShowLaboratorio
import pages.residuo.CreateResiduo
import pages.residuo.IndexResiduo
import pages.residuo.ShowResiduo
import residuosquimicos.Laboratorio
import residuosquimicos.ResiduoController

/**
 * Created by pedro on 04/11/16.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^o residuos "([^"]*)" pesando (\d+) na data "([^"]*)" está cadastrado$/) {
String res, String peso, String data->
    // É preciso garantir que existe um laboratorio para o
    // teste ja que as implementacoes relativas a autenticacao
    // de usuario foram aconselhadas a nao serem feitas
    to CreateLaboratorio
    at CreateLaboratorio
    page.createLaboratorio()
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    // Data aleatoria já que nesse teste não importa a data
    page.createResiduo(res, peso, data)
    at ShowResiduo
}
And(~/^o residuo "([^"]*)" pesando (\d+) na data "([^"]*)" está cadastrado$/) {
String res, String peso, String data ->
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res, peso, data)
    at ShowResiduo
}
When(~/^eu vou para a pagina principal de facilitador$/) { ->
    to IndexFacilitador
    at IndexFacilitador
}
Then(~/^eu visualizo o (\d+) como o somatorio dos pesos como peso total do laboratorio$/) {
int pesoTotal ->
    page.comparePeso(pesoTotal)
}
And(~/^o numero (\d+) como quantidade total de residuos$/) {
int qntResiduos ->
    page.compareQnt(qntResiduos)
}

Given(~/^os residuos "([^"]*)" e "([^"]*)" estão cadastrados no sistema$/) {
String res1, String res2 ->
    to IndexResiduo
    at IndexResiduo
    page.hasResiduo(res1)
    page.hasResiduo(res2)
}
And(~/^o residuo "([^"]*)" com a data "([^"]*)" também está cadastrado$/) {
String res, String data ->
    to CreateResiduo
    at CreateResiduo
    // Peso arbitrario ja que o peso não importa nesse teste
    page.createResiduo(res, 10, data)
    at ShowResiduo
}
When(~/^eu clico para gerar relatorio com "([^"]*)" como data$/) {
String data ->
    to IndexFacilitador
    at IndexFacilitador
    page.gerarRelatorio(data)
    at RelatorioFacilitador
}
Then(~/^eu visalizo os residuos "([^"]*)", "([^"]*)" e "([^"]*)" na pagina de relatorio$/) {
String res1, String res2, String res3 ->
    page.hasResiduo(res1)
    page.hasResiduo(res2)
    page.hasResiduo(res3)
}

Given(~/^o residuos "([^"]*)" na data "([^"]*)" está cadastrado$/) {
String res, String data ->
    to IndexResiduo
    at IndexResiduo
    page.hasResiduo(res, data)
}
And(~/^o residuo "([^"]*)" na data "([^"]*)" está cadastrado$/) {
String res, String data ->
    to IndexResiduo
    at IndexResiduo
    page.hasResiduo(res, data)
}
When(~/^eu vou para pagina principal de facilitador$/) { ->
    to IndexFacilitador
    at IndexFacilitador
}
And(~/^eu seleciono "([^"]*)" como a data e clico para remover os residuos$/) {
String data ->
    page.removeResiduos(data)
}
Then(~/^eu posso ver uma pagina vazia$/) { ->
    to IndexResiduo
    page.isEmpty()
}

def criarResiduo(nome, data, controller) {
    controller << [nome: nome, data: new Date(data), descricao: "None", laboratorio: Laboratorio.find(1)]
    controller.save()
    controller.response.reset()
}

Given(~/^o residuos "([^"]*)" está cadastrado na data "([^"]*)"$/) {
String nome, String data ->
    def resCont = new ResiduoController()
    criarResiduo(nome, data, resCont)
    assert Residuo.size() == 1
}
When(~/^eu requisito um relatorio dos residuos a partir de "([^"]*)"$/) { String arg1 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^nada é retornado$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}