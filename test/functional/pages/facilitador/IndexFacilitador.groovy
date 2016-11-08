package pages.facilitador

import geb.Page

import java.text.DateFormatSymbols

/**
 * Created by pedro on 04/11/16.
 */
class IndexFacilitador extends Page {

    static url = "/ResiduosQuimicos/facilitador/resumoSistema"

    static at = {
        title ==~ /Resumo Sistema/
    }

    boolean comparePeso(peso) {
        $("p", name: "peso").has(text: peso)
    }

    boolean compareQnt(qntResiduos) {
        $("p", name: "qntResiduos").has(text: qntResiduos)
    }

    boolean isEmpty() {
        $("tbody").isEmpty()
    }

    def gerarRelatorio(data) {
        data = data.split("/")
        def dia = data[0]
        def mes = data[1]
        def ano = data[2]
        $("form").date_day = dia
        // TODO internacionalizar
        String mesString = new DateFormatSymbols(Locale.US).getMonths()[Integer.parseInt(mes)-1]
        $("form").date_month = mesString
        $("form").date_year = ano
        $("input", name: "create").click()
    }
}
