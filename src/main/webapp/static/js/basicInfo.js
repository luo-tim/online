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
  
    if(firstName===""){
        alert("名不能为空");
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
    if(phone===""){
        alert("手机号不能为空");
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
    if(firstName===""){
        alert("名不能为空");
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
    if(phone===""){
        alert("手机号不能为空");
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
    if(userName===""){
    alert("昵称不能为空");
    return false;
    }
    if(account===""){
        alert("账号不能为空");
        return false;
    }
    if(password===""){
        alert("密码不能为空");
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
    if(height===""){
        alert("身高不能为空");
        return false;
    }
    if(nation===""){
        alert("名族不能为空");
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
    if(email===""){
        alert("邮箱不能为空");
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