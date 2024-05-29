'use strict'

//let row_click = () => {
////    window.onload = function () {
//        console.log(id);
//        console.log('クリック');
//
//
////    }
//}

function row_click(){
    console.log('クリック');
    const product_id = document.querySelectorAll("iframe[my_radio]");
    product_id.
}

function Document_CreateRadioButton(document , name, value){
	var element;
	try{
		element = document.createElement('<input name="' + name.replace(/"/g,"&quot;") + '">');
	}catch(e){
	}
	if(!element){
		element = document.createElement("input");
		element.name = name;
		element.value = value;
	}
	element.type = "radio";
	return element;
}

const table_display =() =>{
    fetch(`/api/products`)
        .then(res => {
           let table = document.createElement('table');
           table.id='product-table';
            table.setAttribute("border", "1");
            if(res.status === 400) {
                document.getElementById('message').textContent
            }
            else {
                res.json()
                .then(data => {
                    for (let i = 0; i < data.length+1; i++) {
                        // tr要素を生成
                        let tr = document.createElement('tr');
                        let label = document.createElement('label')
                        // th・td部分のループ
                        for (let j = 0; j < 4; j++) {
                        // 1行目のtr要素の時
                            if(i === 0) {
                              // th要素を生成
                                let th = document.createElement('th');
                                // th要素内にテキストを追加
                                switch (j) {
                                    case 0:
                                        th.textContent="ID";
                                    break;

                                    case 1:
                                        th.textContent = '名前';
                                    break;

                                    case 2:
                                        th.colSpan ="2";
                                        th.textContent = '値段';
                                    break;
                                }
                                // th要素をtr要素の子要素に追加
                                tr.appendChild(th);
                            }
                            else {
                                // td要素を生成
                                var td = document.createElement('td');
                                // td要素内にテキストを追加
                                switch (j) {
                                    case 0:
                                        td.textContent = data[i-1].id;
                                    break;

                                     case 1:
                                       td.textContent = data[i-1].name;
                                     break;

                                     case 2:
                                       td.textContent = data[i-1].price;
                                     break;

                                     case 3:

                                        td = Document_CreateRadioButton(document, "my_radio", data[i-1].id);
                                        td.onclick = row_click();

                                     break;
                                }
                                  // td要素をtr要素の子要素に追加]
                                  tr.appendChild(td);
//                                  label.appendChild(td);

                            }
//                            tr.appendChild(label);
                        }

                    // tr要素をtable要素の子要素に追加
                    table.appendChild(tr);
                    }
                // 生成したtable要素を追加する
                 document.getElementById('productId').innerHTML="";
                 document.getElementById('productId').appendChild(table);
                 })
               }
    });
 }

 table_display();
//row_click();


 const product_add = () =>{


     const product = {
         name: document.getElementById('name').value,
         price: document.getElementById('price').value,
     }

     fetch('/api/product', {
       method: 'POST', // or 'PUT'
       headers: {
         'Content-Type': 'application/json',
       },
       body: JSON.stringify(product),
     })
     .then(res => {
        console.log(res)
        if(res.status === 400) {
              res.json()
              .then(data => {
                // errosの配列にメッセージが格納されている
//                data.errors.forEach(e => console.log(e.defaultMessage))
                let span = document.createElement('span');
                document.getElementById('error_name').appendChild(span);
                data.errors.forEach(e => span.textContent=e.defaultMessage);
//                data.errors.forEach(e => document.getElementById('error_name').textContent=(e.defaultMessage))
//                data.errors.forEach(e => document.getElementById('error_price').textContent=(e.defaultMessage))
              })
        }else{
            table_display();
        }
     })


 }