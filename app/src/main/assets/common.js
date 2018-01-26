
function showAndroidToast(toast) {
			android.showToast(toast);
}

function pushCancel() {
    android.onCancelPressed();
}

function onSubmit() {
    var result_value = $("#a1").val();
    android.receive(result_value);

    window.android.movePage();
}


function receive(arg) {
    return arg;
}


