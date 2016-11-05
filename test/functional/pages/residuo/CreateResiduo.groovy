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
        $("#dataCadastro_day").click()
        $("#dataCadastro_day").find("option").find {it.value() == dia}.click()
        // TODO debugar a esoclha do mes
        //def mesString = new DateFormatSymbols().getMonths()[Integer.parseInt(mes)-1]
        //$("#dataCadastro_month").click()
        //$("#dataCadastro_month").find("option").find {mesString.equals(it.value())}.click()
        $("#dataCadastro_year").click()
        $("#dataCadastro_year").find("option").find {it.value() == ano}.click()
        $("input", name: "create").click()
    }

}



