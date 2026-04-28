const name1=document.getElementById("name1")
const name2=document.getElementById("name2")
let c=[1,1,1,1,1,1]
name1.addEventListener("blur",function(){
    if(name1.value.trim()==""){
    name2.innerText="필수 입력"
    c[0]=0
    }
        else{
        c[0]=1
        }
    })
name1.addEventListener("focus",function(){
    name2.innerText=""
    
})

/////////////////////////////////////////////////
const username=document.getElementById("username")
const username2=document.getElementById("username2")
const pw=document.getElementById("pw")
const pw2=document.getElementById("pw2")
const pwcheck=document.getElementById("pwcheck")
const pwcheck2=document.getElementById("pwcheck2")
const username3=document.getElementById("username3")
username.addEventListener("change",function(){
    fetch(`./idCheck?username=${username.value}`)
    .then(res=>res.text())
    .then(res=>{
    if(res.trim()==='1'){
        username3.innerText="사용가능"
        
        
        c[1]=1

    }
    else{
        alert("중복된 아이디입니다")
        c[1]=0
    }

})

})
username.addEventListener("blur",function(){

   if(username.value.trim()==""){
    username2.innerText="필수입력"
    c[1]=0
   }else{
    c[1]=1
    }
})
username.addEventListener("focus",function(){
      username2.innerText=""
      
})
////////////////////////////////////////////////
pw.addEventListener("blur",function(){
    if(pw.value.length<6){
        pw2.innerText="최소 6글자 이상"
        c[2]=0
    }else{
        c[2]=1
    }
})
pw.addEventListener("change",function(){
    if(pw.value!=pwcheck.value){
        pwcheck.value=""
        pwcheck2.innerText="불일치"
        c[2]=0
    }
})

pw.addEventListener("focus",function(){
        pw2.innerText=""
})
///////////////////////////////////////////////
pwcheck.addEventListener("blur",function(){
    if(pw.value===pwcheck.value){
        pwcheck2.innerText="일치"
        c[3]=1
        if(pwcheck.value.length<6){
            c[3]=0
            pwcheck2.innerText="최소 6글자 이상"
        }
    }
    else{pwcheck2.innerText="불일치"
        pwcheck.value=""
        c[3]=0
    }
})
pwcheck.addEventListener("focus",function(){
        pwcheck2.innerText=""
})
/////////////////////////////////////////////////
const phone=document.getElementById("phone")
const emil=document.getElementById("email")
const birth=document.getElementById("birth")
const btn=document.getElementById("btn")

btn.addEventListener("click",function(){
    if(name1.value.trim()==""){
        console.log("false : 이름 미입력")
        
        return
    }
    if(username.value.trim()==""){
        console.log("false : 아이디 미입력")
        
        return
    }
    if(pw.value.trim()==""){
        console.log("false : 비밀번호 미입력")
        
        return
    }
    if(phone.value.trim()==""){
        console.log("false : 전화번호 미입력")
        c[3]=0
    }else{c[3]=1}

    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    // 조건: 비어있지 않으면서(AND) 정규표현식 패턴에 맞아야 함
    if (email.value.trim() !== "" && emailPattern.test(email.value)) {
        c[4] = 1; // 통과
        console.log("이메일 OK");
    } else {
        c[4] = 0; // 실패 (비어있거나 형식이 틀림)
        console.log("false : 이메일 미입력 또는 형식 오류");
    }
    
    if(birth.value.trim()==""){
        console.log("false : 생일 미입력")
        c[5]=0
    }else{c[5]=1}
    if (c.includes(0)==false){
        console.log("ok")
    }else{console.log("입력하신 내용을 확인하세요")}
     
})