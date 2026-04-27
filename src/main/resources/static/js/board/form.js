console.log("form js")

const add=document.getElementById("add")
const result=document.getElementById("result")

let x = 1


add.addEventListener("click",function(){
    const count=result.children.length

    if(count<6){

    let d = document.createElement("div")
    let i = document.createElement("input")
    let b = document.createElement("button")
    
    b.type="button"
    b.innerText="X"
    b.setAttribute("data-id",`id${x}`)
    b.classList.add("del")

    i.type="file"
    i.name="attach"
    i.classList.add("form-control")
    d.id=`id${x}`
    d.append(i,b)

x++
    result.append(d)
}
else{ alert("첨부파일은 최대 5개까지만 추가 가능합니다.") }
})
result.addEventListener("click",function(e){
    let di= e.target.getAttribute("data-id")
    if(e.target.classList.contains("del")){
   document.getElementById(di).remove()
// e.target.parentElement.remove()
    }

})

