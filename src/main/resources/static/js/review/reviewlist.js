const reviewlist=document.getElementById("review_list")
const productNum=document.getElementById("cart")
const contents=document.getElementById("contents")
const add=document.getElementById("add")
const review_update=document.getElementById("review_update")
const review_delete=document.getElementById("review_delete")
const update_btn=document.getElementById("update_btn")
const contents_update=document.getElementById("contents_update")


let pn=productNum.getAttribute("data-pn")
getlist(pn)

update_btn.addEventListener("click",()=>{
    // 1. 아까 숨겨놓은 번호(n) 꺼내기
    let n = update_btn.getAttribute("data-num");
    // 2. 사용자가 수정한 내용(c) 꺼내기
    let c = document.getElementById("contents_update").value;
    let param=new URLSearchParams
    param.append("reviewContents",c)
    param.append("reviewNum",n)
    fetch("/review/update",{
        method:"POST",
        body:param
}).then(r=>r.text())
.then(r=>{
    r=r.trim()
    if(r>0){
        getlist(pn)
        contents_update.innerText=""
        // document.getElementById("close").click()
    }
    else{
        alert("수정실패")
    }
})
})

function getlist(pn){
    
    fetch("/review/reviewlist?productNum="+pn)
    .then(r=>r.text())
    .then(r=>{
        reviewlist.innerHTML=r.trim()
    })
}
////////////////////////////////////////////////////////////리스트
add.addEventListener("click",()=>{
    let p = new FormData();
    p.append("reviewContents",contents.value)
    p.append("productNum",pn)
    p.append("reviewStar",4)
    fetch("/review/create",{
        method:"POST",
        body:p
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim()
        if(r>0){
            alert("등록성공")
            
        }
        else{
            alert("등록실패")
        }
        getlist(pn)
        contents.innerText=""
    })
})
///////////////////////////////////////////////////////////등록과 리스트업데이트
reviewlist.addEventListener("click",(e)=>{

    if(e.target.classList.contains("review_delete")){
        let n= e.target.parentElement.getAttribute("data-review-num")
        console.log(n)
    let de=new URLSearchParams()
    de.append("reviewNum",n)
    fetch("/review/delete",{
        method:"POST",
        body:de
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim()
        if(r>0){
            alert("삭제성공")
            getlist(pn)
        }
        else{
            alert("삭제실패")
        }
        
    })
    
    }
    if(e.target.classList.contains("review_update")){
       let c=e.target.parentElement.parentElement.firstElementChild.innerText
         let n= e.target.parentElement.getAttribute("data-review-num")
       document.getElementById("contents_update").value=c
       document.getElementById("update_btn").setAttribute("data-num", n);
        
    }
    })