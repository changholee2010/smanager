/**
 * array1.js
 */

// thead에 있는 체크박스 이벤트 등록.
document.querySelector('div.container-fluid>table>thead input[type="checkbox"]')//
	.addEventListener('change', changeFnc);

function changeFnc(e) {

	// 찾으려는 대상 체크박스.
	document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]')//
		.forEach(function(item) {
			item.checked = e.target.checked;
		})
} // end of changeFnc(e).

// 수정 버튼에 클릭이벤트.
document.getElementById('modBtn').addEventListener('click', modBtnFnc);

// modBtnFnc 이벤트핸들러.
function modBtnFnc(e) {
	// 화면상에 있는 tr 을 대상으로 변경을 해야하니까....
	document.querySelectorAll('#list tr').forEach(function(tr) {
		//tr의 첫번째 자식요소의 innerHTML : 이름. 비교 fname의 value 같을때
		//faddress, height의 value를 tr의 두번째, 세번째 자식요소의 innerHTML에 대입.
		if (tr.children[0].innerHTML == document.querySelector('#fname').value) {
			tr.children[1].innerHTML = document.querySelector('#faddress').value;
			tr.children[2].innerHTML = document.querySelector('#height').value;
		}
	});

}; // end of modBtnFnc(e)

// 등록 버튼에 클릭이벤트 추가.
document.getElementById('addBtn').addEventListener('click', addBtnFnc);

// addBtnFnc 이벤트핸들러.
function addBtnFnc(e) {
	let name = document.getElementById('fname').value;
	let address = document.getElementById('faddress').value;
	let height = document.getElementById('height').value;

	if (!name || !address || !height) {
		alert('값을 입력하세요.');
		return;
	}

	let friend = { name, address, height }

	// tr만든는 부분.
	let tr = makeTr(friend);
	list.appendChild(tr);

	alert('OK');

	fname.value = '';
	faddress.value = '';
	document.getElementById('height').value = '';
};


const friends = [
	{ name: "홍길동", address: "대구 100번지", height: 170 },
	{ name: "김민규", address: "대전 200번지", height: 175 },
	{ name: "이성윤", address: "인천 300번지", height: 180 }
]

makeList();
function makeList() {
	// <tr><td>값1</td><td>값2</td><td>값3</td><td><button>삭제</button></td></tr>
	friends.forEach(function(friend) {
		let tr = makeTr(friend);

		document.getElementById('list').appendChild(tr);
	});

}

function detailCallback(e) {
	e.stopPropagation();
	let tr = e.target.parentElement; // 이벤트를 대상으로 tr영역을 찾아햠.
	// this : 1) 함수영역세 window 2) 이벤트 대상 3)객체에서는 객체.
	tr = this;
	document.getElementById('fname').value = tr.children[0].innerHTML;
	document.getElementById('faddress').value = tr.children[1].innerHTML;
	document.getElementById('height').value = tr.children[2].innerHTML;

} // end of detailCallback.

// friend => tr 생성.
function makeTr(friend = { name: 'Hong', address: 'Seoul', height: 170 }) {

	// tr만든는 부분.
	let tr = document.createElement('tr');
	tr.addEventListener('click', detailCallback, false);
	//	tr.addEventListener('mouseover', detailCallback);

	// td와 친구정보를 생성.
	for (let prop in friend) {
		let td = document.createElement('td');
		td.innerHTML = friend[prop];
		tr.appendChild(td);
	}

	// 삭제버튼 생성.
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('class', 'btn btn-danger'); // <button class="btn btn-danger">삭제</button>
	// 삭제이벤트 등록.
	btn.addEventListener('click', function(e) {
		e.stopPropagation(); // click : button > td > tr > table.....
		e.target.parentElement.parentElement.remove();
	}, false);
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);

	// 체크박스생성. 완성된 html은 --> <td><input type="checkbox"></td> 의 상위요소 tr에 붙이기.
	td = document.createElement('td');
	let inp = document.createElement('input');
	inp.setAttribute('type', 'checkbox');
	inp.addEventListener('click', function(e) { e.stopPropagation(); })

	//체크박스에 이벤트등록.
	inp.addEventListener('change', function(e) {
		// thead의 체크박스 변경하기.
		let allCnt = document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]');
		let chkCnt = document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]:checked');
		let theadCheck = document.querySelector('div.container-fluid>table>thead input[type="checkbox"]');
		if (allCnt.length == chkCnt.length) {
			theadCheck.checked = true;
		} else {
			theadCheck.checked = false;
		}
	});

	td.appendChild(inp);
	tr.appendChild(td);

	return tr;
} // end of makeTr.
