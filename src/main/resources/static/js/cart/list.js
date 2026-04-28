const all=document.getElementById("all")//전체선택 체크박스
const dlist=document.getElementsByClassName("dlist")//개별체크박스


all.addEventListener("click",()=>{

    for(let d of dlist){
        
            d.checked=all.checked
     }
})

for (let d of dlist) {
    d.addEventListener("click", () => {
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