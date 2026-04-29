const all = document.getElementById("all"); // 전체선택 체크박스
const allDel = document.getElementById("allDel"); // 선택삭제 버튼
const list = document.getElementById("list"); // 리스트가 담길 부모 요소

// 1. 초기 리스트 로딩
getList();

function getList() {
    fetch("cartlist") // 404가 뜨면 "./cartlist" 등으로 경로 확인 필요
        .then(r => r.text())
        .then(r => {
            list.innerHTML = r.trim();
        })
        
}

// 2. [전체 선택] 체크박스 로직
all.addEventListener("click", () => {
    // 클릭하는 시점에 존재하는 .dlist 요소들을 새로 가져와야 함
    const dlist = document.querySelectorAll(".dlist");
    for (let d of dlist) {
        d.checked = all.checked;
    }
});

// 3. [리스트 내부 클릭] 이벤트 위임 (개별 삭제 + 개별 체크박스 동기화)
// ... (위쪽 코드 동일)

// 3. [리스트 내부 클릭] 개별 삭제
list.addEventListener("click", (e) => {
    if (e.target.classList.contains("del")) {
        const btn = e.target;
        let pn = btn.previousElementSibling.getAttribute("data-pn");
        let p = new URLSearchParams();
        p.append("productNum", pn);

        fetch("./delete", { method: "POST", body: p })
        .then(r => r.text())
        .then(r => {
            if (r.trim() > 0) {
                // 핵심: 직접 지우지 말고 서버에서 다시 받아오기!
                getList(); 
                all.checked = false; // 전체선택 버튼 초기화
            } else {
                alert("삭제 실패");
            }
        });
    }
    
    // 개별 체크박스 로직 (이건 그대로 유지)
    if (e.target.classList.contains("dlist")) {
        const chs = document.querySelectorAll(".dlist");
        all.checked = Array.from(chs).every(c => c.checked);
    }
});

// 4. [선택 삭제] 로직
allDel.addEventListener("click", () => {
    const dlist = document.querySelectorAll(".dlist");
    let p = new URLSearchParams();
    let checkCount = 0;

    dlist.forEach(d => {
        if (d.checked) {
            p.append("productNum", d.getAttribute("data-pn"));
            checkCount++;
        }
    });

    if (checkCount === 0) return alert("항목을 선택해주세요.");

    if (confirm(checkCount + "개를 삭제하시겠습니까?")) {
        fetch("./delete", { method: "POST", body: p })
        .then(r => r.text())
        .then(r => {
            if (r.trim() > 0) {
                // 여기서도 새로고침 대신 getList 호출!
                getList();
                all.checked = false;
            }
        });
    }
});