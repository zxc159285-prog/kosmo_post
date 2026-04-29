const all=document.getElementById("all")//전체선택 체크박스
const dlist=document.querySelectorAll(".dlist")//개별체크박스
const del=document.getElementsByClassName("del")//개별 삭제버튼
const allDel=document.getElementById("allDel")//선택삭제 버튼
const list=document.getElementById("list")

getList()

function getList(){
    fetch("cartList")
    .then(r=>r.text())
    .then(r=>{
        r=r.trim()
        list.innerHTML=r
    })
}

all.addEventListener("click",()=>{

    for(let d of dlist){
        
            d.checked=all.checked
     }
})

for (let d of dlist) {
    d.addEventListener("click",() =>{
        let allChecked = true;

        // 모든 개별 체크박스가 체크되어 있는지 확인
        for (let item of dlist) {
            if (!item.checked) {
                allChecked = false; // 하나라도 체크가 풀려있다면 false
                break;
            }
        }

        // 전체 선택 체크박스의 상태를 업데이트
        all.checked = allChecked;
    });
}
//////////////////////////////////////////////////////////////////

for(let d of del){
    

    d.addEventListener("click",()=>{
        
        let pn = d.previousElementSibling.getAttribute("data-pn")//형제엘리먼트 가져오기
        let p=new URLSearchParams
        p.append("productNum",pn)
        fetch("./delete",{
            method:"POST",
            body:p
        }).then(data=>data.text())
        .then(data=>{
            data=data.trim()           
            if(data>0){
                d.parentElement.parentElement.remove()
            }else{
                alert("삭제 실패")
            }
        })
    }
)}
///////////////////////////////////////////////////////////////
allDel.addEventListener("click",()=>{
    let p =new URLSearchParams
    for(let list of dlist){
        if(list.checked){
            let pn=list.getAttribute("data-pn")
           p.append("productNum",pn) 
        }

    }fetch("./delete",{
        method:"post",
        body:p
    }).then(r=>r.text())
    .then(r=>{
        r=r.trim()
        if(r>0){
            for(d of dlist){
                if(d.checked){
                d.parentElement.parentElement.remove()
                }
            }
            }
            });
        
    
    })
