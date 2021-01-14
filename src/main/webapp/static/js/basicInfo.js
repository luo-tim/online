  // 判断是否为邮箱地址
function isEmail(str) {
    //定义判断邮箱地址的正则表达式
    var re = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    if (re.test(str) != true) {
        return false;
    } else {
        return true;
    }
}
function validateAccount(account){
    if (account.length <= 18 && account.length>=6) {
        var reg = /^[0-9a-zA-Z]+$/;
        if (reg.test(account) != true) {
            return false;
        } else {
            return true
        }
    }else{
        return false;
    }
}
//验证密码
function validatePassword(password){
	
  if(password.length<=18){
	    //密码必须为6-18位字母、数字
		let reg=/^(?![^a-zA-Z]+$)(?!\D+$)/;  //(?![^a-zA-Z]+$)匹配任何其后没有紧接指定字符串[^a-zA-Z]（就是非字母）的字符串。就是匹配后面紧接字母的字符串。
    if(reg.test(password)!=true){
        return false;
    }else{
        return true
    }
  }else{
	  return false;
  }
}
 // 判断是否超出规定长度
function isValidLength(chars, len) {
    if (chars.length <= len) {
        return true;
    }
    return false;
}
 // 判断是否为正确的手机号码格式
function isPhone(tel) {
    //定义判断电话号码的正则表达式
    var strTemp = /^1[3|4|5|6|7|8|9][0-9]{9}$/;
    if (strTemp.test(tel)) {
        return true;
    }
    return false;
}

  // 判断是否为身份证号
    function isLeagalIdNum(id) {
        var isIDLength = (id.length === 15 || id.length === 18);
        var num = ['0', '1', '2' ,'3', '4', '5', '6', '7', '8', '9'];
        var numx = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9','x','X'];//验证第18位可能字符
        var IDArray = id.split('');
      //  console.log(IDArray);
        var isIDNumber = true;
        var j = 0;
        for (j = 0; j < 17; j++) {
            if (!num.includes(IDArray[j])) {
                isIDNumber = false;
            }
        }
        if (!numx.includes(IDArray[17])){
            isIDNumber = false;
        }
       // console.log(isIDNumber);

        //前两位数字的合法范围
        var legalProvinceId = [11, 12, 13, 14, 15, 21, 22, 23, 31, 32, 33, 34, 35, 36, 37, 41, 42, 43, 44, 45, 46,
            50, 51, 52, 53, 54, 61, 62, 63, 64, 65];
        var isLegalProvinceId = legalProvinceId.includes(parseInt(id.substring(0, 2))); //前两位省份码是否合法
        //3，4位表示城市代码，最大为70
        var isLegalCityId = (parseInt(id.substring(2, 4)) <= 70 && parseInt(id.substring(2, 4)) >= 1); //  3、4位城市码是否合法

        //第5、6位代表城市的区，范围01 ~ 99；判断是否大于0 就好
        var islegalAreaId = (parseInt(id.substring(4, 6)) > 0)

        // 第7-10位出生年份是否合法 (设置范围为 1900年至现在年份,120岁的应该不会玩手机吧 --)
        var isLegalBirthYear = (parseInt(id.substring(6, 10)) <= new Date().getFullYear() && parseInt(id.substring(
            6, 10)) >= 1900);

        // 判断11、12位月份是否合法
        var isLegalBirthMonth = (parseInt(id.substring(10, 12)) <= 12 && parseInt(id.substring(10, 12)) >= 1);
        if (parseInt(id.substring(6, 10)) == new Date().getFullYear() && parseInt(id.substring(10, 12)) > (
            new Date().getMonth() + 1)) //判断所填月份是否大于当前月份
        {
            isLegalBirthMonth = false;
		}
 		//判断13、14位日期是否合法
 		let bigMonth = [1,3,4,7,8,10,12];  //分月份大小进行判断
        var isLegalBirthDay = false;
        if (bigMonth.includes(parseInt(id.substring(10, 12)))) {
			isLegalBirthDay = (parseInt(id.substring(12, 14)) >= 1 && parseInt(id.substring(12, 14)) <= 31)
	}else{
	if (parseInt(id.substring(10, 12)) == 2) {    //二月最多29天，这里就不判断闰年平年了
                isLegalBirthDay = (parseInt(id.substring(12, 14)) >= 1 && parseInt(id.substring(12, 14)) <= 29);
            } else {
                isLegalBirthDay = (parseInt(id.substring(12, 14)) >= 1 && parseInt(id.substring(12, 14)) <= 30);
            }
        }

        if (parseInt(id.substring(6, 10)) == new Date().getFullYear() && parseInt(id.substring(6, 10)) == new Date()
            .getMonth() && parseInt(id.substring(10, 12)) > new Date().getDate()) //判断所填月份是否大于当前月份
            isLegalBirthDay = false;

        return isIDLength && isIDNumber && isLegalProvinceId && isLegalCityId && islegalAreaId && isLegalBirthYear &&
            isLegalBirthMonth && isLegalBirthDay;
    }

