package pages.residuo

import geb.Page

import java.text.DateFormatSymbols

/**
 * Created by pedro on 04/11/16.
 */
class CreateResiduo extends Page {

    static url = "/ResiduosQuimicos/residuo/create"

    static at = {
        title ==~ /Create Residuo/
    }

    def createResiduo(residuo, peso, data) {
        data = data.split("/")
        def dia = data[0]
        def mes = data[1]
        def ano = data[2]
        $("form").nome = residuo
        $("form").descricao = residuo
        $("form").peso = peso
        $("form").dataCadastro_day = dia
        // TODO internacionalizar
        String mesString = new DateFormatSymbols(Locale.US).getMonths()[Integer.parseInt(mes)-1]
        $("form").dataCadastro_month = mesString
        $("form").dataCadastro_year = ano
        $("input", name: "create").click()
    }

}