package pages

import geb.Page

import java.text.DateFormatSymbols

/**
 * Created by pedro on 04/11/16.
 */
class IndexFacilitadorPage extends Page {

    static url = "/ResiduosQuimicos/facilitador/index"

    static at = {
        title ==~ /Index Facilitador/
    }

    boolean comparePeso(peso) {
        $("p", name: "peso").has(text: peso)
    }

    boolean compareQnt(qntResiduos) {
        $("p", name: "qntResiduos").has(text: qntResiduos)
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
        $("input", class: "relatory").click()
    }

    def removerResiduos(data) {
        data = data.split("/")
        def dia = data[0]
        def mes = data[1]
        def ano = data[2]
        $("form").date_day = dia
        // TODO internacionalizar
        String mesString = new DateFormatSymbols(Locale.US).getMonths()[Integer.parseInt(mes)-1]
        $("form").date_month = mesString
        $("form").date_year = ano
        $("input", name: "delete").click()
    }
}
