
var objarray=[];

function newbook(bookname, bookprice){
    this.bookname=bookname;
    this.bookprice=bookprice;
}

$("#addtocart").on("click", function(){
    var book= new newbook($("#bookname").val(), $("#bookprice").val());
    objarray.push(book);
    addbook(book);
});

function addbook(book){
    $.parseJSON(JSON.stringify(book));
    var tr="";
    tr+="<tr id='TRID'><td class='bookname'>'"+book.bookname+"'></td>";
    tr+="<td class='bookprice'>"+book.bookprice+"'></td>";
    tr+="</tr>";
    $("#tbl > tbody").append(tr);
}
