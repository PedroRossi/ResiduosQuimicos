package residuosquimicos

class FacilitadorController {

    def index() {
        redirect(action: "resumoSistema")
    }

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
}
