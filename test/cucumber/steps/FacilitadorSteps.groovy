package steps

import cucumber.api.PendingException
import pages.facilitador.IndexFacilitador
import pages.facilitador.RelatorioFacilitador
import pages.laboratorio.CreateLaboratorio
import pages.laboratorio.ShowLaboratorio
import pages.residuo.CreateResiduo
import pages.residuo.IndexResiduo
import pages.residuo.ShowResiduo

import javax.persistence.Index

/**
 * Created by pedro on 04/11/16.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Given(~/^o residuos "([^"]*)" pesando (\d+) na data "([^"]*)" está cadastrado$/) {
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
    // Data aleatoria já que nesse teste não importa a data
    page.createResiduo(res, peso, "20/09/2016")
    at ShowResiduo
}
And(~/^o residuo "([^"]*)" pesando (\d+) na data "([^"]*)" está cadastrado$/) {
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
}
Then(~/^eu visalizo os residuos "([^"]*)", "([^"]*)" e "([^"]*)" na pagina de relatorio$/) {
String res1, String res2, String res3 ->
    at RelatorioFacilitador
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
Then(~/^eu posso ver uma pagina com (\d+) como o numero total de residuos deletados$/) {
int n ->
    at RemocaoFacilitador
    page.hasQntResiduos(n)
}

Given(~/^nenhum residuo se encontra armazenado$/) {
    to IndexFacilitador
    at IndexFacilitador
    page.isEmpty()
}
When(~/^eu clico para remover os residuos com "([^"]*)" como a data$/) {
String data ->
    page.removeResiduos(data)
}
Then(~/^eu posso ver uma pagina com uma mensagem de erro$/) { ->
    at IndexFacilitador
    page.hasRemoveError()
}