function postWorker(){
    let workerForm=document.workerForm;
    let lastName=workerForm.lastName.value;
    let firstName=workerForm.firstName.value;
    let birth=workerForm.birth.value;
    let IDNumber=workerForm.IDNumber.value;
    let phone=workerForm.phone.value;
    let email=workerForm.email.value;
    let sex=workerForm.sex.value;
    if(lastName===""){
   
        alert("姓不能为空");
        return false;
    }
  	if(!isValidLength(lastName,10)){
        alert("请输入正确长度的“姓”")
        return false;
    }
    if(firstName===""){
        alert("名不能为空");
        return false;
    }
   if (!isValidLength(firstName, 10)) {
        alert("请输入正确长度的“名”")
        return false;
    }
    if(birth===""){
        alert("出生日期不能为空");
        return false;
    }
    if(IDNumber===""){
        alert("身份证号不为空");
        return false;
    }
    if(!isLeagalIdNum(IDNumber)){
        alert("请输入正确的身份证号");
        return false;
    }
    if(phone===""){
        alert("手机号不能为空");
        return false;
    }
    if(!isPhone(phone)){
        alert("请输入正确的手机号");
        return false;
    }
    if(email===""){
        alert("电子邮箱不能为空");
        return false;
    }
    if(!isEmail(email)){
        alert("请输入正确的电子邮箱格式");
        return false;
    }
    if(sex===""){
        alert("性别不能为空");
        return false;
    }
    return true;

}
function postBoss(){
    let bossForm=document.bossForm;
    let lastName=bossForm.lastName.value;
    let firstName=bossForm.firstName.value;
    let birth=bossForm.birth.value;
    let IDNumber=bossForm.IDNumber.value;
    let phone=bossForm.phone.value;
    let email=bossForm.email.value;
    let sex=bossForm.sex.value;
    let company=bossForm.company.value;
    if(lastName===""){
        alert("姓不能为空");
        return false;
    }
    if(!isValidLength(lastName,10)){
        alert("请输入正确长度的“姓”")
        return false;
    }
    if(firstName===""){
        alert("名不能为空");
        return false;
    }
    if (!isValidLength(firstName, 10)) {
        alert("请输入正确长度的“名”")
        return false;
    }
    if(birth===""){
        alert("出生日期不能为空");
        return false;
    }
    if(IDNumber===""){
        alert("身份证号不为空");
        return false;
    }
    if(!isLeagalIdNum(IDNumber)){
        alert("请输入正确的身份证号");
        return false;
    }
    if(phone===""){
        alert("手机号不能为空");
        return false;
    }
    if(!isPhone(phone)){
        alert("请输入正确的手机号");
        return false;
    }
    if(email===""){
        alert("电子邮箱不能为空");
        return false;
    }
    if(sex===""){
        alert("性别不能为空");
        return false;
    }
    if(!isEmail(email)){
        alert("请输入正确的电子邮箱格式");
        return false;
    }
    if(company===""){
        alert("公司不能为空");
        return false;
    }
  return true;
}
function postUser(){
    let userForm=document.userForm;	
    let userName=userForm.userName.value;
    let account=userForm.account.value;
    let password=userForm.password.value;
    let confirmPassword = userForm.confirmPassword.value;
     
    if(userName===""){
    alert("昵称不能为空");
    return false;
    }
    if(account===""){
        alert("账号不能为空");
        return false;
    }
    if(!validateAccount(account)){
     	alert("账号格式错误");
        return false;
    }
    if(password===""){
        alert("密码不能为空");
        return false;
    }
    if(!validatePassword(password)){
     alert("密码格式错误");
        return false;
    }
     if(password != confirmPassword){
        alert("两次密码不相同");
        return false;
    }
    return true;
}

