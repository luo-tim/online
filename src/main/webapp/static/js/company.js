            //读取本地图片，并显示，同样可以操作其他文件
            function selectImage() {
                file = document.getElementById('file');
    
                url = window.URL.createObjectURL(file.files.item(0));
                document.getElementById('image').src = url;
                document.getElementById('image').style.opacity=1;
            }
            function postCompany(){
                let form=document.companyForm;
                let name=form.name.value;
                let leader=form.leader.value;
                let introduce=form.introduce.value;
                let address=form.address.value;
                let type=form.type.value;
                let treatment=form.treatment.value;
                let file=form.file.value;
                if(name===""){
                    alert("公司名称不能为空");
                    return false;
                }
                if(leader===""){
                    alert("高管介绍不能为空");
                    return false;
                }
                if(introduce===""){
                    alert("介绍不能为空");
                    return false;
                }
                
                if(address===""){
                    alert("地址不能为空");
                    return false;
                }
                if(type===""){
                    alert("类型不能为空");
                    return false;
                }
                if(treatment===""){
                    alert("福利不能为空");
                    return false;
                }
              
                if(file===""){
                    alert("logo不能为空");
                    return false;
                }
                return true;
            }