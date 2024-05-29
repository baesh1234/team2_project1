const commitBtn = document.querySelector("#commit_num2");
const commitList = document.querySelector("#commit_list");
const total = document.querySelector("h2>span");
const list = [];

function Comment(content){
    this.userid = "userid1";
    this.content = content;
    this.date = "2024-04-15";
}

function createRow(userid, content, date){
    const ul =document.createElement("ul");
    const li1 =document.createElement("li");
    const li2 =document.createElement("li");
    const li3 =document.createElement("li");

    ul.append(li1);
    ul.append(li2);
    ul.append(li3);

ul.setAttribute("class", "commit-row");
li1.setAttribute("class", "commit-id");
li2.setAttribute("class", "commit-content");
li3.setAttribute("class", "commit-date");

li1.innerHTML = userid;
li2.innerHTML = content;
li3.innerHTML = date;

    return ul;
}

function drawing() {
    commitList.innerHTML = "";
    for(let i=list.length-1; i >=0; i--){
        const row = createRow(list[i].userid, list[i].content, list[i].date);
        commitList.append(row);
    }
}

function totalRecord(){
    total.innerHTML = `(${list.length})`;
}


function commitBtnHandler(e){
    e.preventDefault();
const input = e.target.content;
if(input.value == ""){
    alert("내용을 입력해주세요.");
    return;
    }
    const commitObj = new Comment(input.value);
    list.push(commitObj);
    totalRecord();

    drawing();
    e.target.reset();
}

totalRecord();
commitBtn.addEventListener("submit", commitBtnHandler);











