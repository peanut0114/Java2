function number_format(amount) {
	return new Intl.NumberFormat('ko-KR', {
		style: 'currency',
		currency: 'KRW'
	}).format(amount);
}

// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
	if (this == 0) return 0;
	let regex = /(^[+-]?\d+)(\d{3})/;
	let nstr = (this + '');
	while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
	return nstr;
};

// 1,000,000 => 1000000
console.log('1,000,000'.replace(/,/g, ''))

let basket = {
	cartCount: 0,
	cartTotal: 0,

	cartList: function () {
		//fetch, $.ajax  <= petSHop 참조
		//템플릿리터럴(``)을  이용하거나  cloneNode()로 노드를 복사해서 append
		fetch("../cartSelectList")
			.then(response => response.json())
			.then(result => this.makeList(result))
			.catch(err => console.log(err));
	},

	makeList: function (result) {

		console.log(result);
		let basket = document.querySelector("#basket");
		let cartTemplate = document.querySelector("#template");

		for (i = 0; i < result.length; i++) {

			let rowDiv = cartTemplate.childNodes[1].cloneNode(true);
			rowDiv.setAttribute('data-id', result[i].no);
			rowDiv.querySelector('div.pname span').textContent = result[i].product_nm;
			rowDiv.querySelector('div.basketprice input[name="p_price"]').value = result[i].price;
			rowDiv.querySelector('div.basketprice').childNodes[2].textContent = (result[i].price).formatNumber();
			rowDiv.querySelector('div.num input').value = result[i].qty;
			rowDiv.querySelector('div.sum').textContent = (result[i].qty * result[i].price).formatNumber();
			// rowDiv.querySelector('div.basketcmd>a').href = 'javascript:void(0)';
			rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('id', 'p_num' + result[i].no);
			rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('name', 'p_num' + result[i].no);
			rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('onkeyup', 'javascript:basket.changePNum(' + result[i].no + ')');
			rowDiv.querySelector('div.num>div.updown>span:nth-of-type(1)').setAttribute('onclick', 'javascript:basket.changePNum(' + result[i].no + ')');
			rowDiv.querySelector('div.num>div.updown>span:nth-of-type(2)').setAttribute('onclick', 'javascript:basket.changePNum(' + result[i].no + ')');
			basket.appendChild(rowDiv);
			this.reCalc();
		}
	},

	delItem: function (e) {
		console.log('delItem:', e);
		let no = e.target.parentNode.parentNode.parentNode.dataset.id;
		let url = "../cartDelete?no=" + no;
		console.log(url);
		fetch(url)
			.then(result => {
				//선택한 버튼의 상품을 삭제.. 버튼.closet(".row").remove();
				e.target.closest('.row').remove();
				this.reCalc();
			})
			.catch(err => console.log(err))

	},

	reCalc: function () {
		//수량, 금액 합계 계산
		//합계 자리에 출력
		var cartTotal = 0;
		var cartCount = 0;
		document.querySelectorAll('#basket>div.data').forEach(function (item) {
			if (item.querySelector('input[type="checkbox"]').checked) {
				checkCnt = item.querySelector('div.num input[name="p_num' + item.dataset.id + '"]');
				if (checkCnt) {

					//console.log(checkCnt);

					checkItem = item.querySelector('div.sum');

					var strToNum = checkItem.textContent.replace(/,/g, '');
					var strToCnt = checkCnt.value;

					cartTotal += parseInt(strToNum);
					cartCount += parseInt(strToCnt);
				}
			}
		})
		this.cartTotal = cartTotal;
		this.cartCount = cartCount;
		document.querySelector('#sum_p_num>span').textContent = (cartCount).formatNumber();
		document.querySelector('#sum_p_price>span').textContent = (cartTotal).formatNumber();

	},

	changePNum: function (pos) {
		var currentElem = event.target;
		var val = 1; // 변경수량.
		var currentQty = currentElem.parentNode.parentNode.childNodes[1].value;
		var currentPrice = currentElem.parentNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[1].value;
		if (currentElem.classList[2] == 'down')
			val = currentQty == 1 ? 0 : (val * -1);
		// 수량변경.
		var calQty = parseInt(currentQty) + val;
		if (val) {

			// ajax call.
			fetch('../cartUpdate', {
					method: 'post',
					headers: {
						'Content-type': 'application/json;charset=utf-8'
					},
					body: JSON.stringify({
						no: pos,
						qty: calQty
					})
				})
				.then(response => response.text())
				.then(result => console.log(result))
				.catch(err => console.log(err));

			currentElem.parentNode.parentNode.childNodes[1].value = calQty;
			// 수량 * 금액 => 재계산.
			var calAmount = calQty * currentPrice;
			currentElem.parentNode.parentNode.parentNode.parentNode.childNodes[5].textContent = (calAmount).formatNumber();

			this.reCalc();
		}
	},

	changePNum1: function (val) {
		var currentElem = event.target;
		var currentQty = currentElem.parentNode.parentNode.childNodes[1].value;
		var currentPrice = currentElem.parentNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[1].value;
		if (currentElem.classList[2] == 'down')
			val = currentQty == 1 ? 0 : (val * -1);
		// 수량변경.
		var calQty = parseInt(currentQty) + val;
		currentElem.parentNode.parentNode.childNodes[1].value = calQty;
		// 수량 * 금액 => 재계산.
		var calAmount = calQty * currentPrice;
		currentElem.parentNode.parentNode.parentNode.parentNode.childNodes[5].textContent = (calAmount).formatNumber();

		this.reCalc();
	},

	delCheckedItem: function () {
		document.querySelectorAll('#basket div.subdiv>div.check>input[type="checkbox"]:checked').forEach(function (item) {
			console.log(item)
			no = item.parentElement.parentElement.parentElement.dataset.id;
			let url = "../cartDelete?no=" + no;

			fetch(url)
				.then(result => {
					console.log(result.text());
					//선택한 버튼의 상품을 삭제.. 버튼.closet(".row").remove();
					// e.target.closest('.row').remove();
					item.parentElement.parentElement.parentElement.remove();
				})
				.catch(err => console.log(err))

		})
		this.reCalc();
	},

	delAllItem: function () {
		document.querySelectorAll('div.subdiv>div.check>input[type="checkbox"]').forEach(function (item) {
			item.parentElement.parentElement.parentElement.remove();
		})
		this.reCalc();
	},
};

basket.cartList();