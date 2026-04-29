/**
 * 
 */

const cart= document.getElementById("cart")

cart.addEventListener("click",()=>{
   let pn= cart.getAttribute("data-pn")
   let param= new URLSearchParams()
   param.append("productNum",pn)


    console.log(pn)
    fetch("../cart/create",{
        method:"POST",
        body:param
        
    })
    .then(r=>r.text())
    .then(r=>{
    //등록 성공이면 장바구니로 이동 y or no
    r= r.trim()
    if(r>0){
       let move=confirm("장바구니로 이동할까요?")
       if(move){
        location.href="../cart/list"
       }
    }else{}
})
})