
function showAndroidToast(toast) {
			android.showToast(toast);
}

function pushCancel() {
    android.onCancelPressed();
}

function param2023() {
    var phoneNum=document.getElementById('phone2').value;
    alert(phoneNum);
    var url   = '2024.html?'+phoneNum;
    location.href= url;
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
/*
function receive(arg) {
/*
    //var receive_result = "";
    var receive_result = android.sendMessage();
    //$("#value1").val(receive_result);
    alert(receive_result);
    document.getElementById('value1').innerHTML = receive_result;

function fnValue()
    {
    var temp = location.href.split("?");
    var phoneNum=temp[1];
    document.getElementById('phonephone').value=phoneNum;
    }
