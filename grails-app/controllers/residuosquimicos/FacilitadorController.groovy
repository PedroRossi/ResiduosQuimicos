package residuosquimicos

import grails.transaction.Transactional

@Transactional(readOnly = true)
class FacilitadorController {

    static allowedMethods = [removeAllSince: "PUT"]

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

    @Transactional
    def removeAllSince() {
        def laboratorioInstance = Laboratorio.get(params.laboratorio)
        if(laboratorioInstance != null) {
            laboratorioInstance.residuos.each {
                if(params.date < it.dataCadastro) {
                    laboratorioInstance.removeFromResiduos(it)
                    it.delete(flush: true)
                }
            }
        }
        flash.message = message(code: 'default.deleted.message')
        redirect(action:"index", method:"GET")
    }

    def relatory() {
        def laboratorioInstance = Laboratorio.get(params.laboratorio)
        def date = params.date
        def residuos = []
        if(laboratorioInstance != null) {
            laboratorioInstance.residuos.each {
                if(it.dataCadastro >= date) {
                    residuos.push(it)
                }
            }
        }
        [residuos: residuos]
    }
}
