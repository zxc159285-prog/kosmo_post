const reviewlist=document.getElementById("review_list")
const productNum=document.getElementById("cart")

getlist()
function getlist(){
    let pn=productNum.getAttribute("data-pn")
    fetch("/review/reviewlist?productNum=" + pn)
    .then(r=>r.text())
    .then(r=>{
        reviewlist.innerHTML=r.trim()
    })
}