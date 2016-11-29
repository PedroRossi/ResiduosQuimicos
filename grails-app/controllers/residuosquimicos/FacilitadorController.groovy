package residuosquimicos

import grails.transaction.Transactional

@Transactional(readOnly = true)
class FacilitadorController {

    static allowedMethods = [removeAllSince: "POST"]

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
        Laboratorio laboratorioInstance = Laboratorio.findById(params.laboratorio)
        def count = 0
        if(laboratorioInstance != null) {
            def residuos = []
            laboratorioInstance.residuos.each {
                if(params.date < it.dataCadastro) {
                    residuos.push(it)
                    count++
                }
            }
            residuos.each {
                Residuo aux = it
                laboratorioInstance.removeFromResiduos(aux)
                aux.delete(flush: true)
            }
        }
        flash.message = message(code: 'default.deleted.message', args: [count, message(code: 'residuo.label', default: 'Residuos')])
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
