package residuosquimicos

import grails.validation.Validateable

class FacilitadorController {

    def index() { }

    def resumoSistema() {
        def pesoTotal = 0
        def qntResiduos = 0;

        Laboratorio.all.each {
            it.residuos.each {
                pesoTotal+=it.peso
                qntResiduos++
            }
        }

        [peso: pesoTotal, qntResiduos: qntResiduos]
    }

    def removeAllSince() {
        def laboratorioInstance = Laboratorio.get(params.laboratorio.id)
        def date = params.date
        def residuos = []
        laboratorioInstance.residuos.each { residuo ->
            if(residuo.dataCadastro <= date) {
                residuos.push(residuo)
            }
        }
        residuos.each {
            laboratorioInstance.removeFromResiduos(it)
            it.delete(flush: true)
        }
        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.deleted.message', args: [message(code: 'Residuo.label', default: 'Residuo'), count])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def relatorio() {
        def laboratorioInstance = Laboratorio.get(params.laboratorio.id)
        def date = params.date
        def residuos = []
        laboratorioInstance.residuos.each {
            if(it.dataCadastro >= date) {
                residuos.push(it)
            }
        }
        [residuos: residuos]
    }
}
