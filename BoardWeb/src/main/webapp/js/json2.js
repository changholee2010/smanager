/**
 * json2.js
 */
document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();

let json = `[{"id":1,"first_name":"Mariann","last_name":"Penburton","email":"mpenburton0@sciencedaily.com","gender":"Female","salary":4210},
{"id":2,"first_name":"Jacinthe","last_name":"Paris","email":"jparis1@paypal.com","gender":"Female","salary":4210},
{"id":3,"first_name":"Philis","last_name":"Toten","email":"ptoten2@meetup.com","gender":"Female","salary":8124},
{"id":4,"first_name":"Jozef","last_name":"Ogle","email":"jogle3@businessinsider.com","gender":"Male","salary":9339},
{"id":5,"first_name":"Neddy","last_name":"Kellog","email":"nkellog4@bloglovin.com","gender":"Male","salary":2622},
{"id":6,"first_name":"Francisco","last_name":"Headly","email":"fheadly5@google.com.hk","gender":"Male","salary":1096},
{"id":7,"first_name":"Katlin","last_name":"Simenel","email":"ksimenel6@google.es","gender":"Female","salary":2915},
{"id":8,"first_name":"Anissa","last_name":"Naulty","email":"anaulty7@sina.com.cn","gender":"Female","salary":8127},
{"id":9,"first_name":"Josias","last_name":"Rapport","email":"jrapport8@bloglovin.com","gender":"Male","salary":7830},
{"id":10,"first_name":"Miles","last_name":"Floch","email":"mfloch9@angelfire.com","gender":"Male","salary":4905},
{"id":11,"first_name":"Jason","last_name":"Duke","email":"jdukea@hubpages.com","gender":"Male","salary":7008},
{"id":12,"first_name":"Elora","last_name":"Turn","email":"eturnb@ameblo.jp","gender":"Female","salary":3662},
{"id":13,"first_name":"Cosetta","last_name":"Musprat","email":"cmuspratc@loc.gov","gender":"Female","salary":8731},
{"id":14,"first_name":"Moyra","last_name":"Sherston","email":"msherstond@bloglines.com","gender":"Non-binary","salary":1023},
{"id":15,"first_name":"Talyah","last_name":"Fidgeon","email":"tfidgeone@house.gov","gender":"Female","salary":9775},
{"id":16,"first_name":"Nariko","last_name":"Phelipeaux","email":"nphelipeauxf@geocities.jp","gender":"Polygender","salary":6697},
{"id":17,"first_name":"Martie","last_name":"Obbard","email":"mobbardg@goo.ne.jp","gender":"Female","salary":4475},
{"id":18,"first_name":"Leroy","last_name":"Seegar","email":"lseegarh@latimes.com","gender":"Male","salary":3615},
{"id":19,"first_name":"Nicolai","last_name":"Lawry","email":"nlawryi@theglobeandmail.com","gender":"Male","salary":6231},
{"id":20,"first_name":"Hardy","last_name":"Mobbs","email":"hmobbsj@telegraph.co.uk","gender":"Male","salary":2155}]`;


let employees = JSON.parse(json);
console.log(employees);

document.querySelector('#searchGender').addEventListener('change', function(e) {
	initList();
})

function initList() {
	let target = document.getElementById('empList');
	target.innerHTML = '';
	let selValue = document.querySelector('#searchGender').value;
	employees.forEach(emp => {
		if (selValue == 'All' || emp.gender == selValue) {
			target.appendChild(makeRow(emp));
		}
	});
}
initList();

// 사원정보 => row 생성.
function makeRow(emp = {}) {
	let fields = ['id', 'first_name', 'last_name', 'salary'];
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = emp[field];
		tr.appendChild(td);
	})
	return tr;
}


