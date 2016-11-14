package support

import geb.Browser
import geb.binding.BindingUpdater
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor
import residuosquimicos.CentroList
import residuosquimicos.DepartamentoList
import residuosquimicos.Laboratorio
import residuosquimicos.LaboratorioList
import residuosquimicos.Residuo

this.metaClass.mixin(cucumber.api.groovy.Hooks)

Before() {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()

    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor(appCtx)
    scenarioInterceptor.init()

    def laboratorio = new Laboratorio(centro: CentroList.CB, departamento: DepartamentoList.DEPARTAMENTO_DE_ANTIBIOTICOS, laboratorio: LaboratorioList.LABORATORIO_DE_FARMACOLOGIA_E_CANCEROLOGIA_EXPERIMENTAIS)
    laboratorio.save()
}

After() {
    scenarioInterceptor.destroy()

    bindingUpdater.remove()
    Residuo.executeUpdate('delete from Residuo')
    Laboratorio.executeUpdate('delete from Laboratorio')
}