function postResume(){

    let resumeForm=document.resumeForm;
    let name=resumeForm.name.value;
   
    let height=resumeForm.height.value;
    let nation=resumeForm.nation.value;
    let birth=resumeForm.birth.value;
    let education=resumeForm.education.value;
    let sex=resumeForm.sex.value;
    let school =resumeForm.school.value;
    let politic=resumeForm.politic.value;
    let phone =resumeForm.phone.value;
    let email=resumeForm.email.value;
    let address=resumeForm.address.value;
    let educationbg=resumeForm.educationbg.value;
    let practice=resumeForm.practice.value;
    let campus=resumeForm.campus.value;
    let skills=resumeForm.skills.value;
    let self=resumeForm.self.value;
    if(name===""){
        alert("名字不能为空");
        return false;
    }
  
    if(!isValidLength(name,20)){
        alert("请输入正确长度的名字");
        return false;
    }
    if(height===""){
        alert("身高不能为空");
        return false;
    }
    if(nation===""){
        alert("民族不能为空");
        return false;
    }
    if(birth===""){
        alert("出生日期不能为空");
        return false;
    }
    if(education===""){
        alert("学历不能为空");
        return false;
    }
    if(sex===""){
        alert("性别不能为空");
        return false;
    }
    if(school===""){
        alert("学校不能为空");
        return false;
    }
    if(politic===""){
        alert("政治面貌不能为空");
        return false;
    }
    if(phone===""){
        alert("手机号不能为空");
        return false;
    }
    if(!isPhone(phone)){
        alert("请输入正确的手机号");
        return false;
    }
    if(email===""){
        alert("邮箱不能为空");
        return false;
    }
    if(!isEmail(email)){
        alert("请输入正确的电子邮箱格式");
        return false;
    }
    if(address===""){
        alert("地址不能为空");
        return false;
    }
    if(educationbg===""){
        alert("教育背景不能为空");
        return false;
    }
    if(practice===""){
        alert("实习经历不能为空");
        return false;
    }
    if(campus===""){
        alert("校园经历不能为空");
        return false;
    }
    if(self===""){
        alert("自我评价不能为空");
        return false;
    }
    if(skills===""){
        alert("技能证书不能为空");
        return false;
    }
    return true;
};

function postAccount(){

	let accountForm=document.accountForm;
    let oldPassword=accountForm.oldPassword.value;
    let password=accountForm.password.value;
    let confirmPassword=accountForm.confirmPassword.value;
    let account=accountForm.account.value;
    if(account===""){
        alert("账号不能为空");
        return false;
    }
    if(oldPassword===""){
        alert("旧密码不能为空");
        return false;
    }
    if(password===""){
        alert("新密码不能为空");
        return false;
    }
      if(!validatePassword(password)){
     alert("新密码格式错误");
        return false;
    }
    if(confirmPassword != password){
        alert("两个新密码不一致");
        return false;
    }
    
    return true;
};


function postform1() {
    let form1 = document.form1;
    let account = form1.account.value;

    if (account === "") {
        alert("账号不能为空");
        return false;
    }
    return true;
}

function postform2() {
    let form2 = document.form2;
    let identifyingCode = form2.identifyingCode.value;

    if (identifyingCode === "") {
        alert("验证码不能为空");
        return false;
    }
    return true;
}

function postform3() {
    let form3 = document.form3;
    let newPassword = form3.newPassword.value;
    let confirmPassword = form3.confirmPassword.value;
    if (newPassword === "") {
        alert("验证码不能为空");
        return false;
    }
    if (!validatePassword(newPassword)) {
        alert("新密码格式错误");
        return false;
    }
    if (confirmPassword != newPassword) {
        alert("两个新密码不一致");
        return false;
    }
    return true;
}