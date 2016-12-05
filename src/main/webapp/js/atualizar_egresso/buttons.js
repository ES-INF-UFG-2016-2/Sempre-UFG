function releaseEditLock(buttonReference) {
    var lockButton = $(buttonReference);

    lockButton.attr("onClick", "saveModifications(this)");
    lockButton.attr("value", "Salvar");

    lockButton.prev().attr("disabled", false);
}

function saveModifications(buttonReference){
    var saveButton = $(buttonReference);

    saveButton.attr("onClick", "releaseEditLock(this)");
    saveButton.attr("value", "Atualizar");

    saveButton.prev().attr("disabled", true);
}
