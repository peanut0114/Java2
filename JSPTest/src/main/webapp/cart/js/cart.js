/**
 * cart.js
 * JSPTest/cart/cart.jsp
 */

function cartList(result){
	console.log(result)		//(2) [{...}, {...}]
	
	let cartTemplate = document.querySelector("#template");		//id로 위치 잡아 변수에 넣어줌
	let basket = document.querySelector("#basket");
	
	for (let i=0; i<result.length ; i++){
		let rowDiv = cartTemplate.childNodes[1].cloneNode(true);//div 태그의 첫번째 div.row data 복사
		console.log(rowDiv);	//찍어서 자식태그를 봅시다
		rowDiv.setAttribute('data-id',result[i].no);//속성추가(ajax의 no변수)
		rowDiv.querySelector('div.pname span').textContent = result[i].productNm;
		//class가 basketprice인 div 하위의 input태그 중 이름이 p_price 의 값 설정
		rowDiv.querySelector('div.basketprice input[name="p_price"]').value = result[i].price;
		rowDiv.querySelector('div.basketprice').childNodes[2].textContent = result[i].price;
		rowDiv.querySelector('div.num input').value = result[i].qty;
		rowDiv.querySelector('div.sum').textContent = (result[i].price*result[i].qty);
		//같은 타입 중 첫번째 input태그
		rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('id','p_num'+result[i].no);
		rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('onkeyup','javascript:changePnum('+result[i].no+')');
		rowDiv.querySelector('div.num>div.updown>span:nth-of-type(1)').setAttribute('onclick','javascript:changePnum('+result[i].no+')');
		rowDiv.querySelector('div.num>div.updown>span:nth-of-type(2)').setAttribute('onclick','javascript:changePnum('+result[i].no+')');
		
		basket.append(rowDiv);
	}
}

//페이지가 로딩되면 제일 먼저 실행되는 함수 정의
function makeList() {
	// ajax. XMLHttpRequest. 페이지 호출(json 형태 넘겨주게 해놓음)
	fetch('../cartList.do')
	// 호출 성공, 정상적 실행시 then
	// 호출 실패, 예외 발생시 catch
	.then(result =>	result.json())		//넘겨받은 json 형태 값 리턴
	.then(cartList)						//첫번째 then에서 매개값이 자동으로 넘어온다 (result)
	.catch(err => console.log(err))		
}

function changePnum(no){
	let currentItem = event.target;	//이벤트 대상
	let currentQty = currentItem.closest('.updown').childNodes[1].value;
	let currentPrice = currentItem.closest('.subdiv').childNodes[1].childNodes[1].value;
	console.log(currentQty,currentPrice);
	
	// icon태그 클래스를 관리해주는 classList를 이용해 갯수 변동되게 작용
	if(currentItem.classList[2]=='down'){
		changeQty = parseInt(currentQty)-1;
		currentItem.closest('.updown').childNodes[1].value = changeQty;
	}
	else{
		changeQty = parseInt(currentQty)+1
		currentItem.closest('.updown').childNodes[1].value = changeQty;
	}
	
	// ajax (위에서 변경된 값을 DB에 반영 > object 형식으로 넘길 값 지정 )
	fetch('../cartUpdate.do',{	//서블릿호출
		method : 'post',
		headers : {'Content-type':'application/x-www-form-urlencoded'},
		body : 'no='+no+'&qty'+changeQty
	})	
	.then(result => result.text())
	.then(result => console.log(result))
	.catch(err => console.log(err))	
}


//호출로 실행
makeList();
