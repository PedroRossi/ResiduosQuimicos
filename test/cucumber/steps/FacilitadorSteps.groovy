package steps

import cucumber.api.PendingException
import pages.facilitador.IndexFacilitador
import pages.laboratorio.CreateLaboratorio
import pages.laboratorio.ShowLaboratorio
import pages.residuo.CreateResiduo
import pages.residuo.ShowResiduo

/**
 * Created by pedro on 04/11/16.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^o residuos "([^"]*)" pesando (\d+) está cadastrado$/) {
String res, peso ->
    // É preciso garantir que existe um laboratorio para o
    // teste ja que as implementacoes relativas a autenticacao
    // de usuario foram aconselhadas a nao serem feitas
    to CreateLaboratorio
    at CreateLaboratorio
    page.createLaboratorio()
    at ShowLaboratorio
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res, peso, "20/09/2016")
    at ShowResiduo
}
And(~/^o residuo "([^"]*)" pesando (\d+) está cadastrado$/) {
String res, peso ->
    to CreateResiduo
    at CreateResiduo
    page.createResiduo(res, peso, "20/09/2016")
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

Given(~/^os residuos "([^"]*)", "([^"]*)" e "([^"]*)" com a data "([^"]*)" estão cadastrados no sistema$/) {
String res1, String res2, String res3, String data ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
When(~/^eu seleciono a data "([^"]*)" para gerar relatorio$/) {
String data ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^clico para gerar relatorio$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^eu visalizo os residuos "([^"]*)", "([^"]*)" e "([^"]*)" em uma pagina$/) {
String res1, String res2, String res3 ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

Given(~/^o residuos "([^"]*)" na data "([^"]*)" está cadastrado$/) {
String res, String data ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^o residuo "([^"]*)" na data "([^"]*)" está cadastrado$/) {
String res, String data ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
When(~/^eu seleciono "([^"]*)" como a data$/) {
String data ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
And(~/^eu clico para remover os residuos$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^eu posso ver uma pagina com o numero total de residuos deletados$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}

Given(~/^o residuos "([^"]*)" com a data "([^"]*)" se encontra armazenado$/) {
String res, String data ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
When(~/^eu clico para remover os residuos com "([^"]*)" como a data$/) {
String data ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}
Then(~/^eu posso ver uma pagina com uma mensagem de erro$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}