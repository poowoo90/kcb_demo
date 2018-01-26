
function showAndroidToast(toast) {
			android.showToast(toast);
}

function pushCancel() {
    android.onCancelPressed();
}

function onSubmit() {
    var result_value = $("#a1").val();
    android.receive(result_value);

    //window.android.sendMessage();
    window.android.movePage();
}
/*
function receive(arg) {
/*
    //var receive_result = "";
    var receive_result = android.sendMessage();
    //$("#value1").val(receive_result);
    alert(receive_result);
    document.getElementById('value1').innerHTML = receive_result;

    $("#value1").val(arg);

    alert(arg);
}
*/

