
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

function fnValue()
    {
    var temp = location.href.split("?");
    var phoneNum=temp[1];
    document.getElementById('phonephone').value=phoneNum;
    }
