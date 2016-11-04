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


Given(~/^eu criei os residuos "([^"]*)", "([^"]*)" e "([^"]*)" pesando (\d+), (\d+) e (\d+) respectivamente$/) {
    String res1, String res2, String res3, int peso1, int peso2, int peso3 ->
        // É preciso garantir que existe um laboratorio para o
        // teste ja que as implementacoes relativas a autenticacao
        // de usuario foram aconselhadas a nao serem feitas
        to CreateLaboratorio
        at CreateLaboratorio
        page.createLaboratorio()
        at ShowLaboratorio
        to CreateResiduo
        at CreateResiduo
        page.createResiduo(res1, peso1)
        at ShowResiduo
        to CreateResiduo
        at CreateResiduo
        page.createResiduo(res2, peso2)
        at ShowResiduo
        to CreateResiduo
        at CreateResiduo
        page.createResiduo(res3, peso3)
        at ShowResiduo
}
When(~/^eu vou para a pagina principal de facilitador$/) { ->
    to IndexFacilitador
    at IndexFacilitador
}
Then(~/^eu visualizo (\d+) como peso total do laboratorio e (\d+) como quantidade de residuos$/) {
    int pesoTotal, int qntResiduos ->
        page.compare(pesoTotal, qntResiduos)
}