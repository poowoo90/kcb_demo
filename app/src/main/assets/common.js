//----------------------------------------------------------------------------------------------------------------------------------------//
// 공통변수
//----------------------------------------------------------------------------------------------------------------------------------------//
/**
대출계좌          : loanAccount
약정금액          : loanLimitAmt
신용정보평가 금액 : CBAmt
통신정보평가 금액 : NBAmt
약정금리          : contractRate
신용정보평가 금리 : CBRate
통신정보평가 금리 : NBRate
직장명            : officeNm
연소득            : annualIncome
연체여부          : arrearsYN
연체금액          : arrearsAmt
**/

var SUZAN = {
			"phone":"01037890032",
			"loanAccount":"111222333333",
			"conAmt":10000,
			"CBAmt":0,
			"NBAmt":10000,
			"contractRate":3.0,
			"CBRate":0,
			"NBRate":3.0,
			"officeNm":"기아자동차",
			"annualIncome":40000,
			"arrearsYN":"N",
			"arrearsAmt":0
			};

var AMIE  = {
			"phone":"01027333486",
			"loanAccount":"111222333333",
			"conAmt":150000,
			"CBAmt":100000,
			"NBAmt":50000,
			"contractRate":1.3,
			"CBRate":2.5,
			"NBRate":1.2,
			"officeNm":"기아자동차",
			"annualIncome":40000,
			"arrearsYN":"N",
			"arrearsAmt":0
			};


var TOM   = {
			"phone":"01011563932",
			"loanAccount":"111222333333",
			"conAmt":80000,
			"CBAmt":60000,
			"NBAmt":20000,
			"contractRate":2.5,
			"CBRate":3.5,
			"NBRate":1.0,
			"officeNm":"기아자동차",
			"annualIncome":40000,
			"arrearsYN":"N",
			"arrearsAmt":0
			};

var BRIAN = {
			"phone":"01066324486",
			"loanAccount":"111222333333",
			"conAmt":15000,
			"CBAmt":0,
			"NBAmt":15000,
			"contractRate":4.1,
			"CBRate":0,
			"NBRate":4.1,
			"officeNm":"기아자동차",
			"annualIncome":40000,
			"arrearsYN":"N",
			"arrearsAmt":0
			};

var JADE  = {
			"phone":"01078662469",
			"loanAccount":"111222333333",
			"conAmt":60000,
			"CBAmt":0,
			"NBAmt":60000,
			"contractRate":2.1,
			"CBRate":0,
			"NBRate":2.1,
			"officeNm":"기아자동차",
			"annualIncome":40000,
			"arrearsYN":"N",
			"arrearsAmt":0
			};


var JOHN  = {
			"phone":"01044223348",
			"loanAccount":"111222333333",
			"conAmt":5000,
			"CBAmt":0,
			"NBAmt":5000,
			"contractRate":3.6,
			"CBRate":0,
			"NBRate":3.6,
			"officeNm":"기아자동차",
			"annualIncome":40000,
			"arrearsYN":"N",
			"arrearsAmt":0
			};

var CAL  = {
			"phone":"01011112222",
			"loanAccount":"111222333333",
			"conAmt":100000,
			"CBAmt":90000,
			"NBAmt":10000,
			"contractRate":3.0,
			"CBRate":3.6,
			"NBRate":0.6,
			"officeNm":"기아자동차",
			"annualIncome":40000,
			"arrearsYN":"N",
			"arrearsAmt":0
			};

/* 비활성화 메뉴 토스트메세지 보이기 */

function showAndroidToast(toast) {
			android.showToast(toast);
}

/* 취소 버튼에 대한 처리 */
function common_Cancel() {
    android.onCancelPressed();
}

/* 뒤로가기 버튼에 대한 처리 */
function common_goBack() {
    window.history.back();
}

/* 안드로이드에서 데이터 값 받아오기 */
function common_getJsonData() {
    window.android.getJsonData();
}

/* 페이지 이동, 데이터 보내기 */
function common_movePage(url, jsonData) {
    if(jsonData != null) {
    var name = jsonData.name;
        window.android.movePage(url, JSON.stringify(jsonData));
    } else {
        window.android.movePage(url, null);
    }
}

/* 해당하는 사용자 정보 보내기 */
function common_getUserData(name) {
    //alert("name : " + name);
    name = name.toUpperCase();
    if(name == 'SUZAN') {
        return SUZAN;
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
        return CAL;
    }
}

//----------------------------------------------------------------------------------------------------------------------------------------//
// TEST 용 함수들
//----------------------------------------------------------------------------------------------------------------------------------------//

/*

function pushCancel(arg) {
    //alert(arg);
    android.onCancelPressed(arg);
}

function onSubmit(url) {
    var result_value = $("#a1").val();
    android.receive(result_value);

    window.android.movePage(url);
}


function movePage(url) {
    window.android.movePage(url);
}

*/

