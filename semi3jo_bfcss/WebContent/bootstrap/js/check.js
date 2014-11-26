
/*
 * obj : input type
 * msg : output message
 */
function isEmpty(obj, msg){
	if(obj.value == "") {
		alert(msg);
		obj.focus();
		return true;
	}
	else {
		return false;
	}
}

/*
 * ID check
 * obj : input type
 * allow : character, number, _ 
 */
function isId(obj){
	var value = obj.value;
	
	if(value.length == 0)
		return true;
	
	value = value.toUpperCase();

	for(var i=0; i<value.length; i++){
		if(!((value.charAt(i) >= 'A' && value.charAt(i) <= 'Z')
				|| (value.charAt(i) >= '0' && value.charAt(i) <='9')
				|| (value.charAt(i) == '_'))){
			alert("아이디는 영문과 숫자의 조합으로 만드세요.");
			return true;
			
		}
		else
			return false;
	}
}

/*
 * Email check
 * exist : @ .
 * obj : input type
 */
function isEmail(obj){
	var value = obj.value;
	
	if(value == ""){
		alert("email을 입력해주세요.");
		return true;
	}	
	
	var i = value.indexOf("@");
	if(i < 0){ //
		return true;
	}	
	
	i = value.indexOf(".");
	if(i < 0) {
		return true;
	}	
	return false;
}

/*
 * password validity check
 * obj1 : input type
 * obj2 : input type
 */
function isCorrect_pw(obj1, obj2){
	var data1 = obj1.value;
	var data2 = obj2.value;
	
	if(data1.length == 0 || data2.length == 0 || isLength4(obj1)){
		alert("패스워드를 입력해주세요.");
		obj1.focus();
		return true;
	}
	else{
		if(isAlphaNum(obj1)){
			alert("패스워드는 영문과 숫자의 조합으로 만드세요.");
			obj1.focus();
			return true;
		}
	}
	
	if(data1 != data2) {
		alert("패스워드가 일치하지 않습니다.");
		obj2.focus();
		return true;
	}
	
	return false;	
}

/*
 * password minimum length check
 * obj : input type
 */
function isLength4(obj){
	var pw = obj.value;
	
	if(pw.length < 4)
		return true;
	
	return false
}

/*
 * use characters mixed with number
 * obj : input type 
 */
function isAlphaNum(obj){
	var pw = obj.value;
	var num = pw.search(/[0-9]/);
    var alpha = pw.search(/[a-zA-Z]/);
    
    if(num < 0 || alpha < 0){         
        return true;
    }    
    return false;
}










