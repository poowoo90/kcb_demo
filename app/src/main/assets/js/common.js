//----------------------------------------------------------------------------------------------------------------------------------------//
// 공통변수
//----------------------------------------------------------------------------------------------------------------------------------------//
/**
대출계좌          : loanAccount
약정금액          : conAmt
신용정보평가 금액 : CBAmt
통신정보평가 금액 : NBAmt
약정금리          : contractRate
신용정보평가 금리 : CBRate
통신정보평가 금리 : NBRate
직장명            : officeNm
연소득            : annualIncome
연체여부          : arrearsYN
연체금액          : arrearsAmt
통신정보 가점사유 : telReason
**/

var SUSAN = {
			"name":"SUSAN",
			"phone":"01037890032",
			"loanAccount":"162-34-23829,151-561-9419",
			"conAmt":10000,
			"CBAmt":"N/A",
			"NBAmt":10000,
			"contractRate":3.0,
			"CBRate":"N/A",
			"NBRate":3.0,
			"officeNm":"KT",
			"annualIncome":20000,
			"arrearsYN":"1",
			"arrearsAmt":110,
			"telReason":"Faithful payer (Telecom service fare)"
			};

var AMIE  = {
			"name":"AMIE",
			"phone":"01027333486",
			"loanAccount":"143-247-8259,171-647-5254",
			"conAmt":50000,
			"CBAmt":30000,
			"NBAmt":20000,
			"contractRate":1.3,
			"CBRate":2.5,
			"NBRate":"▽ 1.2",
			"officeNm":"N/A",
			"annualIncome": 50000,
			"arrearsYN":"NONE",
			"arrearsAmt":"0",
			"telReason":"No default (Telecom service fare)"
			};


var TOM   = {
			"name":"TOM",
			"phone":"01011563932",
			"loanAccount":"432-116-2896, 132-216-2774",
			"conAmt":30000,
			"CBAmt":10000,
			"NBAmt":20000,
			"contractRate":2.5,
			"CBRate":3.5,
			"NBRate":"▽ 1.0",
			"officeNm":"N/A",
			"annualIncome": 30000,
			"arrearsYN":"NONE",
			"arrearsAmt":"0",
			"telReason":"Long-term membership for telecom service"
			};

var BRIAN = {
			"name":"BRIAN",
			"phone":"01066324486",
			"loanAccount":"145-442-1616, 145-167-2111",
			"conAmt":10000,
			"CBAmt":"N/A",
			"NBAmt":10000,
			"contractRate":4.1,
			"CBRate":"N/A",
			"NBRate":4.1,
			"officeNm":"N/A",
			"annualIncome": "N/A",
			"arrearsYN":"N/A",
			"arrearsAmt":"N/A",
			"telReason":"Active usage of micro-payment service by telecom"
			};

var JADE  = {
			"name":"JADE",
			"phone":"01078662469",
			"loanAccount":"185-356-2789, 164-915-9284",
			"conAmt":15000,
			"CBAmt":"N/A",
			"NBAmt":15000,
			"contractRate":2.1,
			"CBRate":"N/A",
			"NBRate":2.1,
			"officeNm":"N/A",
			"annualIncome": "N/A",
			"arrearsYN":"N/A",
			"arrearsAmt":"N/A",
			"telReason":"Usage of family package by telecom"
			};


var JOHN  = {
			"name":"JOHN",
			"phone":"01044223348",
			"loanAccount":"332-690-1983, 132-615-1484",
			"conAmt":5000,
			"CBAmt":"N/A",
			"NBAmt":5000,
			"contractRate":3.6,
			"CBRate":"N/A",
			"NBRate":3.6,
			"officeNm":"N/A",
			"annualIncome": "N/A",
			"arrearsYN":"N/A",
			"arrearsAmt":"N/A",
			"telReason":"Faithful payer (Telecom service fare)"
			};

var SAM  = {
			"name":"SAM",
			"phone":"01037894487",
			"loanAccount":"166-222-1839, 135-422-1844",
			"conAmt":10000,
			"CBAmt":"N/A",
			"NBAmt":10000,
			"contractRate":3.8,
			"CBRate":"N/A",
			"NBRate":3.8,
			"officeNm":"KCB",
			"annualIncome":35000,
			"arrearsYN":"2",
			"arrearsAmt":600,
			"telReason":"Faithful payer (Telecom service fare)"
			};

//----------------------------------------------------------------------------------------------------------------------------------------//
// 공통함수
//----------------------------------------------------------------------------------------------------------------------------------------//


/**
 * 뒤로가기
**/
function common_goBack() {
    window.history.back();
}


/**
 * 해당하는 사용자 정보 보내기
**/
function common_getUserData(name) {
    //alert("name : " + name);
    name = name.toUpperCase();
    if(name == 'SUSAN') {
        return SUSAN;
    } else if(name == 'AMIE') {
        return AMIE;
    } else if(name == 'TOM') {
        return TOM;
    } else if(name == 'BRIAN') {
        return BRIAN;
    } else if(name == 'JADE') {
        return JADE;
    } else if(name == 'JOHN') {
        return JOHN;
    } else {
        return SAM;
    }
}

function common_numberWithCommas(x) {
   return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function common_delay(gap) {
    var then, now;
    then = new Date().getTime();
    now = then;
    while ((now - then) < gap) {
        now = new Date().getTime();  // 현재시간을 읽어 함수를 불러들인 시간과의 차를 이용하여 처리
    }
}

//----------------------------------------------------------------------------------------------------------------------------------------//
// Native Call 함수
//----------------------------------------------------------------------------------------------------------------------------------------//

/**
 * WebBackForwardList 의 index가 1인 곳으로 이동
**/
function common_cancel() {
    android.onCancelPressed();
}


function common_movePage(url, jsonData) {

    common_startLoding();

    if(url == '2013.html' || url == '2023.html' || url == '2024.html' || url == '2025.html' ) {
        common_delay(2000);
    } else if (url == '1001.html' || url == '2001.html') {
        common_delay(500);
    } else {
        common_delay(1000);
    }

    if(jsonData != null) {
        window.android.movePage(url, JSON.stringify(jsonData));
    } else {
        window.android.movePage(url, null);
    }
}

function common_setJsonDataInit() {
    window.android.setJsonDataInit();
}


function common_getJsonData() {
    window.android.getJsonData();
}


function common_stopLoding() {
    window.android.stopLoding();
}

function common_startLoding() {
    window.android.startLoding();
}

function common_hideKeyboard() {
    window.android.keyboardHide();
}


//----------------------------------------------------------------------------------------------------------------------------------------//
// Native Call Back 함수
//----------------------------------------------------------------------------------------------------------------------------------------//


//----------------------------------------------------------------------------------------------------------------------------------------//
// TEST 용 함수들
//----------------------------------------------------------------------------------------------------------------------------------------//

function showAndroidToast(toast) {
    window.android.showToast(toast);
}

function Test_onSubmit() {
    var result_value = $("#a1").val();
    android.receive(result_value);
    window.android.movePage();
}



//----------------------------------------------------------------------------------------------------------------------------------------//
// 메뉴 슬라이드
//----------------------------------------------------------------------------------------------------------------------------------------//
function openNav() {
   /* document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";*/
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.body.style.backgroundColor = "white";
}