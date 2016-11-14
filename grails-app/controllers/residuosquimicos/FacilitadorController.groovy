package residuosquimicos

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

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

    @Transactional
    def removeAllSince() {
        def laboratorioInstance = Laboratorio.get(params.laboratorio.id)
        if(laboratorioInstance != null) {
            laboratorioInstance.residuos.each {
                if(params.date < it.dataCadastro) {
                    laboratorioInstance.removeFromResiduos(it)
                    it.delete()
                }
            }
        }
        request.withFormat {
            form multipartForm {
                //flash.message = message(code: 'default.deleted.message', args: [message(code: 'Residuo.label', default: 'Residuo'), count])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    def relatory() {
        def laboratorioInstance = Laboratorio.get(params.laboratorio.id)
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
