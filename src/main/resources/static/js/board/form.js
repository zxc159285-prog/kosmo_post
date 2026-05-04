console.log("form js")

const add=document.getElementById("add")
const result=document.getElementById("result")

let x = 1

const create=document.getElementById("create")

// create.addEventListener("click",()=>{
//     let form= new FormData()//비어있는 <form> </form>을 만든거랑 같음
//     form.append("boardTitle","ajax title") //<input type="text">
//     form.append("boardWriter","ajax Writer")
//     form.append("boardContents","ajax Contents")

//     fetch("./create",{
//         method:"POST",
//         body:form
//     })
//     .then(res=>res.text())
//     .then(res=>console.log(res))


// })
let count=result.getAttribute("data-file-size")

add.addEventListener("click",function(){
    
	
    if(count>4){
		alert("첨부파일은 최대 5개까지만 추가 가능합니다.") 
   
}
else{ let d = document.createElement("div")
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
count++
    result.append(d)}
})
result.addEventListener("click",function(e){
    let di= e.target.getAttribute("data-id")
    if(e.target.classList.contains("del")){
   document.getElementById(di).remove()
// e.target.parentElement.remove()
    }

})

