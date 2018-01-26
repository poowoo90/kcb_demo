
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
function to2013() {
    var name=document.getElementById('name').value;
    var idNumber=document.getElementById('idNumber').value;
    var tel1=document.getElementById('tel1').value;
    var tel2=document.getElementById('tel2').value;
    var tel3=document.getElementById('tel3').value;
    var url = '2013.html?'+name+'&'+idNumber+'&'+tel1+'&'+tel2+'&'+tel3;
    location.href=url;
}


function receive(arg) {
    return arg;
}


