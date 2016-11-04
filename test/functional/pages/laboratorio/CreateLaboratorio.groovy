package pages.laboratorio

import geb.Page

/**
 * Created by pedro on 04/11/16.
 */
class CreateLaboratorio extends Page {

    static url = "/ResiduosQuimicos/laboratorio/create"

    static at = {
        title ==~ /Create Laboratorio/
    }

    def createLaboratorio() {
        $("input", name: "create").click()
    }
}
